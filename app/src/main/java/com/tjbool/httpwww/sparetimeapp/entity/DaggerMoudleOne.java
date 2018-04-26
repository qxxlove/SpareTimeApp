package com.tjbool.httpwww.sparetimeapp.entity;

import com.tjbool.httpwww.sparetimeapp.activity.DaggerStudyActivity;

import dagger.Module;
import dagger.Provides;

/**
 * description:   dagger的Module
 * autour: TMM
 * date: 2018/4/24 14:56
 * update: 2018/4/24
 * version:
*/

@Module
public class DaggerMoudleOne  {

    private DaggerStudyActivity daggerStudyActivity;

    public DaggerMoudleOne(DaggerStudyActivity daggerStudyActivity) {
        this.daggerStudyActivity = daggerStudyActivity;
    }

    //下面为新增代码：
    @Provides
    StudentInjectBean provideStudent(){
        return new StudentInjectBean();
    }

}
