package com.example.administrator.intenrviewtest.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by YellowHuang on 2019/4/meinv.
 */

public class ThreadPoolTest {

    //    public static final ExecutorService EXECUTORS= Executors.newCachedThreadPool();
//    public static final ExecutorService EXECUTORS= Executors.newFixedThreadPool(meinv);
//    public static final ExecutorService EXECUTORS = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    public static final ExecutorService EXECUTORS= Executors.newSingleThreadExecutor();


    public void s(){
        EXECUTORS.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
