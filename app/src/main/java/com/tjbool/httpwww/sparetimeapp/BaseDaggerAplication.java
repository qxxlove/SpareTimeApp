package com.tjbool.httpwww.sparetimeapp;

import android.app.Application;

import com.tjbool.httpwww.sparetimeapp.component.DaggerComponentApplication;
import com.tjbool.httpwww.sparetimeapp.component.DaggerDaggerComponentApplication;
import com.tjbool.httpwww.sparetimeapp.holder.ComponentHolder;
import com.tjbool.httpwww.sparetimeapp.module.DaggerBaseApplicationModule;

/** 
 * description: 使用Dagger的BaseApplication
 * autour: TMM
 * date: 2018/4/25 16:24 
 * update: 2018/4/25
 * version: 
*/

public class BaseDaggerAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        inject();

    }


    /**
     * 依赖注入初始化对象
     * MyApplication （作为参数初始化）-> AppModule(初始化全局变量) -> (注入) AppComponent ->(存储到)ComponentHolder
     */
    private void inject() {
        DaggerComponentApplication daggerComponentApplication =
                DaggerDaggerComponentApplication.builder()
                .daggerBaseApplicationModule(new DaggerBaseApplicationModule(this))
                .build();

        ComponentHolder.setAppComponent(daggerComponentApplication);
    }
}
