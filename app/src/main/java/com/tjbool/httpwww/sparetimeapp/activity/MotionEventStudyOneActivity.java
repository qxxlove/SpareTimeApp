package com.tjbool.httpwww.sparetimeapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.tjbool.httpwww.sparetimeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * description: 事件分发学习
 * autour: TMM
 * date: 2018/5/9 14:14
 * update: 2018/5/9
 * version:
 * 参考： https://mp.weixin.qq.com/s/zMWuHQg8szgT5cP_9UUHPQ
 *        https://www.jianshu.com/p/38015afcdb58
 *
 *        第一个是滚轮控件
 *        https://github.com/LinXiaoTao/WheelView
         第二个是之前参加活动的仿薄荷健康的卷尺控件，项目地址如下：
         https://github.com/LinXiaoTao/CustomViewProject
 *
*/




public class MotionEventStudyOneActivity extends AppCompatActivity {

    @BindView(R.id.btn_motionEvent_activity_one)
    Button btnMotionEventActivityOne;
    @BindView(R.id.btn_motionEvent_activity_two)
    Button btnMotionEventActivityTwo;
    @BindView(R.id.ll_motionEvent_activity)
    LinearLayout llMotionEventActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event_study_one);
        ButterKnife.bind(this);

        // 1.为ViewGroup布局设置监听事件
        llMotionEventActivity.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v)
        { Log.d("TAG", "点击了ViewGroup"); } });
        // 2. 为按钮1设置监听事件
        btnMotionEventActivityOne.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { Log.d("TAG", "点击了button1"); } });
        // 3. 为按钮2设置监听事件
        btnMotionEventActivityTwo.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { Log.d("TAG", "点击了button2"); } });





    }

    



}
