package com.tjbool.httpwww.sparetimeapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.adapter.ListviewSingleAdapter;
import com.tjbool.httpwww.sparetimeapp.entity.SingleMutileBeanTwo;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingleMUtileTwoActivity extends AppCompatActivity {

    @BindView(R.id.lv_single_two_activity)
    ListView lvSingleTwoActivity;



    private List<SingleMutileBeanTwo> singleMutileBeanListTwo;
    private ListviewSingleAdapter listviewSingleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_mutile_two);
        ButterKnife.bind(this);
        initData();
        initClick();
    }

    private void initClick() {

        lvSingleTwoActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int currentNum = -1;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for(SingleMutileBeanTwo person : singleMutileBeanListTwo) {
                    //遍历list集合中的数据
                    person.setChcek(false);
                    //全部设为未选中
                }
                //选中
                if(currentNum == -1) {
                    singleMutileBeanListTwo.get(position).setChcek(true);
                    currentNum = position;
                    //同一个item选中变未选中
                } else if(currentNum == position){
                    for(SingleMutileBeanTwo person : singleMutileBeanListTwo) {
                        person.setChcek(false);
                    }
                    currentNum = -1;
                    //不是同一个item选中当前的，去除上一个选中的
                }else if(currentNum != position){
                    for(SingleMutileBeanTwo person : singleMutileBeanListTwo){
                        person.setChcek(false);
                    }
                    singleMutileBeanListTwo.get(position).setChcek(true);
                    currentNum = position;
                 }
                ToastUtils.showLongToast(singleMutileBeanListTwo.get(position).getContent());
                listviewSingleAdapter.notifyDataSetChanged();//刷新adapter
                }

        });

    }

    private void initData() {
        singleMutileBeanListTwo = new ArrayList<>();
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("1", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("2", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("3", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("4", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("5", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("6", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("7", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("8", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("9", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("10", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("11", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("12", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("13", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("14", false));
        singleMutileBeanListTwo.add(new SingleMutileBeanTwo("15", false));

        
        listviewSingleAdapter = new ListviewSingleAdapter(this, singleMutileBeanListTwo, R.layout.item_listview_layout_one);
        lvSingleTwoActivity.setAdapter(listviewSingleAdapter);
    }
}
