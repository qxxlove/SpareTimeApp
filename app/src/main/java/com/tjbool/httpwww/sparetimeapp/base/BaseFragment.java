package com.tjbool.httpwww.sparetimeapp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * description:
 * autour: TMM
 * date: 2018/1/17 10:08
 * update: 2018/1/17
 * version:
 *      1.  关于 Fragment 的管理，主要就是两种方式，一是 add 和 hide 管理，二是 ViewPager + Fragment
 *      2.  什么是懒加载？    即Fragment 的 UI 对用户可见时才加载数据。
 *          如何判断 Fragment 的 UI 是否对用户可见？      Fragment 提供了一个方法 public void setUserVisibleHint(boolean isVisibleToUser)
 *          setUserVisibleHint 在什么时候调用？           对于单个 Fragment，setUserVisibleHint 是不会被调用的，只有该 Fragment 在 ViewPager 里才会被调用
 *
 *      3. 懒加载： 主要是因为预加载的 Fragment 已经创建完成一路调用了 onAttach --> onPause，也就是说这个 Fragment 此时可用的，懒加载才有理由生效。
 *
*/

public abstract class BaseFragment extends Fragment {

    protected boolean isViewCreated = false;

    private final String TAG = this.getClass().getSimpleName();

    protected OnFragmentInteractionListener fragmentInteractionListener;
    private Unbinder bind;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach");
        try {
            fragmentInteractionListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        View rootView = inflater.inflate(setFragmentLayoutID(), container, false);
        bind = ButterKnife.bind(this, rootView);
        initView();
        initData();
        initListener();
        return rootView;
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    public abstract int setFragmentLayoutID();


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView");
        bind.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach");

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG, "setUserVisibleHint: " + isVisibleToUser);
        if (getUserVisibleHint()) {
            lazyLoadData();
        }
    }

    /**
     * 使用场景： 有 onHiddenChanged 方法回调，如 ; 来回切换Fragment
     *            这时候显然你可以在 hide = false 时，做一些刷新操作，
     *            在 hide = true 时，做一些资源回收操作。
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "hidden:" + hidden);
    }

    /**
     * 懒加载方法
     */
    protected void lazyLoadData() {
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Bundle bundle);
    }

    public void runOnUIThread(Runnable r) {
        final Activity activity = getActivity();
        if (activity != null && r != null)
            activity.runOnUiThread(r);
    }





}
