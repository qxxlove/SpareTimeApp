package com.tjbool.httpwww.sparetimeapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.activity.AnimationStudyActivity;
import com.tjbool.httpwww.sparetimeapp.activity.SingleMutileActivity;
import com.tjbool.httpwww.sparetimeapp.activity.StreetScapeActivity;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;
import com.tjbool.httpwww.sparetimeapp.utils.BaseUtils;
import com.tjbool.httpwww.sparetimeapp.utils.SystemDateTime;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;
import com.tjbool.httpwww.sparetimeapp.utils.screen.DimenTypes;
import com.tjbool.httpwww.sparetimeapp.utils.screen.MakeUtils;
import com.tjbool.httpwww.sparetimeapp.weight.CustomPopupWindowOne;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;

/** 
 * description: 科技
 * autour: TMM
 * date: 2018/1/16 18:05 
 * update: 2018/1/16
 * version: 
*/

public class ScienceFragment extends BaseFragment {


    @BindView(R.id.text_current_system_time)
    TextView  textViewCurrentTime;
    

    public static final String  TAG = "ScienceFragment";

    private  Intent intent;
    /**
     * 设计稿尺寸(根据自己设计师的设计稿的宽度填入)
     */
    private static final int DESIGN_WIDTH = 375;


    public static ScienceFragment newInstance(String title) {
        ScienceFragment f = new ScienceFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_science;
    }

    
    @OnClick({R.id.text_one_single_activity,R.id.text_animation_activity,R.id.text_show_popupWindow,
            R.id.text_street_scape_activity,R.id.text_make_dimens,R.id.text_update_system_time,
            R.id.text_get_update_system_time})
    public  void   initClick(View view){
        switch (view.getId()){
            case R.id.text_one_single_activity:
                intent = new Intent(getActivity(), SingleMutileActivity.class);
                startActivity(intent);
                break;
            case R.id.text_animation_activity:
                intent = new Intent(getActivity(), AnimationStudyActivity.class);
                startActivity(intent);
                break;
            case R.id.text_show_popupWindow:
                ToastUtils.showLongToast("点击了");
                CustomPopupWindowOne customPopupWindowOne = new CustomPopupWindowOne(getActivity());
                customPopupWindowOne.showPopupWindow();
                break;
            case R.id.text_street_scape_activity:
                intent = new Intent(getActivity(), StreetScapeActivity.class);
                startActivity(intent);
                break;
            case R.id.text_make_dimens:
                DimenTypes[] values = DimenTypes.values();
                for (DimenTypes value : values) {
                    MakeUtils.makeAll(DESIGN_WIDTH, value, Environment.getExternalStorageDirectory().getAbsolutePath()+"/dimens");
                }
                break;
            case R.id.text_update_system_time:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SystemDateTime.setTime(10,30);
                        } catch (IOException e) {
                            Log.e(TAG,"set  time  error  one") ;
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            Log.e(TAG,"set  time  error  one") ;
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
            case R.id.text_get_update_system_time:
                long l = System.currentTimeMillis();
                String currentTime =  BaseUtils.timeList(l);
                textViewCurrentTime.setText(currentTime);
                break;

            default:
        }
    }

    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        Log.e(getClass().getSimpleName(), "ScienceFragment (此时可用)lazyLoadData");

    }
}
