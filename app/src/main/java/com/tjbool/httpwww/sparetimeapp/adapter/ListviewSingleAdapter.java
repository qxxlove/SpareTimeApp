package com.tjbool.httpwww.sparetimeapp.adapter;

import android.content.Context;
import android.widget.CheckBox;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.entity.SingleMutileBeanTwo;

import java.util.List;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/5/11.
 * 邮箱：123123@163.com
 */

public class ListviewSingleAdapter extends  BaseAdapter<SingleMutileBeanTwo> {

    public ListviewSingleAdapter(Context context, List<SingleMutileBeanTwo> datas, int mLayoutId) {
        super(context, datas, mLayoutId);
    }

    @Override
    public void convert(BaseViewHolder holder, SingleMutileBeanTwo bean) {
         holder.setText(R.id.tv_title,bean.getContent());
         CheckBox checkBox =  holder.getView(R.id.cb_checkbox);
         if (bean.isChcek()){
               checkBox.setChecked(true);
         }else {
             checkBox.setChecked(false);
         }
    }
}
