package com.tjbool.httpwww.sparetimeapp.component;

import com.tjbool.httpwww.sparetimeapp.activity.DaggerStudyTwoActivity;
import com.tjbool.httpwww.sparetimeapp.module.DaggerTeacherModule;

import dagger.Component;

/** 
 * description: 
 * autour: TMM
 * date: 2018/4/25 17:02 
 * update: 2018/4/25
 * version:
 *  对这句话的说明：modules = DaggerTeacherModule.class,dependencies = DaggerComponentApplication.class
 *                  他需要这两个共同完成，前者提供 Teacher实体类  ， 后者提供里面拥有的全局变量（SharedPreferences,application等等）
*/

@Component(modules = DaggerTeacherModule.class,dependencies = DaggerComponentApplication.class)
public interface DaggerComponentTeacher {

    void  inject (DaggerStudyTwoActivity daggerStudyTwoActivity);

}
