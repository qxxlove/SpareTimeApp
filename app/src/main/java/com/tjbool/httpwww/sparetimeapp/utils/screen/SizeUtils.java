package com.tjbool.httpwww.sparetimeapp.utils.screen;

import android.content.Context;
import android.util.TypedValue;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/11/26.
 * 邮箱：123123@163.com
 */

public class SizeUtils {


    /**
     * dp转px
     *
     * @param dp dp值
     * @return px值
     */
    public static int dp2px(float dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @param sp sp值
     * @return px值
     */
    public static int sp2px(float sp,Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                context.getResources().getDisplayMetrics());
    }

}
