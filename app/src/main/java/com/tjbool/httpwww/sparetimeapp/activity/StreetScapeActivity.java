package com.tjbool.httpwww.sparetimeapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.baidu.lbsapi.BMapManager;
import com.baidu.lbsapi.panoramaview.PanoramaView;
import com.tjbool.httpwww.sparetimeapp.BaseApplication;
import com.tjbool.httpwww.sparetimeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * description: 街景Activity
 * autour: TMM
 * date: 2018/6/2 11:22
 * update: 2018/6/2
 * version:
 */


public class StreetScapeActivity extends AppCompatActivity {

    @BindView(R.id.panorama)
    PanoramaView panorama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        // 先初始化BMapManager
        initBMapManager();
        setContentView(R.layout.activity_street_scape);
        ButterKnife.bind(this);

        initData();
    }

    private void initBMapManager() {
        BaseApplication app = (BaseApplication) this.getApplication();
        if (app.mBMapManager == null) {
            app.mBMapManager = new BMapManager(app);
            app.mBMapManager.init(new BaseApplication.MyGeneralListener());
        }
    }

    private void initData() {
        double lat = 39.91403075654526;
        double lon = 116.40391285827147;
        panorama.setPanorama(lon, lat, PanoramaView.COORDTYPE_BD09LL);
    }
}
