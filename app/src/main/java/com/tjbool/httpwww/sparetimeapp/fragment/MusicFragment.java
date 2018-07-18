package com.tjbool.httpwww.sparetimeapp.fragment;

import android.os.Bundle;
import android.util.Log;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;

/** 
 * description: 音乐
 * autour: TMM
 * date: 2018/1/16 18:05 
 * update: 2018/1/16
 * version: 
*/

public class MusicFragment extends BaseFragment {

    private static final String TAG = "MusicFragment";

    public static MusicFragment newInstance(String title) {
        MusicFragment f = new MusicFragment();
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
        return R.layout.fragment_work;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG,"MusicFragment 的onHiddenChanged = " +hidden);
    }
}
