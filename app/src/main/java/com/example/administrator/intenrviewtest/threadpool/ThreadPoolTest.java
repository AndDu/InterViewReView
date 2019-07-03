package com.example.administrator.intenrviewtest.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by YellowHuang on 2019/4/1.
 */

public class ThreadPoolTest {

    //    public static final ExecutorService EXECUTORS= Executors.newCachedThreadPool();
//    public static final ExecutorService EXECUTORS= Executors.newFixedThreadPool(1);
//    public static final ExecutorService EXECUTORS= Executors.newSingleThreadExecutor();
    public static final ExecutorService EXECUTORS = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

}
