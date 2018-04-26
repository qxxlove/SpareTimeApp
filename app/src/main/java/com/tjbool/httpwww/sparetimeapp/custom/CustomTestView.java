package com.tjbool.httpwww.sparetimeapp.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * description:自定义View 学习
 * autour: TMM
 * date: 2018/3/27 16:51
 * update: 2018/3/27
 * version:
*/
public class CustomTestView  extends View {
    public CustomTestView(Context context) {
        super(context);
    }

    public CustomTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 工作原理： 根据自身设置的属性（如: 字体，字体大小，颜色，背景）和
     *             父View传递过来的大小和模式最终确定自身的大小
     *             
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(),heightMeasureSpec));
    }

    /**
     * 一般空实现即可
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
