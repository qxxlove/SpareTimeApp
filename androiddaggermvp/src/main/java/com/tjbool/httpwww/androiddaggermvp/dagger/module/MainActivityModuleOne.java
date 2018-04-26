package com.tjbool.httpwww.androiddaggermvp.dagger.module;

import android.app.Activity;

import com.tjbool.httpwww.androiddaggermvp.dagger.component.MainActivitySubcomponent;
import com.tjbool.httpwww.androiddaggermvp.mvp.view.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/** 
 * description:   由此衍生出MainActivityModule
 * autour: TMM
 * date: 2018/4/26 16:08 
 * update: 2018/4/26
 * version: 
*/

@Module(subcomponents = MainActivitySubcomponent.class)
public abstract class MainActivityModuleOne {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);
}
