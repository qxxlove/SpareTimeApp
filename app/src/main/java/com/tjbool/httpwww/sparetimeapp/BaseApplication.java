package com.tjbool.httpwww.sparetimeapp;

import android.app.Application;
import android.content.Context;

import com.tjbool.httpwww.sparetimeapp.utils.ActivityRecyclerCallBacksUtils;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/1/16.
 * 邮箱：123123@163.com
 */

public class BaseApplication extends Application {

    private static String sCacheDir;
    public static Context sAppContext;
    public static BaseApplication baseApplication;

    public static final String  EXIT = "APPEXIT";

    public static ActivityRecyclerCallBacksUtils activityRecyclerCallBacksUtils = new ActivityRecyclerCallBacksUtils();

    @Override
    public void onCreate() {
        super.onCreate();

        baseApplication =this;
        sAppContext = getApplicationContext();
        registerActivityLifecycleCallbacks(activityRecyclerCallBacksUtils);

        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            sCacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            sCacheDir = getApplicationContext().getCacheDir().toString();
        }

        ToastUtils.init(true);

    }

    private boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    public static Context getAppContext() {
        return sAppContext;
    }


    public static synchronized BaseApplication getApplication() {
        return baseApplication;
    }

    public static String getAppCacheDir() {
        return sCacheDir;
    }

    public static ActivityRecyclerCallBacksUtils getActivityRecyclerCallBacksUtils() {
        return activityRecyclerCallBacksUtils;
    } 

}
