package com.tjbool.httpwww.sparetimeapp.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.adapter.MainTabAdapter;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * description: 首页
 * autour: TMM
 * date: 2018/1/16 18:05
 * update: 2018/1/16
 * version:
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tab_layout_home_fragment)
    TabLayout tabLayoutHomeFragment;
    @BindView(R.id.vp_home_fragment)
    ViewPager vpHomeFragment;

    private List<Fragment> fragmentList;
    public final String TAG = this.getClass().getSimpleName();

    public static HomeFragment newInstance(String title) {
        HomeFragment f = new HomeFragment();
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
         isViewCreated = true ;
    }

    /**
     *  如果以下代码放在onCreateView()，（initView()又在onCreate()中执行） 中执行有缺陷，因为只有在界面初始化的时候才执行，当主界面的四个Fragment来回切换，并不会重新创建Fragment ,因为Fragment 只是被隐藏而已
     只会执行 onHiddenChange() ,来显示与隐藏具体的Activity . 而下面的代码使我们在Fragment 中 嵌套 TabLayout 和 (ViewPager+Fragment） 来实现二级目录
     ViewPager 具有预加载的功能，而我们又想让Fragment 懒加载，
     我们就需要：vpHomeFragment.setOffscreenPageLimit(6);
     对于Framgment 的懒加载 此时Adapter 帮我们很好的管理了 通过setUserVisibleHint()生命周期 ,来实现我们具体的业务。
     我们一级Fragment 通过 onHiddenChange 结合 二级Fragment通过 setUserVisibleHint 来很好的管理Fragment，并获取最新数据等
     */
    @Override
    protected void initView() {
        fragmentList = new ArrayList<>();

        EssenceFragment essence = EssenceFragment.newInstance("Essence");
        ScienceFragment science = ScienceFragment.newInstance("Science");
        GameFragment game = GameFragment.newInstance("Game");
        VideoFragment video = VideoFragment.newInstance("Video");
        LiveFragment live = LiveFragment.newInstance("Live");
        BeautyFragment beauty = BeautyFragment.newInstance("Beauty");

        fragmentList.add(essence);
        fragmentList.add(science);
        fragmentList.add(game);
        fragmentList.add(video);
        fragmentList.add(live);
        fragmentList.add(beauty);

        MainTabAdapter adapter = new MainTabAdapter(getActivity().getSupportFragmentManager(), fragmentList);
        vpHomeFragment.setAdapter(adapter);
        //ViewPager 出于优化体验的好心，默认去加载相邻两页，来尽可能保证滑动的流畅性
        // setOffscreenPageLimit ：默认值是1（小于1的值就默认为1）
        // 实际项目开发中： 可是假如我们这是一个新闻资讯类的 app，每一个 tab 涉及了复杂的页面和大量的网络请求，
        // 这种预加载的机制带来的可能就是麻烦了。所以我们寻找一些办法试图去掉 ViewPager 的预加载。
        vpHomeFragment.setOffscreenPageLimit(6);
        tabLayoutHomeFragment.setupWithViewPager(vpHomeFragment);
    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_home;
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        if (isViewCreated){
            Log.e(TAG,"lazyLoadData");
        }
    }
}
