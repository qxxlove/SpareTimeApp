package com.tjbool.httpwww.sparetimeapp.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * description:   自定义View （渐变）
 * autour: TMM
 * date: 2018/5/14 15:05
 * update: 2018/5/14
 * version:
*/

public class MyCricleViewTwo extends View {

    // 设置需要用到的变量
    // 圆的半径 = 50
    public static final float RADIUS = 50f;
    // 绘图画笔
    private Paint mPaint;
    // 设置背景颜色属性
    private String color;

    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        // 将画笔的颜色设置成方法参数传入的颜色
        invalidate();
        // 调用了invalidate()方法,即画笔颜色每次改变都会刷新视图，然后调用onDraw()方法重新绘制圆
        // 而因为每次调用onDraw()方法时画笔的颜色都会改变,所以圆的颜色也会改变
        
    }





    
    public MyCricleViewTwo(Context context) {
        this(context,null);
    }

    public MyCricleViewTwo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyCricleViewTwo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        // 初始化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);

    }

   
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100, 100, RADIUS, mPaint);
    }
}
