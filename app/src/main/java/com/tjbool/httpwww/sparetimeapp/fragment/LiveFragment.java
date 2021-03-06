package com.tjbool.httpwww.sparetimeapp.fragment;

import android.os.Bundle;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;

/** 
 * description: 直播
 * autour: TMM
 * date: 2018/1/16 18:05 
 * update: 2018/1/16
 * version: 
*/

public class LiveFragment extends BaseFragment {

    public static LiveFragment newInstance(String title) {
        LiveFragment f = new LiveFragment();
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
        return R.layout.fragment_live;
    }
}
