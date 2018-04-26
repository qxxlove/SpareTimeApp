package com.tjbool.httpwww.sparetimeapp.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tjbool.httpwww.sparetimeapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * description: 申请Android 6.0 权限
 * autour: TMM
 * date: 2018/1/26 14:04
 * update: 2018/1/26
 * version:
 *   此权限框架 版本1.1.3  而系统发布的版本 已经到1.2.0
 *   此框架申请定位，录音等权限需待定
 */

public class ApplyPermissionActivity extends AppCompatActivity  implements EasyPermissions.PermissionCallbacks {

    private static final int APPLY_CODE = 100;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_apply_camera_activity)
    TextView textApplyCameraLocationActivity;
    @BindView(R.id.content_apply_permission)
    LinearLayout contentApplyPermission;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private static final String[] LOCATION_AND_CONTACTS =
            {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CONTACTS};

    private static final int RC_CAMERA_PERM = 123;
    private static final int RC_LOCATION_CONTACTS_PERM = 124;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_permission);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private boolean hasCameraPermission() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA);
    }

    private boolean hasLocationAndContactsPermissions() {
        return EasyPermissions.hasPermissions(this, LOCATION_AND_CONTACTS);
    }

    private boolean hasSmsPermission() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.READ_SMS);
    }

    @OnClick({R.id.text_apply_camera_activity,R.id.text_apply_location_activity})
    public  void   initClick(View view){
        switch (view.getId()){
            case R.id.text_apply_camera_activity:
                methodRequiresCameraPermission();
                break;
            case R.id.text_apply_location_activity:
                break;
            default:
        }
    }


    @AfterPermissionGranted(RC_CAMERA_PERM)
    private void methodRequiresCameraPermission() {
        String[] perms = {Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(this, perms)) {
           // 做自己的逻辑处理。。。
            Toast.makeText(this, "已获取相机权限", Toast.LENGTH_SHORT)
                    .show();
        } else {
            // 立即申请
            EasyPermissions.requestPermissions(this, getString(R.string.camera_and_location_rationale),
                    RC_CAMERA_PERM, perms);
        }
    }





    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * Some permissions have been granted
     * 已授予某些权限
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    /**
     * Some permissions have been denied
     * 某些权限被拒绝
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, R.string.returned_from_app_settings_to_activity, Toast.LENGTH_SHORT)
                .show();
    }
}
