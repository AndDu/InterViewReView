package com.example.administrator.intenrviewtest.asynctask;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by YellowHuang on 2019/3/29.
 */

public class CustomExcutor implements Executor {

    @Override
    public void execute(@NonNull Runnable command) {
        ExecutorService executorService =
                Executors.newSingleThreadExecutor();

    }
}
