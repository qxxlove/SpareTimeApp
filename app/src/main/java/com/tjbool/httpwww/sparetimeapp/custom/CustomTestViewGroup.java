package com.tjbool.httpwww.sparetimeapp.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;

/** 
 * description: 自定义ViewGroup
 * autour: TMM
 * date: 2018/3/27 17:10 
 * update: 2018/3/27
 * version: 
*/

public class CustomTestViewGroup  extends ViewGroup {

    public CustomTestViewGroup(Context context) {
        super(context);
    }

    public CustomTestViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTestViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 切记：ViewGroup 并没有实现onMeasure
     *       那么肯定要问： 他是如何确认子view 的大小呢？
     *       此处能写出来，是因为ViewGroup 继承 View
     *
     *        ViewGroup 并没有实现onMeasure,但他的子类都有各自的实现，子类通常都是通过类似
     *        measureChildWithMargins()的方法来便利测量所有的子View (被GONE 掉的将不参与测量)
     *        测量完之后，然后根据父View的模式和大小最终决定自身的大小
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
          // 测量所有的子View
        // measureChildWithMargins();
        // 确认大小
       // setMeasuredDimension();
        
    }

    /**
     * 循环遍历所有的子View ,从而确定其摆放位置
     *    onLayout （） 中的参数都是由父view 提供的
     *    子View的位置通常还受有其他属性左右，例如父View的orientation，gravity，自身的margin等等，
     *         影响布局的因素非常多。
     *    onLayout比layout多一个参数，changed，
     *    该参数是在setFrame通过比对上次的位置得出是否发生了变化，
     *    通常该参数没有被使用的意义，
     *    因为父View位置和大小不变，并不能代表子View的位置和大小没有发生改变。
     * @param changed
     * @param i
     * @param i1
     * @param i2
     * @param i3
     */
    @Override
    protected void onLayout(boolean changed, int i, int i1, int i2, int i3) {

    }


    /**
     *   这些都是内部的处理逻辑，系统已经帮我们做好了
     *       先根据自身的padding剪裁画布，所有的子View都将在画布剪裁后的区域绘制。
             遍历所有子View，调用子View的computeScroll对子View的滚动值进行计算。
             根据滚动值和子View在父View中的坐标进行画布原点坐标的移动，
            根据子在父View中的坐标计算出子View的视图大小，然后对画布进行剪裁，请看下面的示意图。
            dispatchDraw的逻辑其实比较复杂，
            但是幸运的是对子View流程都采用该方式，
            而ViewGroup已经处理好了，我们不必要重载该方法对子View进行绘制事件的派遣分发。
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}


/**
 * requestLayout  重新调用他的onMeasure onLayout来重新设置自己位置
 * postInvalidate 与 invalidate
 *     
 */
