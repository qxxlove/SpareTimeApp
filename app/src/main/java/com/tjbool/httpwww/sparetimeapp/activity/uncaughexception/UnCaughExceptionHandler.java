package com.tjbool.httpwww.sparetimeapp.activity.uncaughexception;

import android.content.Context;

/**
 * 参考：实现UncaughtExceptionHandler来实现获取应用全局的crash信息
 *       https://blog.csdn.net/wozuihaole/article/details/70224920
 *
 *       开源项目
 *       https://github.com/Ereza/CustomActivityOnCrash
 *
 */

public class UnCaughExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static UnCaughExceptionHandler crashHandler = new UnCaughExceptionHandler();
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultCaughtExceptionHandler;

    //使用饿汉单例模式
    public static UnCaughExceptionHandler getInstance() {
        return crashHandler;
    }

    public void init(Context context) {
        //获取默认的系统异常捕获器
        mDefaultCaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        //把当前的crash捕获器设置成默认的crash捕获器
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = context.getApplicationContext();
    }


    /**
     * 未处理异常回调
     * @param thread
     * @param throwable
     */
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {

    }
}
