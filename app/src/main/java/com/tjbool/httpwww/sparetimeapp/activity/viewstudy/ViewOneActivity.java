package com.tjbool.httpwww.sparetimeapp.activity.viewstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.entity.PieChartData;
import com.tjbool.httpwww.sparetimeapp.weight.view.CheckView;
import com.tjbool.httpwww.sparetimeapp.weight.view.PieChartView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewOneActivity extends AppCompatActivity {

    @BindView(R.id.piechartview_one)
    PieChartView piechartviewOne;
    @BindView(R.id.checkview_id)
    CheckView checkviewId;
    @BindView(R.id.text_check)
    TextView textCheck;
    @BindView(R.id.text_uncheck)
    TextView textUncheck;


    List<PieChartData> pieChartDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_one);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        pieChartDataList.add(new PieChartData("吃", 12));
        pieChartDataList.add(new PieChartData("吃", 12));
        pieChartDataList.add(new PieChartData("吃", 45));
        pieChartDataList.add(new PieChartData("吃", 31));

        piechartviewOne.setData(pieChartDataList);
    }


    @OnClick({R.id.text_check,R.id.text_uncheck})
    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.text_check:
                 checkviewId.check();
                break;
            case R.id.text_uncheck:
                checkviewId.unCheck();
                break;
            default:
        }
    }
}
