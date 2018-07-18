package com.tjbool.httpwww.sparetimeapp.fragment;

import android.os.Bundle;
import android.util.Log;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;

/** 
 * description: 游戏
 * autour: TMM
 * date: 2018/1/16 18:05 
 * update: 2018/1/16
 * version: 
*/

public class GameFragment extends BaseFragment {

    public static GameFragment newInstance(String title) {
        GameFragment f = new GameFragment();
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
        return R.layout.fragment_game;
    }



    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        Log.e(getClass().getSimpleName(), "GameFragment (此时可用)lazyLoadData");
    }
}
