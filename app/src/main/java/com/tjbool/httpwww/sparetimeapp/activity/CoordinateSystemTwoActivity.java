package com.tjbool.httpwww.sparetimeapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.adapter.CoordinateAdapter;
import com.tjbool.httpwww.sparetimeapp.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoordinateSystemTwoActivity extends BaseActivity {

    @BindView(R.id.listView_coordinate_activity)
    ListView listViewCoordinateActivity;

    private List<String>  stringList;
    private CoordinateAdapter coordinateAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_system_two);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        stringList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
           stringList.add("哈哈"+i);
        }

        coordinateAdapter = new CoordinateAdapter(this,stringList,R.layout.item_listview_coordinate_activity);
        listViewCoordinateActivity.setAdapter(coordinateAdapter);

        listViewCoordinateActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(CoordinateSystemTwoActivity.this,CoordinateSystemThreeActivity.class);
            }
        });
    }

    @Override
    protected void initIntentParam(Intent intent) {

    }

    @Override
    protected void setToolbarStyle() {

    }

    /**
     * 不在activity的onTouchEvent中打印是因为ListView中的item消费了事件，
     * 那么这个activity的onTouchEvent就不会打印出Log了
     *
     *   切记： 获取getRawY()值时，根据实际需求是否需要减去状态栏的高度
     *  CoordinateSystemTwoActivity  getX 90.0 getY 111.0
       D/信息: CoordinateSystemTwoActivity  getrawx 90.0 getrawy 111.0
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d("信息","CoordinateSystemTwoActivity  getX " + event.getX() + " getY " + event.getY());
            Log.d("信息","CoordinateSystemTwoActivity  getrawx " + event.getRawX() + " getrawy " + event.getRawY());
        }
        return super.dispatchTouchEvent(event);

    }


}
