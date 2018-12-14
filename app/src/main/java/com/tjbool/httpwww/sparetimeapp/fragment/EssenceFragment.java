package com.tjbool.httpwww.sparetimeapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.activity.ApplyPermissionActivity;
import com.tjbool.httpwww.sparetimeapp.activity.ApplyPermissionTwoActivity;
import com.tjbool.httpwww.sparetimeapp.activity.CanvasStudyActivity;
import com.tjbool.httpwww.sparetimeapp.activity.CoordinateSystemActivity;
import com.tjbool.httpwww.sparetimeapp.activity.MotionEventStudyOneActivity;
import com.tjbool.httpwww.sparetimeapp.activity.SeekBatDemoActivity;
import com.tjbool.httpwww.sparetimeapp.activity.SoapTestActivity;
import com.tjbool.httpwww.sparetimeapp.activity.thread.ThreadDemoActivity;
import com.tjbool.httpwww.sparetimeapp.activity.time.CountDownTimeActivity;
import com.tjbool.httpwww.sparetimeapp.activity.viewstub.ViewStubActivity;
import com.tjbool.httpwww.sparetimeapp.activity.viewstudy.ViewOneActivity;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;
import com.tjbool.httpwww.sparetimeapp.layout.ConstraintLayoutStudyActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * description: 精华
 * autour: TMM
 * date: 2018/1/16 18:05
 * update: 2018/1/16
 * version:
 *    参考： https://mp.weixin.qq.com/s/l3BgeKJN6nkphUBSD60bjw
 *
 *    Fragment FragmentManager FragmentTransaction 深入理解
 *    https://blog.csdn.net/u011240877/article/details/78132990
 *
 *
 */

public class EssenceFragment extends BaseFragment {

    public final String TAG = this.getClass().getSimpleName();

    private boolean isLoadComplete ;

    @BindView(R.id.text_one_essence_fragment)
    TextView textOneEssenceFragment;


    public static EssenceFragment newInstance(String title) {
        EssenceFragment f = new EssenceFragment();
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
        isViewCreated = true;
        /**默认加载*/
        requestNetWork();
    }

    @Override
    protected void initView() {

    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_essence;
    }


    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        /**懒加载*/
        if (isViewCreated && !isLoadComplete) {
            textOneEssenceFragment.setText("滚你妈");
            requestNetWork();
        }
        Log.e(TAG, "EssenceFragment (此时可用)lazyLoadData");
    }

    /**
     * 进行网络加载
     */
    private void requestNetWork() {
        isLoadComplete = true;
        Log.e(TAG, "requestNetWork() 网络请求");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart 依然执行");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume 依然执行");
    }


    @OnClick({R.id.text_one_essence_fragment, R.id.text_two_essence_fragment, R.id.text_soap_activity,
            R.id.text_coordinate_activity, R.id.text_canvas_one_activity, R.id.text_dagger_activity,
            R.id.text_dagger_two_activity, R.id.text_constraint_activity, R.id.text_motionEvent_one_activity,
            R.id.text_seekBar_one_activity,R.id.text_recyclerView_divider_activity,R.id.text_thread_demo_activity,
            R.id.text_countdown_time_activity,R.id.text_view_activity,R.id.text_viewStub_activity})
    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.text_one_essence_fragment:
                Intent intent = new Intent(getActivity(), ApplyPermissionActivity.class);
                startActivity(intent);
                break;
            case R.id.text_two_essence_fragment:
                Intent intent1 = new Intent(getActivity(), ApplyPermissionTwoActivity.class);
                startActivity(intent1);
                break;
            case R.id.text_soap_activity:
                Intent intent2 = new Intent(getActivity(), SoapTestActivity.class);
                startActivity(intent2);
                break;
            case R.id.text_coordinate_activity:
                Intent intent3 = new Intent(getActivity(), CoordinateSystemActivity.class);
                startActivity(intent3);
                break;
            case R.id.text_canvas_one_activity:
                Intent intent4 = new Intent(getActivity(), CanvasStudyActivity.class);
                startActivity(intent4);
                break;
            case R.id.text_dagger_activity:
             //   Intent intent5 = new Intent(getActivity(), DaggerStudyActivity.class);
              //  startActivity(intent5);
                break;
            case R.id.text_dagger_two_activity:
              //  Intent intent6 = new Intent(getActivity(), DaggerStudyTwoActivity.class);
             //   startActivity(intent6);
                break;
            case R.id.text_constraint_activity:
                Intent intent7 = new Intent(getActivity(), ConstraintLayoutStudyActivity.class);
                startActivity(intent7);
                break;
            case R.id.text_motionEvent_one_activity:
                Intent intent8 = new Intent(getContext(), MotionEventStudyOneActivity.class);
                startActivity(intent8);
                break;
            case R.id.text_seekBar_one_activity:
                Intent intent9 = new Intent(getContext(), SeekBatDemoActivity.class);
                startActivity(intent9);
                break;
            case R.id.text_recyclerView_divider_activity:
                Intent intent10 = new Intent(getContext(), SeekBatDemoActivity.class);
                startActivity(intent10);
                break;
            case R.id.text_thread_demo_activity:
                Intent intent11 = new Intent(getContext(), ThreadDemoActivity.class);
                startActivity(intent11);
                break;
            case R.id.text_countdown_time_activity:
                startActivity(new Intent(getContext(), CountDownTimeActivity.class));
                break;
            case R.id.text_view_activity:
                startActivity(new Intent(getContext(), ViewOneActivity.class));
                break;
            case R.id.text_viewStub_activity:
                startActivity(new Intent(getContext(), ViewStubActivity.class));
                break;
            default:
        }
    }


}


/*
        只是最外层Fragment
        
        E/HomeFragment: onAttach
        E/HomeFragment: onCreate
        E/HomeFragment: onCreateView
        E/HomeFragment: onActivityCreated
        E/HomeFragment: onStart
        E/HomeFragment: onResume
        
        ViewPager +  Fragment  (ViewPager 默认加载第一页和第二页)

        I/ViewRootImpl: CPU Rendering VSync enable = true
        D/OpenGLRenderer: Use EGL_SWAP_BEHAVIOR_PRESERVED: true
        D/Atlas: Validating map...
        E/EssenceFragment: setUserVisibleHint: false
        E/ScienceFragment: setUserVisibleHint: false
        E/EssenceFragment: setUserVisibleHint: true
        E/EssenceFragment: EssenceFragment (此时可用)lazyLoadData

        此时setUserVisibleHint 已经执行，但是界面还没初始化，所以里面不能做更新界面的操作。
        这种情况只是针对ViewPager 中的第一个Fragment, 所以我们需要对第一个Fragment 做特殊的处理
         ① 在懒加载房中中，进行界面加载完毕 判断
         ② 默认进行数据加载，因为他是第一页

        E/EssenceFragment: onAttach
        E/EssenceFragment: onCreate
        E/ScienceFragment: onAttach
        E/ScienceFragment: onCreate
        E/EssenceFragment: onCreateView
        E/EssenceFragment: onActivityCreated
        E/EssenceFragment: onStart
        E/EssenceFragment: onStart 依然执行
        E/EssenceFragment: onResume
        E/EssenceFragment: onResume 依然执行
        
        因为ViewPager 的预加载，所以第二个Fragment 已经加载完毕

        E/ScienceFragment: onCreateView
        E/ScienceFragment: onActivityCreated
        E/ScienceFragment: onStart
        E/ScienceFragment: onResume

        当我们切换到第二个Fragment 的时候 ，就可以在 lazyLoadData 中加载数据了
        （因为此时第二个Fragment 已经加载完毕，此时他会加载第三个Fragment，依次类推）

        E/GameFragment: setUserVisibleHint: false
        E/EssenceFragment: setUserVisibleHint: false
        E/ScienceFragment: setUserVisibleHint: true
        E/ScienceFragment: ScienceFragment (此时可用)lazyLoadData
        E/GameFragment: onAttach
        E/GameFragment: onCreate
        E/GameFragment: onCreateView
        E/GameFragment: onActivityCreated
        E/GameFragment: onStart
        E/GameFragment: onResume
       （注意：此时我们并没有看到第三个Fragment,是指由于ViewPager 的预加载，第三个Fragment 提前从onAttach 走到 onResume）

        此时我们从第二个Fragment再次切换到第一个Fragment、

        E/ScienceFragment: setUserVisibleHint: false
        E/EssenceFragment: setUserVisibleHint: true
        E/EssenceFragment: requestNetWork() 网络请求
        E/EssenceFragment: EssenceFragment (此时可用)lazyLoadData

        此时第三个Fragment 会销毁（虽然我们没有看见界面）

        E/GameFragment: onPause
        E/GameFragment: onStop
        E/GameFragment: onDestroyView
        E/GameFragment: onDestroy
        E/GameFragment: onDetach

        当我们从第一个Fragment 在此回到第二个Fragment
        
        E/GameFragment: setUserVisibleHint: false
        E/EssenceFragment: setUserVisibleHint: false
        E/ScienceFragment: setUserVisibleHint: true
        E/ScienceFragment: ScienceFragment (此时可用)lazyLoadData
        E/GameFragment: onAttach
        E/GameFragment: onCreate
        E/GameFragment: onCreateView
        E/GameFragment: onActivityCreated
        E/GameFragment: onStart
        E/GameFragment: onResume

        当我们从第二个Fragment 切换到 第三个Fragment
        
        E/VideoFragment: setUserVisibleHint: false
        E/ScienceFragment: setUserVisibleHint: false
        E/GameFragment: setUserVisibleHint: true
        E/GameFragment: GameFragment (此时可用)lazyLoadData
        E/VideoFragment: onAttach
        E/VideoFragment: onCreate

        此时第一个Fragment 销毁
        E/EssenceFragment: onPause
        E/EssenceFragment: onStop
        E/EssenceFragment: onDestroyView
        E/EssenceFragment: onDestroy
        E/EssenceFragment: onDetach

        E/VideoFragment: onCreateView
        E/VideoFragment: onActivityCreated
        E/VideoFragment: onStart
        E/VideoFragment: onResume


*/
