package com.tjbool.httpwww.sparetimeapp.listener;

import android.app.Activity;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/2/2.
 * 邮箱：123123@163.com
 */

public interface ActivityManagerState {

    /**
     * 得到当前Activity
     * @return
     */
    Activity currentActivity();

    /**
     * 任务栈中Activity的总数
     * @return
     */
    int countActivity();

    /**
     * 判断应用是否处于前台，即是否可见
     * @return
     */
    boolean isFrontActivity();

}
