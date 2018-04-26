package com.tjbool.httpwww.sparetimeapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * description: 坐标系学习
 * autour: TMM
 * date: 2018/3/27 16:13
 * update: 2018/3/27
 * version:
 */

public class CoordinateSystemActivity extends BaseActivity {

    @BindView(R.id.text_coordinate_activity)
    TextView textCoordinateActivity;
    @BindView(R.id.text_content_coordinate_activity_one)
    TextView textContentCoordinateActivityOne;
    @BindView(R.id.text_content_coordinate_activity_two)
    TextView textContentCoordinateActivityTwo;
    @BindView(R.id.text_content_coordinate_activity_three)
    TextView textContentCoordinateActivityThree;
    @BindView(R.id.text_content_coordinate_activity_four)
    TextView textContentCoordinateActivityFour;
    @BindView(R.id.text_content_coordinate_activity_zero)
    TextView textContentCoordinateActivityZero;
    @BindView(R.id.ll_coordinate_activity)
    LinearLayout llCoordinateActivity;
    @BindView(R.id.ll_content_coordinate_activity_one)
    TextView llContentCoordinateActivityOne;
    @BindView(R.id.ll_content_coordinate_activity_two)
    TextView llContentCoordinateActivityTwo;
    @BindView(R.id.ll_content_coordinate_activity_three)
    TextView llContentCoordinateActivityThree;
    @BindView(R.id.ll_content_coordinate_activity_four)
    TextView llContentCoordinateActivityFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_system);
        ButterKnife.bind(this);


        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
         textContentCoordinateActivityZero.setText("屏幕宽：with="+width+"屏幕高：height="+height);

         initClick();



    }

    private void initClick() {
        textContentCoordinateActivityZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CoordinateSystemActivity.this,CoordinateSystemTwoActivity.class);
            }
        });

    }


    /**
     * 获取时机，在onCreate（）是无法获取以下参数的，
     * 因为onMeasure,onLayout 方法都晚于onCreate()执行
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        textContentCoordinateActivityOne.setText("view自身的顶边到其父布局顶边的距离:getTop()==" + textCoordinateActivity.getTop());
        textContentCoordinateActivityTwo.setText("view自身的底边到其父布局顶边的距离:getBottom()==" + textCoordinateActivity.getBottom());
        textContentCoordinateActivityThree.setText("view自身的左边到其父布局左边的距离:getLeft()==" + textCoordinateActivity.getLeft());
        textContentCoordinateActivityFour.setText("view自身的右边到其父布局左边的距离:getRight()==" + textCoordinateActivity.getRight());

        llContentCoordinateActivityOne.setText("LinearLayout自身的顶边到其父布局顶边的距离:getTop()==" + llCoordinateActivity.getTop());
        llContentCoordinateActivityTwo.setText("LinearLayout自身的底边到其父布局顶边的距离:getBottom()==" + llCoordinateActivity.getBottom());
        llContentCoordinateActivityThree.setText("LinearLayout自身的左边到其父布局左边的距离:getLeft()==" + llCoordinateActivity.getLeft());
        llContentCoordinateActivityFour.setText("LinearLayout自身的右边到其父布局左边的距离:getRight()==" + llCoordinateActivity.getRight());


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        Log.d("信息","CoordinateSystemActivity中event的getX()="+x+"CoordinateSystemActivity中event的getY()"+y);
        Log.d("信息","CoordinateSystemActivity中event的getRawX()="+rawX+"CoordinateSystemActivity中event的getRawY()="+rawY);

        return super.onTouchEvent(event);
        
    }

    @Override
    protected void initIntentParam(Intent intent) {

    }

    @Override
    protected void setToolbarStyle() {

    }
}
