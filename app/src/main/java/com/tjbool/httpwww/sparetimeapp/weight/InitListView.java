package com.tjbool.httpwww.sparetimeapp.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/1/19.
 * 邮箱：123123@163.com
 */

public class InitListView extends ListView {
    public InitListView(Context context) {
        super(context);
    }

    public InitListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InitListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 我们知道，MeasureSpec的specMode一共三种类型:
     EXACTLY：一般是设置了明确的值或者是MATCH_PARENT
     AT_MOST：表示子布局限制在一个最大值内，一般为WARP_CONTENT
     UNSPECIFIED：表示子布局想要多大就多大（很少使用）
     将里面的View的onMeasure里面的高设置为最大（AT_MOST）即可解决冲突。
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
