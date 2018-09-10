package com.tjbool.httpwww.androiddaggermvp.dagger.module;


import com.tjbool.httpwww.androiddaggermvp.mvp.view.SecondActivity;

import dagger.Module;
import dagger.Provides;

/** 
 * description: MainActivityModule 和  SecondActivityModule  衍生出  AllActivitysModule
 * autour: TMM
 * date: 2018/7/20 14:17 
 * update: 2018/7/20
 * version: 
*/
@Module
public abstract class SecondActivityModule {

    @Provides
    static String provideName() {
        return SecondActivity.class.getName();
    }

}
