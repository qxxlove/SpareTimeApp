package com.tjbool.httpwww.androiddaggermvp.mvp.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tjbool.httpwww.androiddaggermvp.R;
import com.tjbool.httpwww.androiddaggermvp.base.BaseActivity;
import com.tjbool.httpwww.androiddaggermvp.bean.GrilBean;
import com.tjbool.httpwww.androiddaggermvp.mvp.contract.MainContract;
import com.tjbool.httpwww.androiddaggermvp.mvp.presenter.MainPresenter;

import javax.inject.Inject;

/**
 * description:
 * autour: TMM
 * date: 2018/4/26 10:36
 * update: 2018/4/26
 * version:
 *
 *    dagger_android 的使用
 *    参考：  https://blog.csdn.net/mq2553299/article/details/77485800
 *
 *    源码分析：https://blog.csdn.net/mq2553299/article/details/77725912
 *
 */


public class MainActivity extends BaseActivity implements MainContract.View {


    @Inject
    String className;
    @Inject
    SharedPreferences sp;
    @Inject
    MainPresenter presenter;
    @Inject
    GrilBean grilBeanOne;
    @Inject
    GrilBean grilBeanTwo;

    
    private TextView textContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

        textContent.setText(className + "\n" +
                grilBeanOne.toString() + "\n" +
                grilBeanTwo.toString());
    }

    private void initView() {
        textContent = ((TextView) findViewById(R.id.tv_content));

    }


    public void requestHttp(View view) {
        presenter.requestHttp();
    }

    public void gotoSecond(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
    public void onGetMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
