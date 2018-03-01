package com.tjbool.httpwww.sparetimeapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * description:
 * autour: TMM
 * date: 2018/1/17 9:56
 * update: 2018/1/17
 * version:
 *
 * 源码分析:  setUserVisibleHint() 方法在 FragmentStatePagerAdapter  中：
 *  ① 在 instantiateItem 方法中，在我的数据集合中取出对应 positon 的 Fragment，
 *  直接给它的 setUserVisibleHint 设置为 false，然后才把它 add 进 FragmentTransaction 中，
 *  这恰恰解释了为什么 setUserVisibleHint 的第一次调用是在 onAttach 之前。

    ② 下一步 setUserVisibleHint 的设置是在 setPrimaryItem 中，
    setPrimaryItem 这个方法可以得到当前 ViewPager 正在展示的 Fragment，
    并且将上一个 Fragment 的 setUserVisibleHint 置为 false，将要展示的 setUserVisibleHint 置为 true。
*/

public class UserInfoTabAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mList;

    private String mTabTitle[] = new String[]{"动态", "回答", "文章"};

    public UserInfoTabAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitle[position];
    }

}
