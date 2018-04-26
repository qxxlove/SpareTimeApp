package com.tjbool.httpwww.sparetimeapp.component;

import com.tjbool.httpwww.sparetimeapp.activity.DaggerStudyThreeActivity;
import com.tjbool.httpwww.sparetimeapp.component.scope.ActivityScope;
import com.tjbool.httpwww.sparetimeapp.module.DaggerTeacherTwoModule;

import dagger.Component;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/4/25.
 * 邮箱：123123@163.com
 */


@ActivityScope//添加注解实现局部单例
@Component(modules = DaggerTeacherTwoModule.class)
public interface DaggerComponentTechcherTwo {

    void  inject (DaggerStudyThreeActivity daggerStudyThreeActivity);


}
