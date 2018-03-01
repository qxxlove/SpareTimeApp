package com.tjbool.httpwww.sparetimeapp.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.tjbool.httpwww.sparetimeapp.listener.ActivityManagerState;

import java.util.ArrayList;
import java.util.List;


/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/2/2.
 * 邮箱：123123@163.com
 */

public class ActivityRecyclerCallBacksUtils  implements Application.ActivityLifecycleCallbacks,ActivityManagerState {

    private List<Activity> activityList=new ArrayList<>();
    private List<Activity> resumeActivity=new ArrayList<>();



    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        activityList.add(0, activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (!resumeActivity.contains(activity)) {
            resumeActivity.add(activity);
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        resumeActivity.remove(activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        activityList.remove(activity);
    }

    /**
     * 返回当前的Activity
     * @return
     */
    @Override
    public Activity currentActivity() {
        return activityList.size()>0 ? activityList.get(0): null;
    }

    /**
     * 返回当前Activity 的个数
     * @return
     */
    @Override
    public int countActivity() {
        return   activityList.size();
    }

    /**
     * 通过判断activity的生命周期判断是否前台/后台
     * @return
     */
    @Override
    public boolean isFrontActivity() {
        return    resumeActivity.size() > 0;
    }
}
