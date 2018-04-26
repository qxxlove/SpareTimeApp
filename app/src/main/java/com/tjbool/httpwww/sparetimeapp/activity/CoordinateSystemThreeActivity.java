package com.tjbool.httpwww.sparetimeapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseActivity;
import com.tjbool.httpwww.sparetimeapp.custom.CustomMoveTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoordinateSystemThreeActivity extends BaseActivity {

    @BindView(R.id.text_move_coordinate_three)
    CustomMoveTextView textMoveCoordinateThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_system_three);
        ButterKnife.bind(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("TextView","TestTextView 移动之前 上= "+textMoveCoordinateThree.getTop()+"下=  "+textMoveCoordinateThree.getBottom());
        Log.d("TextView","TestTextView 移动之前 左=  "+textMoveCoordinateThree.getLeft()+" 右 =  "+textMoveCoordinateThree.getRight());
    }

    @Override
    protected void initIntentParam(Intent intent) {

    }

    @Override
    protected void setToolbarStyle() {

    }
}
