package com.tjbool.httpwww.androiddaggermvp.dagger.component;

import com.tjbool.httpwww.androiddaggermvp.mvp.view.SecondActivity;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/** 
 * description: 由此封装出BaseActivityComponent
 * autour: TMM
 * date: 2018/4/26 16:11 
 * update: 2018/4/26
 * version: 
*/

@Subcomponent(modules = {
        SecondActivitySubcomponent.SubModule.class,
        AndroidInjectionModule.class,
})
public interface SecondActivitySubcomponent extends AndroidInjector<SecondActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SecondActivity> {
    }

    @Module
    class SubModule {
        @Provides
        String provideName() {
            return SecondActivity.class.getName();
        }
    }
}
