package com.tjbool.httpwww.androiddaggermvp.dagger;

import com.tjbool.httpwww.androiddaggermvp.base.BaseApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/** 
 * description: 

 1.在这个Component中添加了 AndroidInjectionModule 和 AndroidSupportInjectionModule

 2.同时添加了MainActivityModule 和 SecondActivityModule的依赖

 3.声明注入方法inject，参数类型为MyApplication

 * autour: TMM
 * date: 2018/4/26 16:21 
 * update: 2018/4/26
 * version: 
*/

@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AllActivitysModule.class  // 此处 本应该是：MainActivityModuleOne.class,
        // SecondActivityModuleOne.class （还有很多，因为在一个项目中有很多Activity），
        // 所以采取疯转的AllActivitysModule
})
public interface BaseApplicationComponent {

    
    void inject(BaseApplication application);
}
