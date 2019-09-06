package com.example.administrator.intenrviewtest.threadpool;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by YellowHuang on 2019/4/meinv.
 */

public class ThreadPoolTest {
    //    SynchronousQueue<Runnable>
    //    public static final ExecutorService EXECUTORS= Executors.newCachedThreadPool();
//    DelayQueue<Runnable>
    //    public static final ExecutorService EXECUTORS = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
//    DelayQueue<Runnable>
    public static final ExecutorService EXECUTORS = Executors.newSingleThreadScheduledExecutor();
    //    LinkedBlockingDeque<Runnable>
//    public static final ExecutorService EXECUTORS= Executors.newSingleThreadExecutor();
    //    LinkedBlockingDeque<Runnable>
//    public static final ExecutorService EXECUTORS= Executors.newFixedThreadPool(meinv);

//    PriorityBlockingQueue<Runnable> 按优先级来处理线程

    /**
     * execute和submit的区别
     * submit有返回值，excute是没有返回值的，
     * <p>
     * 这两个方法在ThreadPoolExecutor中可以看到
     * <p>
     * 然后不管调用的时候用的是submit还是excute，最后都会通过RunnableFutrue生成callable实例，
     * 在RunnableFutrue的run方法中调用callable实例的call方法。
     */
    public void s() {
        /**
         * 无返回值
         */
        EXECUTORS.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        /**
         * 有返回值
         */
        Future<?> submit = EXECUTORS.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
