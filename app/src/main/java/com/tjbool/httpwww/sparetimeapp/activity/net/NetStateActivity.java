package com.tjbool.httpwww.sparetimeapp.activity.net;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tjbool.httpwww.sparetimeapp.R;

/**
 * 网络状态判断
 */

public class NetStateActivity extends AppCompatActivity {

    private  NetChangeReceiver netChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_state);
        initReceiver();
    }

    private void initReceiver() {
          netChangeReceiver = new NetChangeReceiver();
          IntentFilter filter = new IntentFilter();
         //网络的连接（包括wifi和移动网络）
          filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
          registerReceiver(netChangeReceiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (netChangeReceiver != null){
            unregisterReceiver(netChangeReceiver);
        }
    }
}
