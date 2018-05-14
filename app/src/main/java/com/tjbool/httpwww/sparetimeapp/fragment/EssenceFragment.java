package com.tjbool.httpwww.sparetimeapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.activity.ApplyPermissionActivity;
import com.tjbool.httpwww.sparetimeapp.activity.ApplyPermissionTwoActivity;
import com.tjbool.httpwww.sparetimeapp.activity.CanvasStudyActivity;
import com.tjbool.httpwww.sparetimeapp.activity.CoordinateSystemActivity;
import com.tjbool.httpwww.sparetimeapp.activity.DaggerStudyActivity;
import com.tjbool.httpwww.sparetimeapp.activity.DaggerStudyTwoActivity;
import com.tjbool.httpwww.sparetimeapp.activity.MotionEventStudyOneActivity;
import com.tjbool.httpwww.sparetimeapp.activity.SoapTestActivity;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;
import com.tjbool.httpwww.sparetimeapp.layout.ConstraintLayoutStudyActivity;

import butterknife.BindView;
import butterknife.OnClick;

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


    @OnClick({R.id.text_one_essence_fragment,R.id.text_two_essence_fragment,R.id.text_soap_activity,
            R.id.text_coordinate_activity,R.id.text_canvas_one_activity,R.id.text_dagger_activity,
            R.id.text_dagger_two_activity,R.id.text_constraint_activity,R.id.text_motionEvent_one_activity})
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
            case R.id.text_soap_activity:
                Intent intent2 = new Intent(getActivity(), SoapTestActivity.class);
                startActivity(intent2);
                break;
            case R.id.text_coordinate_activity:
                Intent intent3 = new Intent(getActivity(), CoordinateSystemActivity.class);
                startActivity(intent3);
                break;
            case R.id.text_canvas_one_activity:
                Intent intent4 = new Intent(getActivity(), CanvasStudyActivity.class);
                startActivity(intent4);
                break;
            case R.id.text_dagger_activity:
                Intent intent5 = new Intent(getActivity(), DaggerStudyActivity.class);
                startActivity(intent5);
                break;
            case R.id.text_dagger_two_activity:
                Intent intent6 = new Intent(getActivity(), DaggerStudyTwoActivity.class);
                startActivity(intent6);
                break;
            case R.id.text_constraint_activity:
                Intent intent7 = new Intent(getActivity(), ConstraintLayoutStudyActivity.class);
                startActivity(intent7);
                break;
            case R.id.text_motionEvent_one_activity:
                Intent intent8 = new Intent(getContext(), MotionEventStudyOneActivity.class);
                startActivity(intent8);
                break;
            default:
        }
    }

}
