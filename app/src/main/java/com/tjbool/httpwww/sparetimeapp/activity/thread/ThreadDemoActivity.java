package com.tjbool.httpwww.sparetimeapp.activity.thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tjbool.httpwww.sparetimeapp.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 参考：
 * http://www.cnblogs.com/whoislcj/p/5603277.html
 * 
 */

public class ThreadDemoActivity extends AppCompatActivity {

    private int count = 100;
    private boolean isRunning = false;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);

        isRunning = true;
        MyThread myThreadOne = new MyThread("线程一");
        MyThread myThreadTwo = new MyThread("线程二");
        MyThread myThreadThree = new MyThread("线程三");

       // myThreadOne.start();
       // myThreadTwo.start();
       // myThreadThree.start();


        MyRunable myRunable = new MyRunable();
        Thread threadFour  = new Thread(myRunable,"线程四");
        Thread threadFive  = new Thread(myRunable,"线程五");
        Thread threadSix  = new Thread(myRunable,"线程六");

       // threadFour.start();
       // threadFive.start();
       // threadSix.start();

        /**如何停止正在运行的线程
         *  通过interrupt方法和isInterrupted()方法来停止正在运行的线程，
         *  首先必须先让线程处于阻塞状态
         * */
        destroyThread(null);

        /**线程同步：
         * 线程的同步是为了防止多个线程访问一个数据对象时，造成数据不一致的问题。
         * 具体看下面的样例
         * */

        /**接着 我们引入线程池
         *
         *  1.）  new Thread()的缺点

                每次new Thread()耗费性能
                调用new Thread()创建的线程缺乏管理，被称为野线程，而且可以无限制创建，之间相互竞争，会导致过多占用系统资源导致系统瘫痪。
                不利于扩展，比如如定时执行、定期执行、线程中断

            2.）采用线程池的优点

                重用存在的线程，减少对象创建、消亡的开销，性能佳
               可有效控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，避免堵塞
               提供定时执行、定期执行、单线程、并发数控制等功能

         *
         *  首先 系统为我们提供四种写好的线程池：
         *       通过Executors提供四种线程池：
         *           newFixedThreadPool、
         *           newCachedThreadPool、
         *           newSingleThreadExecutor、
         *           newScheduledThreadPool。
         *       然后我们实际开发中，根据自身的业务需求，看上面的四种是否符合需求。否则就需要我们自定义线程了。
         *       Executors 返回的线程池对象的弊端如下：
         *        1) FixedThreadPool 和 SingleThreadPool ：
         *              允 许 的 请 求 队 列 长 度 为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM；
         *        2) CachedThreadPool 和 ScheduledThreadPool ：
         *              允 许 的 创 建 线 程 数 量 为Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM
         * */
           //initFixedThreadPool();
          // initCachedThreadPool();
        //  initScheduleThreadPool();
         // initSingleThreadPool();

          /**
           * 自定义线程池
           *     重要参数： 核心线程数
           *                最大线程数
           *                任务队列
           *                其他的参数根据实际的需求
           *
           *                 
           *
           *
           * */
           /**自定义优先级线程池*/
           initPriorityThreadPool();
          
    }

    /**
     * 自定义优先级线程池
     *
     * 以下的结果可能不正确，还需进一步确认
     *
     */
    private void initPriorityThreadPool() {
        ExecutorService executorService = new PriorityExecutor(5, false);
        for (int i = 0; i < 20; i++) {
            PriorityRunnable priorityRunnable = new PriorityRunnable(Priority.NORMAL, new Runnable() {
                @Override
                public void run() {
                    Log.e("ThreadDemoActivity", Thread.currentThread().getName()+"优先级正常");
                }
            });
            if (i % 3 == 1) {
                priorityRunnable = new PriorityRunnable(Priority.HIGH, new Runnable() {
                    @Override
                    public void run() {
                        Log.e("ThreadDemoActivity", Thread.currentThread().getName()+"优先级高");
                    }
                });
            } else if (i % 5 == 0) {
                priorityRunnable = new PriorityRunnable(Priority.LOW, new Runnable() {
                    @Override
                    public void run() {
                        Log.e("ThreadDemoActivity", Thread.currentThread().getName()+"优先级低");
                    }
                });
            }
            executorService.execute(priorityRunnable);
        }
    }

    
    /**
     * 单线程（永远只有一个线程在运行）
     * 该线程会等第一个任务执行完依次执行第二个任务
     */
    private void initSingleThreadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.e("ThreadDemoActivity", Thread.currentThread().getName());
                }
            };
            executorService.execute(syncRunnable);
        }
    }

    /**
     * 和newFixedThreadPool类似，不同的是newScheduledThreadPool是延时一定时间之后才执行
     *
     * 
     */
    private void initScheduleThreadPool() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.e("ThreadDemoActivity", Thread.currentThread().getName());
                }
            };
            executorService.schedule(syncRunnable, 5000, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * 可以看出缓存线程池大小是不定值，可以需要创建不同数量的线程，在使用缓存型池时，先查看池中有没有以前创建的线程，
     * 如果有，就复用.如果没有，就新建新的线程加入池中，缓存型池子通常用于执行一些生存期很短的异步型任务
     */
    private void initCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.e("ThreadDemoActivity", Thread.currentThread().getName());
                }
            };
            executorService.execute(syncRunnable);
        }
    }

    /**
     * newFixedThreadPool创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
     *  总之就是创建5个核心线程，谁处于空闲有任务，立马执行
     */
    private void initFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.e("ThreadDemoActivity", Thread.currentThread().getName());
                }
            };
            executorService.execute(syncRunnable);
        }
    }

    

    

    /**
     * 销毁线程方法
     */
    private void destroyThread(Thread thread) {
        try {
            if (null != thread && Thread.State.RUNNABLE == thread .getState()) {
                try {
                    Thread.sleep(500);
                    thread .interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            thread = null;
        }
    }


    public  class  MyThread  extends  Thread{

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            while (isRunning){
               // count();
                countSynchronized();
            }
        }
    }


    /**
     * 未同步的写法情况
     * 结果： 数据错乱
     */
    private void count() {
        if (count > 0) {
            Log.e("ThreadDemoActivity", Thread.currentThread().getName() + "--->" + count--);
        } else {
            isRunning = false;
        }
    }

    /**
     * 同步的写法
     *   synchronized 加锁
     */
    private void countSynchronized() {
        synchronized (this) {
            if (count > 0) {
                Log.e("ThreadDemoActivity", Thread.currentThread().getName() + "--->" + count--);
            } else {
                isRunning = false;
            }
        }
    }



    public  class  MyRunable  implements  Runnable{
        @Override
        public void run() {

        }
    }
}
