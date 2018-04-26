package com.tjbool.httpwww.sparetimeapp.entity;

import com.tjbool.httpwww.sparetimeapp.activity.DaggerStudyActivity;

import dagger.Component;

/** 
 * description: dagger的Component
 * autour: TMM
 * date: 2018/4/24 16:45 
 * update: 2018/4/24
 * version: 
*/

@Component(modules = DaggerMoudleOne.class)
public interface DaggerComponentOne {

    void   inject (DaggerStudyActivity daggerStudyActivity);

}
