package com.tjbool.httpwww.sparetimeapp.fragment;

import android.os.Bundle;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/1/19.
 * 邮箱：123123@163.com
 */

public class UserTitleFragment extends BaseFragment {

    public static UserTitleFragment newInstance(String title) {
        UserTitleFragment f = new UserTitleFragment();
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
        return R.layout.fragment_title_user;
    }
}
