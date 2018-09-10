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
 *
 *   思考：
     1.MyApplication中的dispatchingAndroidInjector成员是干嘛的
     2.MyApplication实现的HasActivityInjector接口和实现的activityInjector()方法又是干嘛的
     3.为什么这样2行依赖注入代码，就能代替之前我们每个Activity都需要写的模板代码呢：

 *
 *
*/

public class BaseApplication   extends Application   implements HasActivityInjector {

    // 参考： BaseApplication_MembersInjector 源码
    // 自我理解： 保存所有对象的实例，然后注入到BaseApplication
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;


    /**
     * Application 级依赖注入
     */
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化所有的对象
        DaggerBaseApplicationComponent.create().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
