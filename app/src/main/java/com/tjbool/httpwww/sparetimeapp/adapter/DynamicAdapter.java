package com.tjbool.httpwww.sparetimeapp.adapter;

import android.content.Context;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.entity.DynamicEntity;

import java.util.List;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/1/19.
 * 邮箱：123123@163.com
 */

public class DynamicAdapter extends  BaseAdapter<DynamicEntity> {

    public DynamicAdapter(Context context, List<DynamicEntity> datas, int mLayoutId) {
        super(context, datas, mLayoutId);
    }

    @Override
    public void convert(BaseViewHolder holder, DynamicEntity bean) {
         holder.setText(R.id.text_content_list_dynamic_fragment, bean.getContent());
    }
}
