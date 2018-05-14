package com.tjbool.httpwww.sparetimeapp.component;

import android.content.SharedPreferences;

import com.tjbool.httpwww.sparetimeapp.BaseDaggerAplication;
import com.tjbool.httpwww.sparetimeapp.module.DaggerBaseApplicationModule;

import dagger.Component;

/**
 * description:  注入器，储存了我们需要的全局变量
 * autour: TMM
 * date: 2018/4/25 16:19
 * update: 2018/4/25
 * version:
*/

//不要忘了还要在关联的Component接口中声明，否则会编译报错
//@Singleton
@Component(modules = DaggerBaseApplicationModule.class)
public interface DaggerComponentApplication {


    SharedPreferences sharedPreferences();

    BaseDaggerAplication myApplication();


}                                 
