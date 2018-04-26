package com.tjbool.httpwww.sparetimeapp.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/** 
 * description: 自定义TextView 获取相应的位置
 * autour: TMM
 * date: 2018/3/28 16:43 
 * update: 2018/3/28
 * version: 
*/

public class CustomTextViewEvent extends TextView {
    public CustomTextViewEvent(Context context) {
        super(context);
    }

    public CustomTextViewEvent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextViewEvent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * D/信息: 点击事件相对于TextView的左边的距离= 93.0  相对于TextView的顶边的距离= 115.0
      D/信息: 点击事件相对于整个屏幕的左边= 213.0  点击事件相对于整个屏幕的顶边=  365.0

      D/信息: 点击事件相对于LinearLayout的左边的距离= 193.0  点击事件相对于LinearLayout的顶边的距离= 215.0
     D/信息: 点击事件相对于整个屏幕的左边的距离= 213.0  点击事件相对于整个屏幕的顶边的距离= 365.0

     切记使用 getX , getY 前提是先搞清楚你获取的MotionEvent所在的View是哪个。
     如果是在TextView，那么getY就是距离TextView顶部的距离，
     如果在Activity，那么getY就是距离Activity根布局的顶部的距离，
     而getRaw*就不会受这个影响

     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        Log.d("信息","点击事件相对于TextView的左边的距离="+x+"相对于TextView的顶边的距离="+y);
        Log.d("信息","点击事件相对于整个屏幕的左边="+rawX+"点击事件相对于整个屏幕的顶边="+rawY);
        return super.onTouchEvent(event);
    }
    
}
