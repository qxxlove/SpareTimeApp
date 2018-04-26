package com.tjbool.httpwww.androiddaggermvp.base;

import android.app.Activity;
import android.app.Application;

import com.tjbool.httpwww.androiddaggermvp.dagger.DaggerBaseApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/** 
 * description: 

 1.实现HasActivityInjector接口

 2.实现HasActivityInjector接口的activityInjector()方法

 3.声明一个泛型为Activity的DispatchingAndroidInjector成员变量并在activityInjector()方法中返回

 * autour: TMM
 * date: 2018/4/26 16:15 
 * update: 2018/4/26
 * version: 
*/

public class BaseApplication   extends Application   implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        DaggerBaseApplicationComponent.create().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
