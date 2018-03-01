package com.tjbool.httpwww.sparetimeapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.activity.UserInfoActivity;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * description: 我的
 * autour: TMM
 * date: 2018/1/16 18:05
 * update: 2018/1/16
 * version:
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.img_head_circle_one)
    CircleImageView imgHeadCircleOne;
    @BindView(R.id.text_name_fragment_mine)
    TextView textNameFragmentMine;
    @BindView(R.id.ll_info_fragment_mine)
    LinearLayout linearLayout;


    public static MyFragment newInstance(String title) {
        MyFragment f = new MyFragment();
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
        return R.layout.fragment_mine;
    }

    @OnClick({R.id.ll_info_fragment_mine})
    public void initClick(View view){
        switch (view.getId()){
            case R.id.ll_info_fragment_mine :
                Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                startActivity(intent);
                break;
            default:
        }

    }



}
