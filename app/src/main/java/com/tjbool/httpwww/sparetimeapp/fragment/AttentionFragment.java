package com.tjbool.httpwww.sparetimeapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;
import com.tjbool.httpwww.sparetimeapp.utils.NetWorkUtils;

import butterknife.BindView;

/**
 * description: 关注
 * autour: TMM
 * date: 2018/1/16 18:04
 * update: 2018/1/16
 * version:
 */

public class AttentionFragment extends BaseFragment {
    private static final String TAG = "AttentionFragment";
    @BindView(R.id.text_within_ip)
    TextView textWithinIp;
    @BindView(R.id.text_abroad_ip)
    TextView textAbroadIp;
 

    public static AttentionFragment newInstance(String title) {
        AttentionFragment f = new AttentionFragment();
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
          textWithinIp.setText("内网IP:"+NetWorkUtils.getWithinIp());
        //  textAbroadIp.setText("外网IP:"+NetWorkUtils.getAbraodIp());
        textAbroadIp.setText("IP:"+NetWorkUtils.getIPAddress(getActivity()));
    }

    @Override
    protected void initView() {

    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_attention;
    }

    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        if (isViewCreated) {
            Log.e(getClass().getSimpleName(), "AttentionFragment 的 lazyLoadData");
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "AttentionFragment 的onHiddenChanged = " + hidden);
    }

   
}
