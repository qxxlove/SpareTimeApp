package com.tjbool.httpwww.sparetimeapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.activity.AnimationStudyActivity;
import com.tjbool.httpwww.sparetimeapp.activity.SingleMutileActivity;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;

import butterknife.OnClick;

/** 
 * description: 科技
 * autour: TMM
 * date: 2018/1/16 18:05 
 * update: 2018/1/16
 * version: 
*/

public class ScienceFragment extends BaseFragment {

    private  Intent intent;


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

    
    @OnClick({R.id.text_one_single_activity,R.id.text_animation_activity})
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
           
            default:
        }
    }



}
