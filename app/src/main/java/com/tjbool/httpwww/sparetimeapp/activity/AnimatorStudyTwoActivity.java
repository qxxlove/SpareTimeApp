package com.tjbool.httpwww.sparetimeapp.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.custom.ColorChangeEvalator;
import com.tjbool.httpwww.sparetimeapp.custom.MyCricleViewTwo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * description: 自定义objectAnimator
 * autour: TMM
 * date: 2018/5/14 15:41
 * update: 2018/5/14
 * version:
 * <p>
 * 从下文得知：我们传入的属性 color ，并提供get/set方法
 * 步骤： 我们直接继承原始类，给该属性加上get/ set 方法
 * <p>
 * 还有一种方法就是通过 用一个类来包装原始类
 * 即： 装饰者模式
 */


public class AnimatorStudyTwoActivity extends AppCompatActivity {

    @BindView(R.id.myCricleViewTwo)
    MyCricleViewTwo myCricleViewTwo;
    @BindView(R.id.text_objectAnimator)
    TextView textObjectAnimator;
    @BindView(R.id.text_animate_one)
    TextView textAnimateOne;

    ViewWrapper wrapper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_study_two);
        ButterKnife.bind(this);

        initMyCircleView();
        initTextView();
        initView();

    }

    /**
     *   ViewPropertyAnimator的功能建立在animate()上
     *    调用animate()方法返回值是一个ViewPropertyAnimator对象,之后的调用的所有方法都是通过该实例完成
     *   调用该实例的各种方法来实现动画效果
     *   ViewPropertyAnimator所有接口方法都使用连缀语法来设计，
     *   每个方法的返回值都是它自身的实例
     *    因此调用完一个方法后可直接连缀调用另一方法,即可通过一行代码就完成所有动画效果
     */
    private void initView() {
       // textAnimateOne.animate().alpha(0f);
        // 单个动画效果设置 & 参数设置
       // textAnimateOne.animate().alpha(0f).setDuration(5000).setInterpolator(new BounceInterpolator());
        // 组合动画:将按钮变成透明状态再移动到(500,500)处
        textAnimateOne.animate().alpha(0.2f).x(500).y(500);




    }

    private void initTextView() {
        wrapper = new ViewWrapper(textObjectAnimator);
        textObjectAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator.ofInt(wrapper, "width", 500)
                        .setDuration(3000)
                        .start();
            }
        });
    }

    private void initMyCircleView() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(myCricleViewTwo,
                "color", new ColorChangeEvalator(), "#0000FF", "#FF0000");

        objectAnimator.setDuration(8000);
        // objectAnimator.setRepeatCount(Animator.DURATION_INFINITE);
        objectAnimator.start();


        // 动画执行的监听
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });


        // 省略不必要的方法，可自行实现
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }
        });

    }


    /**
     * 提供ViewWrapper类,用于包装View对象 // 本例:包装Button对象
     */
    private static class ViewWrapper {
        private View mTarget;

        /**
         * 构造方法:传入需要包装的对象
         *
         * @param target
         */
        public ViewWrapper(View target) {
            mTarget = target;
        }

        /**
         * 为宽度设置get（） & set（）
         */
        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }
    }


}
