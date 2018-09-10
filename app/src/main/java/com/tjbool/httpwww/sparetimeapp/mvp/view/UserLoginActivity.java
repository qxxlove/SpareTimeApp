package com.tjbool.httpwww.sparetimeapp.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.mvp.presenter.LoginPresenter;

/**
 * description:  Lifecycle 学习
 * autour: TMM
 * date: 2018/7/23 18:14
 * update: 2018/7/23
 * version:
 * 
 *  参考：Android架构组件—Lifecycle
 *        https://blog.csdn.net/qq_24442769/article/details/79420191
 *
 *        使用场景：
 *             让Presenter 感知Activity 的生命周期，随之同生死
 *              所以： Activity生命周期 被观察者， Presenter 观察者
 *
 *  补充: RxAndroid之Rxlifecycle使用
 *        https://blog.csdn.net/jdsjlzx/article/details/51527542
 *
*/


public class UserLoginActivity extends AppCompatActivity {

    public static final String  TAG = "UserLoginActivity";
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate()"+this.getClass().toString());
        setContentView(R.layout.activity_user_login);
        loginPresenter = new LoginPresenter(this);
        /**添加LifecycleObserver，观察者*/
        getLifecycle().addObserver(loginPresenter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy()"+this.getClass().toString());

    }
}
