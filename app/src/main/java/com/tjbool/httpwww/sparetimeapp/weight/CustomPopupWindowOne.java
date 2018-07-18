package com.tjbool.httpwww.sparetimeapp.weight;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;

import com.tjbool.httpwww.sparetimeapp.R;

import razerdp.basepopup.BasePopupWindow;

/** 
 * description: 自定义PopupWindow
 * autour: TMM
 * date: 2018/5/24 9:28 
 * update: 2018/5/24
 * version: 
*/

public class CustomPopupWindowOne extends BasePopupWindow implements View.OnClickListener{
    
    public CustomPopupWindowOne(Context context) {
        super(context);
    }

    @Override
    protected Animation initShowAnimation() {
        AnimationSet set=new AnimationSet(false);
        Animation shakeAnima=new RotateAnimation(0,15,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        shakeAnima.setInterpolator(new CycleInterpolator(5));
        shakeAnima.setDuration(400);
        set.addAnimation(getDefaultAlphaAnimation());
        set.addAnimation(shakeAnima);
        return null;
    }

    @Override
    public View getClickToDismissView() {
        return getPopupWindowView();
    }

    @Override
    public View onCreatePopupView() {
        return createPopupById(R.layout.popup_test_one_layout);
    }

    @Override
    public View initAnimaView() {
        return findViewById(R.id.ll_popupWindowContent_one);
    }

    @Override
    public void onClick(View view) {
        
    }
}
