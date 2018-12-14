package com.tjbool.httpwww.sparetimeapp.activity.thread;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/11/28.
 * 邮箱：123123@163.com
 */

public class PriorityRunnable  implements  Runnable {

    //任务优先级
    public final Priority priority;
    //任务真正执行者
    private final Runnable runnable;
    
    public long SEQ;//任务唯一标示

    
    public PriorityRunnable(Priority priority, Runnable runnable) {
        this.priority = priority == null ? Priority.NORMAL : priority;
        this.runnable = runnable;
    }

    @Override
    public final void run() {
        this.runnable.run();
    }

  
}
