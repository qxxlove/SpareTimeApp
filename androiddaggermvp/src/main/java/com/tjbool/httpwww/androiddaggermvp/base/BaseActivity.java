package com.tjbool.httpwww.androiddaggermvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dagger.android.AndroidInjection;

/** 
 * description: BAseActivity
 * autour: TMM
 * date: 2018/4/26 14:38 
 * update: 2018/4/26
 * version: 
*/

public class BaseActivity  extends AppCompatActivity {


    /**
     * Activity 级依赖注入
     * 具体分析  AndroidInjection 源码
     *   我们需要找到真正的activityInjector对象，就是DispatchingAndroidInjector：
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

    }
}
