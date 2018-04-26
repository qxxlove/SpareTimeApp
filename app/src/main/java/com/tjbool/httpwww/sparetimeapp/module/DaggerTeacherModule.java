package com.tjbool.httpwww.sparetimeapp.module;

import com.tjbool.httpwww.sparetimeapp.activity.DaggerStudyTwoActivity;
import com.tjbool.httpwww.sparetimeapp.entity.TeacherBean;

import dagger.Module;
import dagger.Provides;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/4/25.
 * 邮箱：123123@163.com
 */

@Module
public class DaggerTeacherModule {


    private DaggerStudyTwoActivity daggerStudyTwoActivity;

    public DaggerTeacherModule(DaggerStudyTwoActivity daggerStudyTwoActivity) {
        this.daggerStudyTwoActivity = daggerStudyTwoActivity;
    }

    /**
     *  显然我们并不是很多地方都需要某对象，
     *  我们在需要用该对象的界面的Module中提供注入即可
     * @return
     */
     @Provides
      TeacherBean provideTeacheer (){
        return   new TeacherBean();
      }


}
