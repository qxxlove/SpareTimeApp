package com.tjbool.httpwww.sparetimeapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.component.DaggerDaggerComponentTechcherThree;
import com.tjbool.httpwww.sparetimeapp.entity.TeacherBean;
import com.tjbool.httpwww.sparetimeapp.module.DaggerTeacherThreeModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaggerStudyFourActivity extends AppCompatActivity {


    @BindView(R.id.text_teacher_content_four)
    TextView textTeacherContentFour;

    @Inject
    TeacherBean teacherBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_study_four);
        ButterKnife.bind(this);
        inject();
        initData();
    }

    private void initData() {
          textTeacherContentFour.setText(teacherBean.toString());

    }

    private void inject() {
        DaggerDaggerComponentTechcherThree.builder()
                .daggerTeacherThreeModule(new DaggerTeacherThreeModule(this))
                .build()
                .inject(this);

    }
}
