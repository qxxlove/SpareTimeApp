package com.tjbool.httpwww.sparetimeapp.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.adapter.DynamicAdapter;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;
import com.tjbool.httpwww.sparetimeapp.entity.DynamicEntity;
import com.tjbool.httpwww.sparetimeapp.weight.InitListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/1/19.
 * 邮箱：123123@163.com
 */

public class UserDynamicFragment extends BaseFragment {

    @BindView(R.id.listView_dynamic_fragment)
    InitListView listViewDynamicFragment;

    private List<DynamicEntity> list;
    private DynamicAdapter dynamicAdapter;

    public static UserDynamicFragment newInstance(String title) {
        UserDynamicFragment f = new UserDynamicFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }


    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new DynamicEntity(i + "肖"));
        }
        dynamicAdapter = new DynamicAdapter(getActivity(), list, R.layout.item_listview_user_dynamic_fragment);
        listViewDynamicFragment.setAdapter(dynamicAdapter);

        listViewDynamicFragment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(listViewDynamicFragment,"这是massage(默认只显示message)", Snackbar.LENGTH_LONG).setAction("这是action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(),"你点击了action",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_dynamic_user;
    }


}
