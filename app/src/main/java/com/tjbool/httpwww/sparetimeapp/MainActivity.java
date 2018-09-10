package com.tjbool.httpwww.sparetimeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.tjbool.httpwww.sparetimeapp.activity.UserHelpActivity;
import com.tjbool.httpwww.sparetimeapp.base.BaseActivity;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;
import com.tjbool.httpwww.sparetimeapp.fragment.AttentionFragment;
import com.tjbool.httpwww.sparetimeapp.fragment.HomeFragment;
import com.tjbool.httpwww.sparetimeapp.fragment.MusicFragment;
import com.tjbool.httpwww.sparetimeapp.fragment.MyFragment;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * description:
 * autour: TMM
 * date: 2018/7/13 17:20
 * update: 2018/7/13
 * version:
 *           死磕Fragment的生命周期
 *    参考： https://mp.weixin.qq.com/s/FBfAR3W3y6R-q4Rt3uytKA
 *
*/

public class MainActivity extends BaseActivity  implements  BaseFragment.OnFragmentInteractionListener,Toolbar.OnMenuItemClickListener {

    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.tv_toolbar_right)
    TextView tvToolbarRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar_layout)
    AppBarLayout appbarLayout;
    @BindView(R.id.fl_main_activity)
    FrameLayout flMainActivity;
    @BindView(R.id.bottom_navigation_main_activity)
    AHBottomNavigation bottomNavigationMainActivity;
    @BindView(R.id.activity_main)
    CoordinatorLayout activityMain;



    private static final String TAG = "MainActivity";

    private HomeFragment  homeFragment;
    private AttentionFragment attentionFragment;
    private MyFragment myFragment;
    private MusicFragment musicFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initToolbar();
        initView();
        initData();
        initListener();
    }

    private void initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(this);

    }
    private void initView() {
        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(getResources().getString(R.string.tab_first_page), R.mipmap.icon_tab_home);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(getResources().getString(R.string.tab_attention), R.mipmap.icon_tab_work);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(getResources().getString(R.string.tab_music), R.mipmap.ic_bottom_music);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(getResources().getString(R.string.tab_my), R.mipmap.icon_tab_mine);

        // Add items
        bottomNavigationMainActivity.addItem(item1);
        bottomNavigationMainActivity.addItem(item2);
        bottomNavigationMainActivity.addItem(item3);
        bottomNavigationMainActivity.addItem(item4);

        // 默认背景颜色
        bottomNavigationMainActivity.setDefaultBackgroundColor(ContextCompat.getColor(this, R.color.bg_bottom_navigation));
        // 切换时颜色的转变
        bottomNavigationMainActivity.setAccentColor(ContextCompat.getColor(this, R.color.accent_bottom_navigation));
        bottomNavigationMainActivity.setInactiveColor(ContextCompat.getColor(this, R.color.inactive_bottom_navigation));
        // 强制着色
        bottomNavigationMainActivity.setForceTint(true);
        // 强制展示标题
        bottomNavigationMainActivity.setForceTitlesDisplay(true);
        // 使用圆圈效果
        bottomNavigationMainActivity.setColored(false);
        // Set current item programmatically
        bottomNavigationMainActivity.setCurrentItem(0);
    }

    private void initData() {
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance(getString(R.string.tab_first_page));
        }

        if (!homeFragment.isAdded()) {
             // 提交事务
            getSupportFragmentManager().beginTransaction().add(R.id.fl_main_activity, homeFragment).commitAllowingStateLoss();

        } else {
            getSupportFragmentManager().beginTransaction().show(homeFragment).commitAllowingStateLoss();
        }

        // 记录当前的Fragment
        currentFragment = homeFragment;
        tvToolbarTitle.setText(getString(R.string.tab_first_page));
    }
    private void initListener() {
        bottomNavigationMainActivity.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                Log.d(TAG, "onTabSelected: position:" + position + ",wasSelected:" + wasSelected);
                if (position == 0) {// 首页
                    clickHomeLayout();
                } else if (position == 1) {// 关注
                    clickAttentionLayout();
                } else if (position == 2) {// 音乐
                    clickMusicLayout();
                } else if (position == 3) {  // 我的
                    clickMyLayout();
                }
                return true;
            }
        });


    }

    private void clickMyLayout() {
        if (myFragment == null) {
            myFragment = MyFragment.newInstance(getString(R.string.tab_my));
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), myFragment);
    }

    private void clickMusicLayout() {
        if (musicFragment == null) {
            musicFragment = MusicFragment.newInstance(getString(R.string.tab_music));
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), musicFragment);

    }

    private void clickAttentionLayout() {
        if (attentionFragment == null) {
            attentionFragment = AttentionFragment.newInstance(getString(R.string.tab_attention));
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), attentionFragment);
    }

    private void clickHomeLayout() {
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance(getString(R.string.tab_my));
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), homeFragment);

    }

    @Override
    protected void initIntentParam(Intent intent) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_dialog:
                ToastUtils.showShortToast("dialog");
               return  true;
            case R.id.action_permissions:
                ToastUtils.showShortToast("permission");
                return  true;
            case R.id.action_settings:
                ToastUtils.showShortToast("setting");
                return  true;
            default:
        }
        return false;
    }

    @OnClick(R.id.tv_toolbar_right)
    public void onClick() {
        ToastUtils.showShortToast("右上角");
        Intent intent = new Intent(MainActivity.this, UserHelpActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void setToolbarStyle() {
        if (currentFragment instanceof HomeFragment) {
            tvToolbarTitle.setText(getString(R.string.tab_first_page));
            tvToolbarRight.setText("one");
        } else if (currentFragment instanceof MusicFragment) {
            tvToolbarTitle.setText(getString(R.string.tab_music));
            tvToolbarRight.setText("two");
        } else if (currentFragment instanceof AttentionFragment) {
            tvToolbarTitle.setText(getString(R.string.tab_attention));
            tvToolbarRight.setText("three");
        } else if (currentFragment instanceof MyFragment) {
            tvToolbarTitle.setText(getString(R.string.tab_my));
            tvToolbarRight.setText("four");
        }
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            // 是否退出App的标识
            boolean isExitApp = intent.getBooleanExtra("exit", false);
            if (isExitApp) {
                // 关闭自身
                this.finish();
            }
        }
    }
}



/*
 1. Error:Execution failed for task ':app:transformClassesWithDexBuilderForDebug'.
        com.android.build.api.transform.TransformException:
        java.lang.IllegalStateException: Dex archives: setting .DEX extension only for .CLASS files
        解决; 
           由于 app gradle中同时引用了：V7，V4相同的jar包
                例如：compile 'com.android.support:support-v4:25.3.1'
                      compile 'com.android.support:appcompat-v7:25.3.1'
                      都是25.3.1。建议江v7隐藏掉。v4的兼容性更强

 2.Warning:Ignoring InnerClasses attribute for an anonymous inner class
 
 3.Error:Execution failed for task ':app:processDebugResources'.
> Failed to execute aapt
Error:org.gradle.process.internal.ExecException: Process 'command 'E:\AndroidStudio\sdk\build-tools\27.0.2\aapt.exe'' finished with non-zero exit value 1
Error:com.android.ide.common.process.ProcessException: Error while executing process E:\AndroidStudio\sdk\build-tools\27.0.2\aapt.exe with arguments {package -f --no-crunch -I E:\AndroidStudio\sdk\platforms\android-27\android.jar -M \\?\G:\github\SpareTimeApp\app\build\intermediates\manifests\full\debug\AndroidManifest.xml -S G:\github\SpareTimeApp\app\build\intermediates\res\merged\debug -m -J \\?\G:\github\SpareTimeApp\app\build\generated\source\r\debug -F G:\github\SpareTimeApp\app\build\intermediates\res\debug\resources-debug.ap_ --custom-package com.tjbool.httpwww.sparetimeapp -0 apk --preferred-density tvdpi --output-text-symbols \\?\G:\github\SpareTimeApp\app\build\intermediates\symbols\debug --no-version-vectors}
Error:java.util.concurrent.ExecutionException: com.android.ide.common.process.ProcessException: Error while executing process E:\AndroidStudio\sdk\build-tools\27.0.2\aapt.exe with arguments {package -f --no-crunch -I E:\AndroidStudio\sdk\platforms\android-27\android.jar -M \\?\G:\github\SpareTimeApp\app\build\intermediates\manifests\full\debug\AndroidManifest.xml -S G:\github\SpareTimeApp\app\build\intermediates\res\merged\debug -m -J \\?\G:\github\SpareTimeApp\app\build\generated\source\r\debug -F G:\github\SpareTimeApp\app\build\intermediates\res\debug\resources-debug.ap_ --custom-package com.tjbool.httpwww.sparetimeapp -0 apk --preferred-density tvdpi --output-text-symbols \\?\G:\github\SpareTimeApp\app\build\intermediates\symbols\debug --no-version-vectors}
Error:(35, 45) No resource found that matches the given name (at 'layout_constraintEnd_toStartOf' with value '@id/text_constraint_layout_five').
Error:(20, 45) No resource found that matches the given name (at 'layout_constraintEnd_toStartOf' with value '@id/text_constraint_layout_four').
G:\github\SpareTimeApp\app\build\intermediates\res\merged\debug\layout\activity_constraint_layout_activity_two.xml
Error:(35, 45) No resource found that matches the given name (at 'layout_constraintEnd_toStartOf' with value '@id/text_constraint_layout_five').
Error:(20, 45) No resource found that matches the given name (at 'layout_constraintEnd_toStartOf' with value '@id/text_constraint_layout_four').
G:\github\SpareTimeApp\app\src\main\res\layout\activity_constraint_layout_activity_two.xml


        */
