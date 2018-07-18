package com.tjbool.httpwww.sparetimeapp.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.tjbool.httpwww.sparetimeapp.MainActivity;
import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.listener.OnPermissionCallbackListener;
import com.tjbool.httpwww.sparetimeapp.weight.ProgressDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_CONTACTS;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by melo on 2016/11/24.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected BaseFragment currentFragment;

    public static int REQUEST_PERMISSION = 100;
    public static int REQUEST_READ_CONTACTS = 101;
    public static int REQUEST_READ_CONTACTS_LOCATION = 102;
    public OnPermissionCallbackListener onPermissionCallbackListener;
    protected   Context mContext ;

    protected static Handler mHandler = new Handler(Looper.getMainLooper());

    /**
     * 最后一次按下返回键的时间
      */
    private long lastBackTime = 0;
    // 定义时间差
    private static final long TIME_INTERVAL = 2 * 1000;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //写死竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mContext = this;
        initIntentParam(getIntent());
        setToolbarStyle();

    }

    // 初始化传入的参数
    protected abstract void initIntentParam(Intent intent);
    // 初始化ToolBar
    protected abstract void setToolbarStyle();

    /**
     * 添加或者显示 fragment
     *
     * @param transaction
     * @param fragment
     */
    protected void addOrShowFragment(FragmentTransaction transaction, Fragment fragment) {
        if (currentFragment == fragment) {
            return;
        }
        // 如果当前fragment未被添加，则添加到Fragment管理器中
        if (!fragment.isAdded()) {
            transaction.hide(currentFragment).add(R.id.fl_main_activity, fragment).commitAllowingStateLoss();
        } else {
            transaction.hide(currentFragment).show(fragment).commitAllowingStateLoss();
        }

       // 在切换时，我们对上一个 fragment setUserVisibleHint 设置为 false，要展现的 Fragment setUserVisibleHint 设置为 true
        //currentFragment.setUserVisibleHint(false);
        currentFragment = (BaseFragment) fragment;
       // currentFragment.setUserVisibleHint(true);

        setToolbarStyle();
    }





    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                hideSoftInput(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 多种隐藏软件盘方法的其中一种
     *
     * @param token
     */
    private void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    protected    void   startActivity (Context context,Class cla){
        Intent intent = new Intent(context,cla);
        startActivity(intent);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this instanceof MainActivity) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                long currentBackTime = System.currentTimeMillis();
                if (currentBackTime - lastBackTime > TIME_INTERVAL) {
                    Toast.makeText(this, R.string.press_back_twice, Toast.LENGTH_SHORT).show();
                    lastBackTime = currentBackTime;
                } else {
                    finish();
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }



    /**
     *
     * 单独请求通讯录权限
     */
    @TargetApi(M)
    public void requestContacts() {
        switch (checkSelfPermission(READ_CONTACTS)) {
            case PackageManager.PERMISSION_GRANTED:
                // 已有授权
                Log.i("wxl", "已有授权");
                break;
            case PackageManager.PERMISSION_DENIED:
                // 1、没有权限：尚未请求过权限；
                // 2、或者请求授权被拒绝，用shouldShowRequestPermissionRationale判断用户是否拒绝过，如果返回true，表示用户拒绝过，
                // 再次请求权限，将会出现“不再询问”，勾上“不再询问”，只能选择拒绝，再次进入，shouldShowRequestPermissionRationale始终false
                // 3、或者曾经授权过，但用户在设置中禁用权限
                Log.i("wxl", "是否拒绝过=" + shouldShowRequestPermissionRationale(READ_CONTACTS));
                requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
                break;
            default:
                break;
        }

    }



    /**
     * 同时请求通讯录定位权限
     */
    @TargetApi(M)
    public void requestContactsLocation() {
        List<String> permissionsList = new ArrayList<>();
        permissionsList.add(READ_CONTACTS);
        permissionsList.add(ACCESS_FINE_LOCATION);
        requestPermissions(permissionsList.toArray(new String[permissionsList.size()]), REQUEST_READ_CONTACTS_LOCATION);

    }

    @TargetApi(M)
    public void requestRuntimePermission(String permission, OnPermissionCallbackListener onPermissionCallbackListener) {
        this.onPermissionCallbackListener = onPermissionCallbackListener;
        switch (checkSelfPermission(permission)) {
            case PackageManager.PERMISSION_GRANTED:
                // 已有授权
                Log.i("wxl", "已有授权");
                if (this.onPermissionCallbackListener != null){
                    onPermissionCallbackListener.onGranted();
                }

                break;
            case PackageManager.PERMISSION_DENIED:
                // 1、没有权限：尚未请求过权限；
                // 2、或者请求授权被拒绝，用shouldShowRequestPermissionRationale判断用户是否拒绝过，如果返回true，表示用户拒绝过，
                // 再次请求权限，将会出现“不再询问”，勾上“不再询问”，只能选择拒绝，再次进入，shouldShowRequestPermissionRationale始终false
                // 3、或者曾经授权过，但用户在设置中禁用权限
                Log.i("wxl", "是否拒绝过=" + shouldShowRequestPermissionRationale(permission));
                requestPermissions(new String[]{permission}, REQUEST_PERMISSION);
                break;
            default:
                break;
        }
    }


    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_READ_CONTACTS_LOCATION) {
            Map<String, Integer> perms = new HashMap<>();
            // Initial
            perms.put(ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
            perms.put(READ_CONTACTS, PackageManager.PERMISSION_GRANTED);
            for (int i = 0; i < permissions.length; i++)   {
                perms.put(permissions[i], grantResults[i]);
            }

            if (perms.get(ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && perms.get(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                Log.i("wxl", "授权请求被通过");
            } else {
                // Permission Denied
                Log.i("wxl", "授权请求不被通过");
            }
        }
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 授权请求被通过，读取通讯录
                Log.i("wxl", "onRequestPermissionsResult=授权请求被通过，读取通讯录");
            } else {
                Log.i("wxl", "onRequestPermissionsResult=授权请求不被通过");
            }
        }
        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 授权请求被通过，读取通讯录
                Log.i("wxl", "onRequestPermissionsResult=授权请求被通过");
                if (onPermissionCallbackListener != null) {
                    onPermissionCallbackListener.onGranted();
                }

            } else {
                Log.i("wxl", "onRequestPermissionsResult=授权请求不被通过");
                if (onPermissionCallbackListener != null)   {
                    onPermissionCallbackListener.onDenied();
                }

            }
        }
    }

    private ProgressDialog mProfressDialog = null;

    public void showProgressDialog(String notice) {
        if(mProfressDialog == null) {
            mProfressDialog = new ProgressDialog(this,notice);
        }
        else{
            hideProgressDialog();
            mProfressDialog = new ProgressDialog(this,notice);
        }
    }

    public void showProgressDialog(boolean isCanceledOnTouchOutside) {
        if(mProfressDialog == null) {
            mProfressDialog = new ProgressDialog(this, isCanceledOnTouchOutside,"");
        }
        else{
            hideProgressDialog();
            mProfressDialog = new ProgressDialog(this, isCanceledOnTouchOutside,"");
        }
    }

    public void hideProgressDialog() {
        if (mProfressDialog != null) {
            mProfressDialog.destroyProgressDialog();
            mProfressDialog = null;
        }
    }


}
