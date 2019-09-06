package com.example.administrator.intenrviewtest.designpattern.duty;

public class DebugLogger extends Logger {

    public DebugLogger(int level) {
        super(level);
    }

    @Override
    public void write(String str) {
        System.out.println("debug:" + str);
    }
}
