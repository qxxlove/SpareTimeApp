package com.tjbool.httpwww.androiddaggermvp.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.tjbool.httpwww.androiddaggermvp.bean.GrilBean;
import com.tjbool.httpwww.androiddaggermvp.dagger.scope.ActivityScope;
import com.tjbool.httpwww.androiddaggermvp.mvp.view.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */
@Module
public class MainActivityModule {

    @Provides
    static String provideName() {
        return MainActivity.class.getName();
    }

    @Provides
    static SharedPreferences provideSp(MainActivity activity) {
        return activity.getSharedPreferences("def", Context.MODE_PRIVATE);
    }

    @Provides
    @ActivityScope
    static GrilBean provideStudent() {
        return new GrilBean();
    }

}
