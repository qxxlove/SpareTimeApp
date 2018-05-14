package com.tjbool.httpwww.sparetimeapp.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * description: 属性动画
 * autour: TMM
 * date: 2018/5/14 9:47
 * update: 2018/5/14
 * version:
 * <p>
 * 旋转动画： 按理说360度 应该是旋转一圈，为何会旋转两圈？
 * <p>
 * <p>
 * 注意： 实际开发中：至于如何采取Java代码还是xml文件，具体情况具体对待，
 * 我们一般有些值都是动态获取的，无法直接配置在xml文件写死
 */


public class AnimatorStudyActivity extends AppCompatActivity {


    @BindView(R.id.text_animator_set_one)
    TextView textAnimatorSetOne;
    @BindView(R.id.text_animator_set_two)
    TextView textAnimatorSetTwo;
    @BindView(R.id.text_valueAnimator_animator_one)
    TextView textValueAnimatorAnimatorOne;
    @BindView(R.id.text_objectAnimator_one)
    TextView textObjectAnimatorOne;
    @BindView(R.id.text_objectAnimator_two)
    TextView textObjectAnimatorTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_study);
        ButterKnife.bind(this);

        //initAnimatorSetByXml();
        // initAnimatorSetByJava();

        // ofInt 和 ofFloat 基本一致，不做重复。
        // 区别在于： ofInt 内部采用默认的 整型估值器（IntEvaluator）
        //            ofFloat  内部采用默认的 浮点型估值器(FloatEvaluator)
        initValueAnimatorInofIntByJava();
        // initValueAnimatorInofIntByXml();
        // ofObject 面型对象操作，自定义估值器
        initValueAnimatorInofObjectByJava();


        initObjectAnimatorByJava();
        initObjectAnimatorByXml();

        initClick();
    }

    private void initClick() {
        textObjectAnimatorTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimatorStudyActivity.this,AnimatorStudyTwoActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * ObjectAnimator  实现位移，旋转，缩放，透明
     * <p>
     * 在propertyName参数传入具体的值
     */
    private void initObjectAnimatorByXml() {
        // 见initAnimatorSetByXml() ;
    }

    /**
     * ObjectAnimator  实现位移，旋转，缩放，透明
     * <p>
     * 在propertyName参数传入具体的值
     * 当我们传入propertyName 时，系统又是如何工作的呢？
     * 首先，我们知道 textObjectAnimatorOne （TextView,Button,ImageView...）并没有这个 translationX 属性
     * 而是根据 translationX 去寻找对应的set/get方法
     * public void setTranslationX(float value);
     * public float getTranslationX();
     * 实际上这两个方法是View （父类）提供的，而所有的控件又都（间接/直接）继承View
     * <p>
     * 那么 propertyName只能传入系统(我们已知的那些属性值)吗？当然不是，我们可以传入任意属性值
     * 这就需要我们自定义属性值，从而实现自定义属性动画（操作ObjectAnimator）
     */
    private void initObjectAnimatorByJava() {
        ObjectAnimator translationX = ObjectAnimator.ofFloat(textObjectAnimatorOne, "translationX", 30, 100);
        translationX.setDuration(1000);
        // 省略很多属性 .......
        translationX.start();
    }


    /**
     * 属性动画之ValueAnimator的重要方法ofObject()
     * 只能自定义估值器
     */
    private void initValueAnimatorInofObjectByJava() {
        // 具体见 ： MyCricleView
    }


    /**
     * 属性动画之ValueAnimator的重要方法ofInt()
     */
    private void initValueAnimatorInofIntByXml() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_by_ofint);
        // 载入XML动画
        animator.setTarget(textValueAnimatorAnimatorOne);
        // 设置动画对象
        animator.start(); // 启动动画
    }


    /**
     * 属性动画之ValueAnimator的重要方法ofInt()
     */
    private void initValueAnimatorInofIntByJava() {
        // 步骤1：设置动画属性的初始值 & 结束值
        ValueAnimator anim = ValueAnimator.ofInt(textValueAnimatorAnimatorOne.getLayoutParams().width, 500);
        // ofInt（）作用有两个
        // 1. 创建动画实例
        // 2. 将传入的多个Int参数进行平滑过渡:此处传入0和1,表示将值从0平滑过渡到1
        // 如果传入了3个Int参数 a,b,c ,则是先从a平滑过渡到b,再从b平滑过渡到C，以此类推
        // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置，
        // 即默认设置了如何从初始值 过渡到 结束值 // 关于自定义插值器我将在下节进行讲解
        // 下面看看ofInt()的源码分析 ->>关注1
        // 步骤2：设置动画的播放各种属性
        anim.setDuration(2000);
        // 设置动画运行的时长
        anim.setStartDelay(100);
        // 设置动画延迟播放时间
        anim.setRepeatCount(0);
        // 设置动画重复播放次数 = 重放次数+1
        // 动画播放次数 = infinite时,动画无限重复
        anim.setRepeatMode(ValueAnimator.RESTART);
        // 设置重复播放动画模式ValueAnimator.RESTART(默认):正序重放，ValueAnimator.REVERSE:倒序回放
        // 步骤3：将改变的值手动赋值给对象的属性值：通过动画的更新监听器
        // 设置 值的更新监听器 // 即：值每次改变、变化一次,该方法就会被调用一次

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (Integer) animation.getAnimatedValue();
                // 获得改变后的值
                System.out.println(currentValue);
                // 输出改变后的值
                // 步骤4：将改变后的值赋给对象的属性值，下面会详细说明
                textValueAnimatorAnimatorOne.getLayoutParams().width = currentValue;
                // 步骤5：刷新视图，即重新绘制，从而实现动画效果
                textValueAnimatorAnimatorOne.requestLayout();
            }
        });

        anim.start();
        // 启动动画
    }


    /**
     * 组合动画
     */
    private void initAnimatorSetByJava() {
        // 步骤1：设置需要组合的动画效果
        // 平移动画
        ObjectAnimator translation = ObjectAnimator.ofFloat(textAnimatorSetOne, "translationX", 30, 300, 100);
        // 旋转动画
        ObjectAnimator rotate = ObjectAnimator.ofFloat(textAnimatorSetOne, "rotation", 0f, 360f);
        // 透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(textAnimatorSetOne, "alpha", 1f, 0f, 1f);
        // 步骤2：创建组合动画的对象
        AnimatorSet animSet = new AnimatorSet();
        // 步骤3：根据需求组合动画
        animSet.play(translation).with(rotate).before(alpha);
        animSet.setDuration(3000);
        // 步骤4：启动动画
        animSet.start();
    }

    /**
     * 组合动画
     */
    private void initAnimatorSetByXml() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_set_one);
        // 载入XML动画
        animator.setTarget(textAnimatorSetOne);
        // 设置动画对象
        animator.start(); // 启动动画

    }
}



/*
* AnimatorSet.play(Animator anim) ：播放当前动画
* AnimatorSet.after(long delay) ：将现有动画延迟x毫秒后执行
* AnimatorSet.with(Animator anim) ：将现有动画和传入的动画同时执行
* AnimatorSet.after(Animator anim) ：将现有动画插入到传入的动画之后执行
* AnimatorSet.before(Animator anim) ： 将现有动画插入到传入的动画之前执行
*
*
* */
