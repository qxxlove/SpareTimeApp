package com.tjbool.httpwww.sparetimeapp.weight.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.tjbool.httpwww.sparetimeapp.R;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/12/12.
 * 邮箱：123123@163.com
 */

public class CheckView extends View {


    private static final int ANIM_NULL = 0;         //动画状态-没有
    private static final int ANIM_CHECK = 1;        //动画状态-开启
    private static final int ANIM_UNCHECK = 2;      //动画状态-结束

    private Context mContext;           // 上下文
    private int mWidth, mHeight;        // 宽高
    private Handler mHandler;           // handler
    private Handler.Callback mCallback;

    private Paint mPaint;
    private Bitmap okBitmap;

    private int animCurrentPage = -1;       // 当前页码
    private int animMaxPage = 13;           // 总页数
    private int animDuration = 500;         // 动画时长
    private int animState = ANIM_NULL;      // 动画状态

    private boolean isCheck = false;        // 是否只选中状态

    

    public CheckView(Context context) {
        this(context,null);
    }

    public CheckView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CheckView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化
     * @param context
     */
    private void init(Context context) {
        mContext = context;

        mPaint = new Paint();
        mPaint.setColor(0xffFF5317);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        okBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.icon_checkmark);

        mCallback = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                if (animCurrentPage < animMaxPage && animCurrentPage >= 0) {
                    if (animState == ANIM_NULL)  {
                        return false;
                    }
                    if (animState == ANIM_CHECK) {
                        animCurrentPage++;
                    } else if (animState == ANIM_UNCHECK) {
                        animCurrentPage--;
                    }
                    
                    //animCurrentPage为animMaxPage不需要更新，否则下面的else会导致绘制前一张图闪一下
                    if (animCurrentPage != animMaxPage) {
                        invalidate();
                    }
                    mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
                    Log.e("AAA", "Count=" + animCurrentPage);
                } else {
                    if (isCheck) {
                        animCurrentPage = animMaxPage - 1;
                    } else {
                        animCurrentPage = -1;
                    }
                    //invalidate();
                    animState = ANIM_NULL;
                }
                return false;
            }
        };
        mHandler = new Handler(mCallback);
    }


    /**
     * View大小确定
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e("CheckView","宽："+mWidth+"******高："+mHeight);
        mWidth = w;
        mHeight = h;
    }

    /**
     * 绘制内容
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 移动坐标系到画布中央
        canvas.translate(mWidth / 2, mHeight / 2);

        // 绘制背景圆形
        canvas.drawCircle(0, 0, 100, mPaint);

        // 得出图像边长
        int sideLength = okBitmap.getHeight();
        int sideWide = okBitmap.getWidth();

        Log.e("CheckView","图像边长："+sideLength);
        Log.e("CheckView","图像宽："+sideWide);

        // 得到要绘制的图像选区
        Rect src = new Rect(sideLength * animCurrentPage, 0, sideLength * (animCurrentPage + 1), sideLength);
        // 图像实际的绘制位置
        Rect dst = new Rect(-100, -100, 100, 100);

        // 绘制
        canvas.drawBitmap(okBitmap, src, dst, null);
    }


    /**
     * 选择
     */
    public void check() {
        if (animState != ANIM_NULL || isCheck){
            return;
        }
        animState = ANIM_CHECK;
        animCurrentPage = 0;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isCheck = true;
    }

    /**
     * 取消选择
     */
    public void unCheck() {
        if (animState != ANIM_NULL || (!isCheck)) {
            return;
        }
        animState = ANIM_UNCHECK;
        animCurrentPage = animMaxPage - 1;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isCheck = false;
    }

    /**
     * 设置动画时长
     * @param animDuration
     */
    public void setAnimDuration(int animDuration) {
        if (animDuration <= 0){
            return;
        }
        this.animDuration = animDuration;
    }

    /**
     * 设置背景圆形颜色
     * @param color
     */
    public void setmBackgroundColor(int color){
        mPaint.setColor(color);
    }
}
