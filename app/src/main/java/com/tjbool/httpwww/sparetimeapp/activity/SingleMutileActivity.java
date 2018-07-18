package com.tjbool.httpwww.sparetimeapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.adapter.SingleAdapterOne;
import com.tjbool.httpwww.sparetimeapp.adapter.SingleAdapterTwo;
import com.tjbool.httpwww.sparetimeapp.base.BaseActivity;
import com.tjbool.httpwww.sparetimeapp.entity.SingleMutileBean;
import com.tjbool.httpwww.sparetimeapp.entity.SingleMutileBeanTwo;
import com.tjbool.httpwww.sparetimeapp.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingleMutileActivity extends BaseActivity implements SingleAdapterTwo.OnRedBallChangListener {

    @BindView(R.id.gd_single_one)
    GridView gdSingleOne;
    @BindView(R.id.gd_single_two)
    GridView gdSingleTwo;
    @BindView(R.id.text_listView_single)
    TextView textListViewSingle;

    private List<SingleMutileBean> singleMutileBeanList;
    private List<SingleMutileBeanTwo> singleMutileBeanListTwo;
    private SingleAdapterOne singleAdapterOne;
    private SingleAdapterTwo singleAdapterTwo;

    private List<String> seletctResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_mutile);
        ButterKnife.bind(this);
        initData();
        initClick();
    }

    private void initClick() {
        gdSingleOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                singleAdapterOne.setCheckItem(position);
            }
        });

        textListViewSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent intent = new Intent(SingleMutileActivity.this,SingleMUtileTwoActivity.class);
                  startActivity(intent);
            }
        });


    }

    private void initData() {
        seletctResult = new ArrayList<>();

        singleMutileBeanList = new ArrayList<>();
        singleMutileBeanList.add(new SingleMutileBean("1"));
        singleMutileBeanList.add(new SingleMutileBean("2"));
        singleMutileBeanList.add(new SingleMutileBean("3"));
        singleMutileBeanList.add(new SingleMutileBean("4"));
        singleMutileBeanList.add(new SingleMutileBean("5"));
        singleMutileBeanList.add(new SingleMutileBean("6"));
        singleMutileBeanList.add(new SingleMutileBean("7"));
        singleMutileBeanList.add(new SingleMutileBean("8"));
        singleMutileBeanList.add(new SingleMutileBean("9"));
        singleMutileBeanList.add(new SingleMutileBean("10"));
        singleMutileBeanList.add(new SingleMutileBean("11"));


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


        singleAdapterOne = new SingleAdapterOne(this, singleMutileBeanList, R.layout.item_single_gv_one_layout);
        gdSingleOne.setAdapter(singleAdapterOne);

        singleAdapterTwo = new SingleAdapterTwo(this, singleMutileBeanListTwo, R.layout.item_single_gv_two_layout);
        singleAdapterTwo.setOnRedBallListener(this);
        gdSingleTwo.setAdapter(singleAdapterTwo);

      
    }

    @Override
    protected void initIntentParam(Intent intent) {

    }

    @Override
    protected void setToolbarStyle() {

    }

    @Override
    public void setOnRedBallListener() {
        List<SingleMutileBeanTwo> datas = singleAdapterTwo.getDatas();
        seletctResult.clear();
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).isChcek() == true) {
                seletctResult.add(datas.get(i).getContent());
            }
        }
        ToastUtils.showLongToast(seletctResult.toString());
    }
}
