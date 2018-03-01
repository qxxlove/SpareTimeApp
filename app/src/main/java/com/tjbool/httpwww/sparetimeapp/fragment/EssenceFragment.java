package com.tjbool.httpwww.sparetimeapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.activity.ApplyPermissionActivity;
import com.tjbool.httpwww.sparetimeapp.activity.ApplyPermissionTwoActivity;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * description: 精华
 * autour: TMM
 * date: 2018/1/16 18:05
 * update: 2018/1/16
 * version:
 */

public class EssenceFragment extends BaseFragment {

    public final String TAG = this.getClass().getSimpleName();


    @BindView(R.id.text_one_essence_fragment)
    TextView textOneEssenceFragment;


    public static EssenceFragment newInstance(String title) {
        EssenceFragment f = new EssenceFragment();
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
        return R.layout.fragment_essence;
    }


    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        Log.e(TAG, "lazyLoadData");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart 依然执行");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume 依然执行");
    }


    @OnClick({R.id.text_one_essence_fragment,R.id.text_two_essence_fragment})
    public  void   initClick(View view){
        switch (view.getId()){
            case R.id.text_one_essence_fragment:
                Intent intent = new Intent(getActivity(), ApplyPermissionActivity.class);
                startActivity(intent);
                break;
            case R.id.text_two_essence_fragment:
                Intent intent1 = new Intent(getActivity(), ApplyPermissionTwoActivity.class);
                startActivity(intent1);
                break;
            default:
        }
    }

}
