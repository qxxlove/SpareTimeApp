package com.tjbool.httpwww.sparetimeapp.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/** 
 * description: 退出广播
 * autour: TMM
 * date: 2018/5/8 16:02 
 * update: 2018/5/8
 * version: 
*/

public class ExitBroadcastReceiver extends BroadcastReceiver {

    private Activity activity;

    public ExitBroadcastReceiver(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
         activity.finish();
    }
}
