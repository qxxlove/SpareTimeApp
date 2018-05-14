package com.tjbool.httpwww.sparetimeapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.entity.SingleMutileBeanTwo;

import java.util.List;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/5/10.
 * 邮箱：123123@163.com
 */

public class SingleAdapterTwo extends  BaseAdapter<SingleMutileBeanTwo> {

    private OnRedBallChangListener redBallChangListener ;


    public SingleAdapterTwo(Context context, List<SingleMutileBeanTwo> datas, int mLayoutId) {
        super(context, datas, mLayoutId);
    }

    @Override
    public void convert(BaseViewHolder holder, SingleMutileBeanTwo bean) {
        final TextView redText=holder.getView(R.id.txt_redball);
        holder.setText(R.id.txt_redball, bean.getContent());

        holder.setClick(R.id.check_red, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (bean.isChcek()) {
                        bean.setChcek(false);
                        redText.setTextColor(Color.parseColor("#ffffff"));
                    }else {
                        bean.setChcek(true);
                        redText.setTextColor(Color.parseColor("#000000"));
                    }
                    notifyDataSetChanged();
                    redBallChangListener.setOnRedBallListener();
            

            }
        });

      
        CheckBox checkBox = holder.getView(R.id.check_red);
        checkBox.setChecked(bean.isChcek());
    }

    public  interface OnRedBallChangListener{
        public void setOnRedBallListener();
    }
    public void setOnRedBallListener(OnRedBallChangListener redBallChangListener){
        this.redBallChangListener=redBallChangListener;
    }


}
