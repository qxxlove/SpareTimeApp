package com.tjbool.httpwww.sparetimeapp.activity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * description: 动画学习
 * autour: TMM
 * date: 2018/5/11 18:08
 * update: 2018/5/11
 * version:
 *
 * 注意：RepeatCount 属性：
 *        如果是使用xml 文件实现的动画，使用repeatCount也必须在xml文件中使用，否则没有效果
 *        如果是使用Java 代码实现的动画，在Java代码中实现即可。
 *
 * 问题：setDuration  属性，是如何分配动画执行的时间的？
 *       因为发现 旋转动画的 若果设置时间过长，会多旋转
 *
 * 参考： https://mp.weixin.qq.com/s/HQ0Z_RpSzbYzuqdJjw3FLQ
 *
*/


public class AnimationStudyActivity extends AppCompatActivity {


    @BindView(R.id.image_one)
    ImageView imageOne;
    @BindView(R.id.text_one)
    TextView textOne;
    @BindView(R.id.text_two)
    TextView textTwo;
    @BindView(R.id.text_three)
    TextView textThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_study);
        ButterKnife.bind(this);
        
        //initAlphaByXmlAnimation();
        //  initAlphaByJavaAnimation();
          //initTranslateByXmlAnimation();
          // initTranslateByJavaAnimation();
        //initScaleByXmlAnimation();
      //  initScaleByJavaAnimation();
       // initRotateByXmlAnimation();
        initRotateByJavaAnimation();
       initData();
    }

    private void initData() {
        String time = "2018-05-01 15;15;21";
        time.toString().trim().substring(11,15);
        ToastUtils.showLongToast(time);


    }

    private void initRotateByJavaAnimation() {
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(500);
        //rotate.setFillAfter(true);
        textThree.setAnimation(rotate);
    }

    private void initRotateByXmlAnimation() {
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animtation_one);
        // transltateAnimation.setInterpolator(new LinearInterpolator());
        textThree.startAnimation(rotateAnimation);

    }

    private void initScaleByJavaAnimation() {
        ScaleAnimation scale = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(1000);
        scale.setFillAfter(true);
        textTwo.setAnimation(scale);

    }

    private void initScaleByXmlAnimation() {
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation_one);
        // transltateAnimation.setInterpolator(new LinearInterpolator());
        textTwo.startAnimation(scaleAnimation);

    }

    private void initTranslateByJavaAnimation() {
        TranslateAnimation translate = new TranslateAnimation(30, -30, 100, -100);
        translate.setDuration(1000);
        translate.setRepeatCount(Animation.INFINITE);
        translate.setRepeatMode(ValueAnimator.REVERSE);//translate.setFillAfter(true);
        textOne.setAnimation(translate);

    }

    private void initTranslateByXmlAnimation() {
        Animation transltateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_animation_one);
       // transltateAnimation.setInterpolator(new LinearInterpolator());
        //transltateAnimation.setRepeatCount(3);
        //transltateAnimation.setFillAfter(true);
        textOne.startAnimation(transltateAnimation);


    }

    private void initAlphaByJavaAnimation() {
        AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
        alpha.setDuration(500);          //设置持续时间
        alpha.setRepeatCount(Animation.INFINITE);
        alpha.setRepeatMode(ValueAnimator.REVERSE);
      //  alpha.setFillAfter(true);                   //动画结束后保留结束状态
        alpha.setInterpolator(new AccelerateInterpolator());        //添加差值器
        imageOne.setAnimation(alpha);

    }

    private void initAlphaByXmlAnimation() {
        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.aplha_animation_one);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        imageOne.startAnimation(alphaAnimation);
    }


    @OnClick({R.id.text_four})
    public void  initClick (View view){
        switch (view.getId()){
            case  R.id.text_four:
                Intent intent = new Intent(AnimationStudyActivity.this,AnimatorStudyActivity.class);
                startActivity(intent);
                break;
                default:
        }
    }


}
