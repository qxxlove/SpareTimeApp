package com.tjbool.httpwww.sparetimeapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;
import com.tjbool.httpwww.sparetimeapp.utils.screen.SizeUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * description: 游戏
 * autour: TMM
 * date: 2018/1/16 18:05
 * update: 2018/1/16
 * version:
 */

public class GameFragment extends BaseFragment {

    @BindView(R.id.image_two)
    ImageView imageTwo;
    @BindView(R.id.image_three)
    ImageView imageThree;

    private Animation circle_anim;
    
    public static GameFragment newInstance(String title) {
        GameFragment f = new GameFragment();
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
        int px = SizeUtils.dp2px(20, getContext());
        Log.e("TAG", "转换后的px:" + px);
        int px1 = SizeUtils.dp2px(40, getContext());
        Log.e("TAG", "转换后的1px:" + px1);

       /* E/TAG: 转换后的px:26
        E/TAG: 转换后的1px:53*/

       imageTwo.setImageResource(R.mipmap.icon_location_red_b);

       initAnim();

       imageThree.startAnimation(circle_anim);

    }

    @OnClick({R.id.text_games})
    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.text_games:
                startGrowAnimation(imageTwo);
                break;
            default:
        }
    }

    private void initAnim() {
        circle_anim = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_round_rotate);
        circle_anim = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator lin = new LinearInterpolator();
        circle_anim.setInterpolator(lin);
        circle_anim.setDuration(2000);//设置动画持续周期
        circle_anim.setRepeatCount(-1);//设置重复次数
        circle_anim.setFillAfter(true);//动画执行完后是否停留在执行完的状态
    }


    /**
     * 地上生长的Marker 动画
     */
    private void startGrowAnimation(ImageView markerView) {
        if(markerView != null) {
            Animation animation = new ScaleAnimation(0,1,0,1);
            animation.setInterpolator(new LinearInterpolator());
            //整个移动所需要的时间
            animation.setDuration(1000);
            //设置动画
            markerView.setAnimation(animation);
            //开始动画
            markerView.startAnimation(animation);
        }
    }


    @Override
    protected void initView() {

    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_game;
    }


    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        Log.e(getClass().getSimpleName(), "GameFragment (此时可用)lazyLoadData");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
     
    }
}
