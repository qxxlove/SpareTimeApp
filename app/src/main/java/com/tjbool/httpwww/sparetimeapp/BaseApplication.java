package com.tjbool.httpwww.sparetimeapp;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.baidu.lbsapi.BMapManager;
import com.baidu.lbsapi.MKGeneralListener;
import com.squareup.leakcanary.LeakCanary;
import com.tjbool.httpwww.sparetimeapp.activity.uncaughexception.UnCaughExceptionHandler;
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

    public static ActivityRecyclerCallBacksUtils activityRecyclerCallBacksUtils =
                             new ActivityRecyclerCallBacksUtils();

    public BMapManager mBMapManager = null;


    @Override
    public void onCreate() {
        super.onCreate();

        baseApplication =this;
        sAppContext = getApplicationContext();
        // 在SDK各功能组件使用之前都需要调用,因此建议在Application初始化
        //SDKInitializer.initialize(this);
        initEngineManager(this);
        /**作用：就是在你调用这个方法registerActivityLifecycleCallbacks（）传入这个接口实现类后,
         * 系统会在每个 Activity 执行完对应的生命周期后都调用这个实现类中对应的方法*/
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
        
        /**初始化全局异常处理*/
        UnCaughExceptionHandler.getInstance().init(this);

        initLeak();
}

    /**
     * 内存泄露检查工具
     *  参考： https://www.jianshu.com/p/1e7e9b576391
     */
    private void initLeak() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            //此过程专用于LeakCanary用于堆分析。
            //在这个过程中不应该初始化应用程序。
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
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

    public void initEngineManager(Context context) {
        if (mBMapManager == null) {
            mBMapManager = new BMapManager(context);
        }

        if (!mBMapManager.init(new MyGeneralListener())) {
            Toast.makeText(BaseApplication.getApplication().getApplicationContext(), "BMapManager  初始化错误!",
                    Toast.LENGTH_LONG).show();
        }
        Log.d("ljx", "initEngineManager");
    }

    // 常用事件监听，用来处理通常的网络错误，授权验证错误等
    public static class MyGeneralListener implements MKGeneralListener {

        @Override
        public void onGetPermissionState(int iError) {
            // 非零值表示key验证未通过
            if (iError != 0) {
                // 授权Key错误：
                Toast.makeText(BaseApplication.getApplication().getApplicationContext(),
                        "请在AndoridManifest.xml中输入正确的授权Key,并检查您的网络连接是否正常！error: " + iError, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(BaseApplication.getApplication().getApplicationContext(), "key认证成功", Toast.LENGTH_LONG)
                        .show();
            }
        }
    }

}
