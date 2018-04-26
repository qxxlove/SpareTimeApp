package com.tjbool.httpwww.sparetimeapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.component.DaggerDaggerComponentTechcherTwo;
import com.tjbool.httpwww.sparetimeapp.entity.TeacherBean;
import com.tjbool.httpwww.sparetimeapp.module.DaggerTeacherTwoModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * description:
 * autour: TMM
 * date: 2018/4/25 17:47
 * update: 2018/4/25
 * version:
 *
 *
 * 此时我们并没有实现Activity 局部单例
 * 可以看到 teacherBeanOne，teacherBeanTwo 每次都是一个新对象
 * 我们在此基础上稍作修改：
 *         添加  @ActivityScope
 *         就会发现 teacherBeanOne，teacherBeanTwo 是同一个对象  （因为单例）
 *         但是出了此范围（当前Activity），teacherBean就是另一对象了（因为非单例）。
 *
 */

public class DaggerStudyThreeActivity extends AppCompatActivity {

    @BindView(R.id.text_teacher_content_one)
    TextView textTeacherContentOne;
    @BindView(R.id.text_teacher_content_two)
    TextView textTeacherContentTwo;


    @Inject
    TeacherBean teacherBeanOne;
    @Inject
    TeacherBean teacherBeanTwo;

    private Intent intent;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_study_three);
        ButterKnife.bind(this);
        inject();
        initData();
    }

    private void initData() {
        //打印两个Student类
        textTeacherContentOne.setText(teacherBeanOne.toString());
        textTeacherContentTwo.setText(teacherBeanTwo.toString());
    }

    private void inject() {
        DaggerDaggerComponentTechcherTwo.builder()
                .daggerTeacherTwoModule(new DaggerTeacherTwoModule(this))
                .build()
                .inject(this);

    }


    @OnClick({R.id.text_dagger_study_four})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.text_dagger_study_four:
                intent = new Intent(this, DaggerStudyFourActivity.class);
                startActivity(intent);
                break;
            default:
        }


    }


}
