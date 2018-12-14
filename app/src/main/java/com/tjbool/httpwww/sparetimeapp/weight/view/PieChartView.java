package com.tjbool.httpwww.sparetimeapp.weight.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.tjbool.httpwww.sparetimeapp.entity.PieChartData;

import java.util.List;

/**
 * 待完善
 */
public class PieChartView  extends View {

    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private List<PieChartData> mData;
    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();

    public PieChartView(Context context) {
        this(context,null);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        Log.e("PieChartView","宽："+mWidth+"******高："+mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData){
            return;
        }
        /**如何任意确定矩形的大小范围*/
        float currentStartAngle = mStartAngle;                    // 当前起始角度
       // canvas.translate(mWidth / 2, mHeight / 2);                // 将画布坐标原点移动到中心位置
       // float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);  // 饼状图半径
        float r = (float) mWidth / 2;
        //RectF rect = new RectF(-r, -r, r, r);                     // 饼状图绘制区域
        RectF rect = new RectF(0, 0, mWidth, mHeight);
        
        for (int i = 0; i < mData.size(); i++) {
            PieChartData pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rect, currentStartAngle, pie.getAngle(), true, mPaint);
            currentStartAngle += pie.getAngle();
        }

    }

    
    /**
     * 设置起始角度
     * @param mStartAngle
     */
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();   // 刷新
    }

    
    /**
     *  设置数据
     * @param mData
     */
    public void setData(List<PieChartData> mData) {
        this.mData = mData;
        initData(mData);
        invalidate();   // 刷新
    }

   

    /**
     * 初始化数据
     * @param mData
     */
    private void initData(List<PieChartData> mData) {
        if (null == mData || mData.size() == 0) {  // 数据有问题 直接返回
                return;
            }

        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieChartData pie = mData.get(i);

            //计算数值和
            sumValue += pie.getValue();

            int j = i % mColors.length;       //设置颜色
            pie.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieChartData pie = mData.get(i);

            float percentage = pie.getValue() / sumValue;   // 百分比
            float angle = percentage * 360;                 // 对应的角度

            pie.setPercentage(percentage);                  // 记录百分比
            pie.setAngle(angle);                            // 记录角度大小
            sumAngle += angle;

            Log.i("PieChartView", "angle:" + pie.getAngle());
            Log.i("PieChartView", "sumAngle:" + sumAngle);

        }
    }
}
