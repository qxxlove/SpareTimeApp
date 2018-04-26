package com.tjbool.httpwww.sparetimeapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseApi;
import com.tjbool.httpwww.sparetimeapp.custom.RequestDateAsyncTask;
import com.tjbool.httpwww.sparetimeapp.entity.EventErrorDeal;
import com.tjbool.httpwww.sparetimeapp.entity.FaultUCompleteEntity;
import com.tjbool.httpwww.sparetimeapp.utils.BaseUtils;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;
import com.tjbool.httpwww.sparetimeapp.weight.ProgressDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/** 
 * description: skoap协议
 * autour: TMM
 * date: 2018/3/27 15:59 
 * update: 2018/3/27
 * version: 
*/

public class SoapTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soap_test);
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getData(1,null,null);
       // HttpRequestAllMessage();
    }

    /**
     * 加载数据
     * @param page
     */
    private void getData(int page,String processStatus,String carNumber) {
        showProgressDialog(BaseUtils.getString(R.string.loading));
        Map<String, String> map = new LinkedHashMap<>();
        map.put("depid", "33");
        map.put("usrid", "141");
        map.put("carnum",carNumber);
        map.put("carModelNum",null);
        map.put("carType",null);
        map.put("company",null);
        map.put("vehicletype",null);
        map.put("begintime",null);
        map.put("endtime",null);
        map.put("sysCode",null);
        map.put("faultlevel",null);
        map.put("faultType",null);
        map.put("processStatus",processStatus);
        map.put("PageIndex",String.valueOf(page));
        map.put("RecordCount","10");

        try {
            RequestDateAsyncTask requestDateAsyncTask = new RequestDateAsyncTask(BaseApi.GETUCOMPLETEFAULT, map);
            requestDateAsyncTask.execute(new URL(BaseApi.CAR_URL));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }


    private void HttpRequestAllMessage() {
        showProgressDialog(BaseUtils.getString(R.string.loading));
        Map<String, String> map = new LinkedHashMap<>();
        map.put("usrid", "141");

        try {
            RequestDateAsyncTask requestDateAsyncTask = new RequestDateAsyncTask(BaseApi.GETPUSHMESSAGE, map);
            requestDateAsyncTask.execute(new URL(BaseApi.CAR_URL));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(FaultUCompleteEntity postInfo) {
        hideProgressDialog();
        if (postInfo.isIsSuccess()){
            ToastUtils.showShortToast(postInfo.getMessagecode());
        } else {
            ToastUtils.showShortToast(postInfo.getMessagecode());
        }


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String postInfo) {
        hideProgressDialog();
            ToastUtils.showShortToast(postInfo);
    }



    /**
     * 错误处理
     * @param eventErrorDeal
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConetntEvent(EventErrorDeal eventErrorDeal) {
        switch (eventErrorDeal.getMethod()) {
            case BaseApi.GETUCOMPLETEFAULT:
                    hideProgressDialog();
                    ToastUtils.showShortToast(eventErrorDeal.getContent());
                break;
            case BaseApi.GETPUSHMESSAGE:
                hideProgressDialog();
                ToastUtils.showShortToast(eventErrorDeal.getContent());
                break;
            default:
        }
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



    private ProgressDialog mProfressDialog = null;

    public void showProgressDialog(String notice) {
        if(mProfressDialog == null) {
            mProfressDialog = new ProgressDialog(this,notice);
        }
        else{
            hideProgressDialog();
            mProfressDialog = new ProgressDialog(this,notice);
        }
    }

    public void showProgressDialog(boolean isCanceledOnTouchOutside) {
        if(mProfressDialog == null) {
            mProfressDialog = new ProgressDialog(this, isCanceledOnTouchOutside,"");
        }
        else{
            hideProgressDialog();
            mProfressDialog = new ProgressDialog(this, isCanceledOnTouchOutside,"");
        }
    }

    public void hideProgressDialog() {
        if (mProfressDialog != null) {
            mProfressDialog.destroyProgressDialog();
            mProfressDialog = null;
        }
    }



}
