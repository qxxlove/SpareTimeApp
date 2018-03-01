package com.tjbool.httpwww.sparetimeapp.fragment;

import android.os.Bundle;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;

/** 
 * description: 科技
 * autour: TMM
 * date: 2018/1/16 18:05 
 * update: 2018/1/16
 * version: 
*/

public class ScienceFragment extends BaseFragment {

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
}
