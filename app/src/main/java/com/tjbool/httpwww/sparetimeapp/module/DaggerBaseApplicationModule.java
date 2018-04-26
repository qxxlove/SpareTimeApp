package com.tjbool.httpwww.sparetimeapp.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.tjbool.httpwww.sparetimeapp.BaseDaggerAplication;

import dagger.Module;
import dagger.Provides;

/** 
 * description: 初始化全局变量
 * autour: TMM
 * date: 2018/4/25 15:56 
 * update: 2018/4/25
 * version: 
*/

@Module
public class DaggerBaseApplicationModule  {


    private BaseDaggerAplication application;

    
    public DaggerBaseApplicationModule(BaseDaggerAplication application) {
        this.application = application;
    }

    //全局单例SharedPreferences
    @Provides
    //@Singleton
    SharedPreferences provideSharedPreferences(){
        return application.getSharedPreferences("spfile", Context.MODE_PRIVATE);
    }

    //提供全局的Application对象
    @Provides
    BaseDaggerAplication provideApplication(){
        return application;
    }
    
}
