package com.example.administrator.intenrviewtest.handler;

import android.os.HandlerThread;

/**
 * Created by YellowHuang on 2019/6/20.
 */

public class HandlerThreadTest {



    public static void main(String[] a){
        HandlerThread handlerThread=new HandlerThread("",Thread.MAX_PRIORITY){
            @Override
            public void run() {
                super.run();
            }
        };
        handlerThread.start();
    }

}
