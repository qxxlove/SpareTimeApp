package com.tjbool.httpwww.sparetimeapp.custom;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/3/28.
 * 邮箱：123123@163.com
 */

public class CustomMoveTextView extends TextView {

    public CustomMoveTextView(Context context) {
        super(context);
    }

    public CustomMoveTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMoveTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

          switch (event.getAction()){
              case MotionEvent.ACTION_DOWN:

                    //① 通过layout 实现移动
                    layout(getLeft() + 200, getTop() + 400, getRight() + 200, getBottom() + 400);

                    // ②
                    //offsetLeftAndRight(200);
                    //offsetTopAndBottom(400);

                     // ③ LayoutParams
                  //ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
                 // lp.leftMargin = getLeft() + 200;
                 // lp.topMargin = getTop() + 400;
                  //setLayoutParams(lp);

                   // ④  切记： 移动计算值 = 最开始点坐标 - 最后移动到的坐标
                 // ((View)getParent()).scrollTo(-200,-400);

                   // ⑤ 为什么要加 (View)getParent()  ？   因为我们移动的是整个View,不是View的内容
                  //((View)getParent()).scrollBy(-200,-400);

                  // ⑥ 属性动画
                 // AnimatorSet set = new AnimatorSet();
                //  set.playTogether(
                  //        ObjectAnimator.ofFloat(this, "translationX", 200),
                 //         ObjectAnimator.ofFloat(this,"translationY", 400)

                 // );
               //   set.start();

                  // ⑦  位移动画
                //  TranslateAnimation anim = new TranslateAnimation(0,200,0,400);
                //  anim.setFillAfter(true);
                //  startAnimation(anim);


                    Log.d("TextView","TestTextView 移动之后 getX()= "+event.getX()+"移动之后 getY() =  "+event.getY());
                    Log.d("TextView","TestTextView 移动之后 getRawX()=  "+event.getRawX()+" 移动之后getRawY() =  "+event.getRawY());
                    Log.d("TextView","TestTextView 移动之后 上= "+getTop()+"下=  "+getBottom());
                    Log.d("TextView","TestTextView 移动之后 左=  "+getLeft()+" 右 =  "+getRight());
                  break;
                  default:
          }
        return super.onTouchEvent(event);
        
    }
}
