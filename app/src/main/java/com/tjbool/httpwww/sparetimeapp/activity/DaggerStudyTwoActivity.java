package com.tjbool.httpwww.sparetimeapp.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.component.DaggerDaggerComponentTeacher;
import com.tjbool.httpwww.sparetimeapp.entity.TeacherBean;
import com.tjbool.httpwww.sparetimeapp.holder.ComponentHolder;
import com.tjbool.httpwww.sparetimeapp.module.DaggerTeacherModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaggerStudyTwoActivity extends AppCompatActivity {

    @Inject
    TeacherBean teacherBean;
    @Inject
    SharedPreferences sharedPreferences;
    @BindView(R.id.text_dagger_study_three)
    TextView textDaggerStudyThree;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_study_two);
        ButterKnife.bind(this);
        inject();
    }

    private void inject() {
        DaggerDaggerComponentTeacher.builder()
                .daggerTeacherModule(new DaggerTeacherModule(this))
                .daggerComponentApplication(ComponentHolder.getAppComponent())
                .build()
                .inject(this);

        Log.i("tag", "注入完毕，Teacher = " + teacherBean.toString());
        Log.i("tag", "注入完毕，sp = " + sharedPreferences.toString());
    }





}
