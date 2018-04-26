package com.tjbool.httpwww.sparetimeapp.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/** 
 * description: Canvas 画布学习一
 * autour: TMM
 * date: 2018/4/16 16:20 
 * update: 2018/4/16
 * version: 
*/

public class CanvasStudyOne   extends View {

    private Paint mPaintArc;
    private Paint mPaintRectF ; 



    public CanvasStudyOne(Context context) {
        this(context,null);
    }

    public CanvasStudyOne(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvasStudyOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaintArc = new Paint();
        mPaintArc.setAntiAlias(true);//取消锯齿
        mPaintArc.setStyle(Paint.Style.STROKE);
        mPaintArc.setStrokeWidth(3);
        mPaintArc.setColor(Color.CYAN);

        mPaintRectF = new Paint();
        mPaintRectF.setAntiAlias(true);
        mPaintRectF.setColor(Color.RED);
        mPaintRectF.setStyle(Paint.Style.STROKE);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 这是一个居中的圆
         */
       // float x = (getWidth() - getHeight() / 2) / 2;
        //float y = getHeight() / 4;

        RectF oval = new RectF( 100, 100, 300, 300);


        canvas.drawArc(oval,-90,-140,false,mPaintArc);
        canvas.drawRect(oval,mPaintRectF);
    }
}
