package com.tjbool.httpwww.sparetimeapp.fragment;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.BaseApplication;
import com.tjbool.httpwww.sparetimeapp.MainActivity;
import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.activity.UserInfoActivity;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;
import com.tjbool.httpwww.sparetimeapp.receiver.ExitBroadcastReceiver;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * description: 我的
 * autour: TMM
 * date: 2018/1/16 18:05
 * update: 2018/1/16
 * version:
 *
 * 参考： https://www.jianshu.com/p/269873a16937
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.img_head_circle_one)
    CircleImageView imgHeadCircleOne;
    @BindView(R.id.text_name_fragment_mine)
    TextView textNameFragmentMine;
    @BindView(R.id.ll_info_fragment_mine)
    LinearLayout linearLayout;

    Intent intent;


    private ExitBroadcastReceiver exitBroadcastReceiver;


    public static MyFragment newInstance(String title) {
        MyFragment f = new MyFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {

    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_mine;
    }

    @OnClick({R.id.ll_info_fragment_mine,R.id.text_exit_app})
    public void initClick(View view){
        switch (view.getId()){
            case R.id.ll_info_fragment_mine :
                 intent= new Intent(getActivity(), UserInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.text_exit_app :

                // 1. 此模式必须是lunchMode(启动模式):SingleTask，当需要退出时，启动入口Activity
                //    局限性：适用于单个任务栈，多个则无法满足。
               // initSingleOne();
                // 2. 设置标记位
                // 局限性： Activity单任务栈，如果是SingleInstance 启动模式多个任务栈，则无法使用
                //initSetflag();
                // 3. 通过ActivityManager获取当前任务栈，循环依次退出。
                // 局限性： Activity 单任务战，必须android 5.0 以上适用。
                //initActivityManager();
                // 4. 通过BroadcastReceiver
                // 局限性： 代码繁琐，但适用面广
                //initBroadcastReceiver();
                 // 5. registerActivityLifecycleCallbacks 的使用
                // 局限性：  需要 Activity 经历正常的生命周期，即创建时调用onCreate（），结束时调用onDestroy（）
                //           因为只有这样经历正常的生命周期才能将 Activity正确写入 & 写出 容器内,
                //           否则会遗漏Activity  ，但适用面广（单/多任务栈/ 多种启动模式）
                 //initRegisterActivityLifecycleCallbacks();
                 // 6. RxBus
                // 局限性： 和方式4类同，但是项目中没有使用Rxjava不建议使用
                 //initRxBus();



                
                // 上述1.2.3.4.5.6 执行完，只是结束了当前所有的Activity,并没有结束当前App进程,所以还需掉用
                // 方式1：android.os.Process.killProcess（）
                android.os.Process.killProcess(android.os.Process.myPid()) ;
                // 方式2：System.exit() //System.exit() = Java中结束进程的方法：关闭当前JVM虚拟机
                System.exit(0);
                // 调用方式1,2 的时机，必须执行上述的1.2.3.4.5.6（即结束调所有的Activity）,
                // 因为方式1,2的本质是调用Dalvik VM 方法，
                // 结束当前 Activity & 结束进程
                //  之后再重新开启进程 & 启动 之前除当前 Activity 外的已启动的 Activity
                //原因：** Android中的ActivityManager时刻监听着进程**。一旦发现进程被非正常结束，它将会试图去重启这个进程。
                // 所以我们强制调用上面的方法，属于异常结束进程。


                // System.exit(0)和System.exit(1)的区别
                // 1. System.exit(0)：正常退出；
                // 2. System.exit(1)：非正常退出，通常这种退出方式应该放在catch块中。 

                break;
            default:
        }

    }

    /**
     * 方式6
     */
    private void initRxBus() {
        // 此项目缺少Rajava包
        // private Disposable disposable;
        // 注册RxBus订阅
        // disposable = RxBus.getInstance().toObservable(String.class)
        // .subscribe(new Consumer<String>()
        // { @Override public void accept(String s) throws Exception
        // { 响应动作 = 关闭自身 if (s.equals("exit")){ finish(); } } });

         // 在onDestory() 中    if (!disposable.isDisposed()){
        // disposable.dispose();;

        // 调用处，上述代码都是在Activity中实现
        // RxBus.getInstance().post("exit");


    }


  

    /**
     * 方式5
     */
    private void initRegisterActivityLifecycleCallbacks() {
               BaseApplication.getActivityRecyclerCallBacksUtils().exitApp();

    }


    /**
     * 方式4
     */
    private void initBroadcastReceiver() {
        // 以下是注册广播的代码，需要在每个界面都写
       // exitBroadcastReceiver = new ExitBroadcastReceiver(getActivity());
      //  getActivity().registerReceiver(exitBroadcastReceiver,new IntentFilter(BaseApplication.EXIT));
       // getActivity().unregisterReceiver(exitBroadcastReceiver);

        // 发送退出的广播，所有注册该广播的Activity ,都会接收到
        getActivity().sendBroadcast(new Intent(BaseApplication.EXIT));
    }


    /**
     * 方式3
     */
    private void initActivityManager() {
        // 1. 通过Context获取ActivityManager
         ActivityManager activityManager =
                 (ActivityManager) getActivity().getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        // 2. 通过ActivityManager获取任务栈
       // List<ActivityManager.AppTask> appTaskList = activityManager.getAppTasks();
        // 3. 逐个关闭Activity
       // for (ActivityManager.AppTask appTask : appTaskList)
       // { appTask.finishAndRemoveTask();}




    }


    /**
     * 方式1：  采用singleTask启动模式
     */
    private void initSingleOne() {
        intent = new Intent();
        intent.setClass(getActivity(), MainActivity.class);
        // 传入自己设置的退出App标识
        intent.putExtra("exit", true);
        startActivity(intent);
    }

    /**
     * 方式2 ： 设置标记位
     */
    private void initSetflag() {
        intent = new Intent();
        intent.setClass(getActivity(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // 步骤1：该标记位作用：销毁目标Activity和它之上的所有Activity，重新创建目标Activity
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        // 步骤2：若启动的Activity位于任务栈栈顶，那么此Activity的实例就不会重建，而是重用栈顶的实例( 调用实例的 onNewIntent() )
        // 在步骤1中：MainActivity的上层的Activity2会被销毁，此时MainActivity位于栈顶；
        // 由于步骤2的设置，所以不会新建MainActivity而是重用栈顶的实例&调用实onNewIntent()
        // 传入自己设置的退出App标识
        intent.putExtra("exit", true);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
