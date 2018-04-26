package com.tjbool.httpwww.androiddaggermvp.dagger.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.tjbool.httpwww.androiddaggermvp.bean.GrilBean;
import com.tjbool.httpwww.androiddaggermvp.mvp.model.MainModel;
import com.tjbool.httpwww.androiddaggermvp.mvp.view.MainActivity;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/** 
 * description: 由此封装出BaseActivityComponent(因为实际开发中我们有很多Activity,不可能一一写这些模板代码)
 * autour: TMM
 * date: 2018/4/26 16:05 
 * update: 2018/4/26
 * version: 
*/

@Subcomponent(modules = {
        AndroidInjectionModule.class,
        MainActivitySubcomponent.SubModule.class
})
public interface MainActivitySubcomponent  extends AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }

    @Module
    class SubModule {

        @Provides
        String provideName() {
            return MainActivity.class.getName();
        }

        @Provides
        GrilBean provideStudent() {
            return new GrilBean();
        }

        @Provides
        SharedPreferences provideSp(MainActivity activity) {
            return activity.getSharedPreferences("def", Context.MODE_PRIVATE);
        }

        @Provides
        MainModel provideModel() {
            return new MainModel();
        }
    }


}
