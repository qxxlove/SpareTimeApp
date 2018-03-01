package com.tjbool.httpwww.sparetimeapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.BaseApplication;
import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.adapter.UserInfoTabAdapter;
import com.tjbool.httpwww.sparetimeapp.base.BaseActivity;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;
import com.tjbool.httpwww.sparetimeapp.fragment.UserDynamicFragment;
import com.tjbool.httpwww.sparetimeapp.fragment.UserQuestionFragment;
import com.tjbool.httpwww.sparetimeapp.fragment.UserTitleFragment;
import com.tjbool.httpwww.sparetimeapp.utils.ActivityRecyclerCallBacksUtils;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;
import com.tjbool.httpwww.sparetimeapp.weight.WrapContentHeightViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * description:
 * autour: TMM
 * date: 2018/1/18 16:24
 * update: 2018/1/18
 * version:
 * 查看源码，可以看到CollapsingToolbarLayout是通过实现AppBarLayout的OnOffsetChangedListener接口，
 * 根据AppBarLayout的偏移来实现子布局和title的视差移动以及ContentScrim和StatusBarScrim的显示。
 * 那么我们也可以通过调用AppBarLayout的addOnOffsetChangedListener方法监听AppBarLayout的位移，
 * 判断CollapsingToolbarLayout的状态。
 */

public class UserInfoActivity extends BaseActivity implements  BaseFragment.OnFragmentInteractionListener{


    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.tv_toolbar_right)
    TextView tvToolbarRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.content_user_info)
    NestedScrollView contentUserInfo;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.abl_userInfo_activity)
    AppBarLayout appBarLayout;
    @BindView(R.id.bbl_layout_userInfo_activity)
    ButtonBarLayout buttonBarLayout;
    @BindView(R.id.img_bg_userInfo)
    ImageView imgBgUserInfo;

    @BindView(R.id.tab_user_info_activity)
    TabLayout tabUserInfoActivity;
    @BindView(R.id.tab_user_info_activity_two)
    TabLayout tabuserInfoActivityTwo;
    @BindView(R.id.viewpager_user_info_activity)
    WrapContentHeightViewPager viewpagerUserInfoActivity;
    @BindView(R.id.ll_info_user)
    LinearLayout llInfoUser;

    private CollapsingToolbarLayoutState state;
    public ActivityRecyclerCallBacksUtils arcus;




    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }



    private enum CollapsingToolbarLayoutState {
        EXPANDED,  // 展开
        COLLAPSED,  // 折叠
        INTERNEDIATE    // 中间
    }

    private List<Fragment>  fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        initToolBar();
        initData();
    }

    private void initData() {
        contentUserInfo.smoothScrollTo(0,0);
        fragmentList = new ArrayList<>();

        UserDynamicFragment dynamic = UserDynamicFragment.newInstance("Dynamic");
        UserQuestionFragment question = UserQuestionFragment.newInstance("Question");
        UserTitleFragment title = UserTitleFragment.newInstance("Title");


        fragmentList.add(dynamic);
        fragmentList.add(question);
        fragmentList.add(title);


        UserInfoTabAdapter adapter = new UserInfoTabAdapter(getSupportFragmentManager(), fragmentList);
        viewpagerUserInfoActivity.setAdapter(adapter);
        viewpagerUserInfoActivity.setOffscreenPageLimit(3);
        setIsTabVisiable(true);
    }


    public  void  setIsTabVisiable( boolean isVisiable) {
        if (isVisiable){
            tabUserInfoActivity.setVisibility(View.VISIBLE);
            tabuserInfoActivityTwo.setVisibility(View.GONE);
            tabUserInfoActivity.setupWithViewPager(viewpagerUserInfoActivity);
        }else {
            tabUserInfoActivity.setVisibility(View.GONE);
            tabuserInfoActivityTwo.setVisibility(View.VISIBLE);
            tabuserInfoActivityTwo.setupWithViewPager(viewpagerUserInfoActivity);
        }

    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        collapsingToolbar.setTitle("展开");
        toolbar.setNavigationIcon(R.mipmap.icon_back_finish);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, SnackBarTestActivity.class);
                startActivity(intent);
            }
        });


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {  // 位移为0
                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
                        state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
                        collapsingToolbar.setTitle("展开");//设置title为EXPANDED
                        setIsTabVisiable(true);
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                        collapsingToolbar.setTitle("");//设置title不显示
                        buttonBarLayout.setVisibility(View.VISIBLE);//显示播放按钮

                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
                        setIsTabVisiable(false);
                    }
                } else {
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                        if (state == CollapsingToolbarLayoutState.COLLAPSED) {
                            buttonBarLayout.setVisibility(View.GONE);//由折叠变为中间状态时隐藏播放按钮
                        }
                        collapsingToolbar.setTitle("中间过程");//设置title为INTERNEDIATE
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                        setIsTabVisiable(true);
                    }
                }


            }
        });

        buttonBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appBarLayout.setExpanded(true);
            }
        });

    }

    @Override
    protected void initIntentParam(Intent intent) {

    }

    @Override
    protected void setToolbarStyle() {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
