package com.tjbool.httpwww.androiddaggermvp.dagger.module;


import com.tjbool.httpwww.androiddaggermvp.mvp.view.SecondActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */
@Module
public abstract class SecondActivityModule {

    @Provides
    static String provideName() {
        return SecondActivity.class.getName();
    }

}
