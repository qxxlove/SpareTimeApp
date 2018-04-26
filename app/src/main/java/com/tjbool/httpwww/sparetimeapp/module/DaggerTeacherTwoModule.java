package com.tjbool.httpwww.sparetimeapp.module;

import com.tjbool.httpwww.sparetimeapp.activity.DaggerStudyThreeActivity;
import com.tjbool.httpwww.sparetimeapp.component.scope.ActivityScope;
import com.tjbool.httpwww.sparetimeapp.entity.TeacherBean;

import dagger.Module;
import dagger.Provides;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/4/25.
 * 邮箱：123123@163.com
 */

@Module
public class DaggerTeacherTwoModule {

    private DaggerStudyThreeActivity daggerStudyThreeActivity;


    public DaggerTeacherTwoModule(DaggerStudyThreeActivity daggerStudyThreeActivity) {
        this.daggerStudyThreeActivity = daggerStudyThreeActivity;
    }


    @Provides
    //添加注解实现局部单例
    @ActivityScope
    TeacherBean provideTeacheer (){
        return   new TeacherBean();
    }



}
