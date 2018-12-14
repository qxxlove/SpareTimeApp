package com.tjbool.httpwww.sparetimeapp.activity.time;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 倒计时控件
 */

public class CountDownTimeActivity extends AppCompatActivity {

    @BindView(R.id.text_time_count)
    TextView textTimeCount;

    
    private int totalTime = 11;
    private Timer timer = new Timer();

    
    private Handler.Callback callback = new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    totalTime--;
                    textTimeCount.setText(totalTime+"S");

                    if(totalTime > 0){
                        Message message1 = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message1, 1000);    
                    }
                  break;
                case 2:
                    totalTime--;
                    textTimeCount.setText(totalTime+"S");
                    break;
                    default:
            }
            return false;
        }
    };
    private  Handler handler = new Handler(callback);

   


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_time);
        ButterKnife.bind(this);

        /**不建议使用*/
        //initTimer();

        /**2使用handler*/
       // Message message = handler.obtainMessage(1);
       // handler.sendMessageDelayed(message, 1000);

        /**Handler + 线程池*/
       // initScheduleExecutor();

        /**5累加*/
        handler.postDelayed(runnable, 1000);



    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            totalTime++;
            textTimeCount.setText(totalTime+"个");
            handler.postDelayed(this, 1000);
        }
    };


    private void initScheduleExecutor() {
        ScheduledExecutorService scheduledExecutorService =
                new ScheduledThreadPoolExecutor(1/*, new ThreadFactory() {
                    @Override
                    public Thread newThread(@NonNull Runnable runnable) {
                        return null;
                    }
                }*/);
        scheduledExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                /**如果是累加，可以使用 while(true)*/
                for (int i = 0; i <11 ; i++) {
                    try {
                        Thread.sleep(1000);
                        Message message = new Message();
                        message.what = 2;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    private void initTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                /**此处也可以用Handler代替*/
                runOnUiThread(new Runnable() {      // UI thread
                    @Override
                    public void run() {
                        totalTime--;
                        textTimeCount.setText(totalTime+"S");
                        if(totalTime < 1){
                            timer.cancel();
                        }
                    }
                });
            }
        };
        timer.schedule(task,1000,1000);
    }



}
