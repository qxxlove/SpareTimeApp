package com.tjbool.httpwww.sparetimeapp.adapter;

import android.content.Context;

import com.tjbool.httpwww.sparetimeapp.R;

import java.util.List;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/3/28.
 * 邮箱：123123@163.com
 */

public class CoordinateAdapter extends  BaseAdapter<String> {

    public CoordinateAdapter(Context context, List<String> datas, int mLayoutId) {
        super(context, datas, mLayoutId);
    }

    @Override
    public void convert(BaseViewHolder holder, String bean) {
         holder.setText(R.id.text_item_coordinate_activity,bean);
    }
}
