package com.tjbool.httpwww.androiddaggermvp.dagger.module;

import android.app.Activity;

import com.tjbool.httpwww.androiddaggermvp.dagger.component.SecondActivitySubcomponent;
import com.tjbool.httpwww.androiddaggermvp.mvp.view.SecondActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/** 
 * description:    由此衍生出MainActivityModule
 * autour: TMM
 * date: 2018/4/26 16:15 
 * update: 2018/4/26
 * version: 
*/

@Module(subcomponents = SecondActivitySubcomponent.class)
public abstract class SecondActivityModuleOne {


    @Binds
    @IntoMap
    @ActivityKey(SecondActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindSecondActivityInjectorFactory(SecondActivitySubcomponent.Builder builder);
}
