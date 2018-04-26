package com.tjbool.httpwww.sparetimeapp.module;

import com.tjbool.httpwww.sparetimeapp.activity.DaggerStudyFourActivity;
import com.tjbool.httpwww.sparetimeapp.entity.TeacherBean;

import dagger.Module;
import dagger.Provides;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/4/25.
 * 邮箱：123123@163.com
 */

@Module
public class DaggerTeacherThreeModule {

    private DaggerStudyFourActivity daggerStudyFourActivity;


    public DaggerTeacherThreeModule(DaggerStudyFourActivity daggerStudyFourActivity) {
        this.daggerStudyFourActivity = daggerStudyFourActivity;
    }


    @Provides
    TeacherBean provideTeacheer (){
        return   new TeacherBean();
    }



}
