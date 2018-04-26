package com.tjbool.httpwww.sparetimeapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.entity.DaggerDaggerComponentOne;
import com.tjbool.httpwww.sparetimeapp.entity.DaggerMoudleOne;
import com.tjbool.httpwww.sparetimeapp.entity.StudentInjectBean;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * description:
 * autour: TMM
 * date: 2018/4/25 15:13
 * update: 2018/4/25
 * version:
 *  参考学习：https://blog.csdn.net/mq2553299/article/details/77485800
*/





public class DaggerStudyActivity extends AppCompatActivity {

    @BindView(R.id.text_get_studentBean)
    TextView textGetStudentBean;

    @Inject
    StudentInjectBean studentInjectBean;

    private Intent intent;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_study);
        ButterKnife.bind(this);
        initData();
        initClick();
    }

    private void initData() {
        DaggerDaggerComponentOne.builder()
                .daggerMoudleOne(new DaggerMoudleOne(this))
                .build()
                .inject(this);
        
    }

    private void initClick() {
        textGetStudentBean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showLongToast(studentInjectBean.toString());
            }
        });

   
    }

    @OnClick({R.id.text_dagger_study_three})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.text_dagger_study_three:
                intent = new Intent(this, DaggerStudyThreeActivity.class);
                startActivity(intent);
                break;
            default:
        }


    }


}
