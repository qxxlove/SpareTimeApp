package com.tjbool.httpwww.sparetimeapp.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/** 
 * description: 自定义LinearLayout 获取相应的位置
 * autour: TMM
 * date: 2018/3/28 16:43 
 * update: 2018/3/28
 * version: 
*/

public class CustomLinearlayout  extends LinearLayout {
    public CustomLinearlayout(Context context) {
        super(context);
    }

    public CustomLinearlayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearlayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     *   D/信息: 点击事件相对于LinearLayout的左边的距离=79.0点击事件相对于LinearLayout的顶边的距离=365.0
         D/信息: 点击事件相对于整个屏幕的左边的距离=99.0点击事件相对于整个屏幕的顶边的距离=515.0
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        Log.d("信息","点击事件相对于LinearLayout的左边的距离="+x+"点击事件相对于LinearLayout的顶边的距离="+y);
        Log.d("信息","点击事件相对于整个屏幕的左边的距离="+rawX+"点击事件相对于整个屏幕的顶边的距离="+rawY);
        return super.onTouchEvent(event);
    }

   
}
