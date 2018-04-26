package com.tjbool.httpwww.androiddaggermvp.dagger;


import com.tjbool.httpwww.androiddaggermvp.dagger.component.BaseActivityComponent;
import com.tjbool.httpwww.androiddaggermvp.dagger.module.MainActivityModule;
import com.tjbool.httpwww.androiddaggermvp.dagger.module.SecondActivityModule;
import com.tjbool.httpwww.androiddaggermvp.dagger.scope.ActivityScope;
import com.tjbool.httpwww.androiddaggermvp.mvp.view.MainActivity;
import com.tjbool.httpwww.androiddaggermvp.mvp.view.SecondActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;



/** 
 * description:

 1.AllActivitysModule的module:AllActivity Module，其负责所有ActivityModule实例的管理

 2.BaseActivityComponent为AllActivityModule的subcomponent,管理了提供各activity所需对象的module

 3.MainActivityModule 负责提供所有对应Activity所需要对象实例的提供。

 * autour: TMM
 * date: 2018/4/26 16:23 
 * update: 2018/4/26
 * version: 
*/

@Module(subcomponents = {
        BaseActivityComponent.class
})
public abstract class AllActivitysModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivitytInjector();

    @ContributesAndroidInjector(modules = SecondActivityModule.class)
    abstract SecondActivity contributeSecondActivityInjector();


  /*  这样，我们每次新建一个Activity，只需要统一在这里新建2行代码声明对应的Activity即可。

    对个人而言，这样的好处在于：
            1.每次不再需要额外声明一个SubCompoent，再次减少模板代码
2.每个Activity的Module都放在同一个AllActivitysModule中进行统一管理，每次修改只需要修改这一个类即可
3.每个Activity所单独需要的依赖，依然由各自的Module进行管理和实例化，依然没有任何耦合

    关于这两行代码的解释，请参考官网：https://google.github.io/dagger//android.html*/

}
