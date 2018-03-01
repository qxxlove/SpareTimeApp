package com.tjbool.httpwww.sparetimeapp.fragment;

import android.os.Bundle;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;

/** 
 * description: 视频
 * autour: TMM
 * date: 2018/1/16 18:06 
 * update: 2018/1/16
 * version: 
*/

public class VideoFragment extends BaseFragment {

    public static VideoFragment newInstance(String title) {
        VideoFragment f = new VideoFragment();
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
        return R.layout.fragment_video;
    }
}
