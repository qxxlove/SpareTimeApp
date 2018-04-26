package com.tjbool.httpwww.sparetimeapp.component;

import com.tjbool.httpwww.sparetimeapp.activity.DaggerStudyFourActivity;
import com.tjbool.httpwww.sparetimeapp.module.DaggerTeacherThreeModule;

import dagger.Component;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/4/25.
 * 邮箱：123123@163.com
 */

@Component(modules = DaggerTeacherThreeModule.class)
public interface DaggerComponentTechcherThree {

    void  inject(DaggerStudyFourActivity daggerStudyFourActivity);


}
