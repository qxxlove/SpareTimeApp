package com.tjbool.httpwww.sparetimeapp.adapter;

import android.content.Context;
import android.graphics.Color;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.entity.SingleMutileBean;

import java.util.List;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/5/10.
 * 邮箱：123123@163.com
 */

public class SingleAdapterOne  extends   BaseAdapter<SingleMutileBean>{

    private  int  checkItemPosition = 0;


    public SingleAdapterOne(Context context, List<SingleMutileBean> datas, int mLayoutId) {
        super(context, datas, mLayoutId);
    }

    @Override
    public void convert(BaseViewHolder holder, SingleMutileBean bean) {
         holder.setText(R.id.text_item_content, bean.getContent());

        if (checkItemPosition != -1) {
            if (checkItemPosition == holder.getPosition()) {
                holder.setTextContentColor(R.id.text_item_content, Color.parseColor("#ffffff"));
                holder.setBackResource(R.id.text_item_content,R.drawable.item_gridview_select_bg);
            } else {
                holder.setTextContentColor(R.id.text_item_content, Color.parseColor("#000000"));
                holder.setBackResource(R.id.text_item_content,R.drawable.item_gridview_uselect_bg);
            }
        }
    }



    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }


}
