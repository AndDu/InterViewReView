package com.example.administrator.intenrviewtest.designpattern.duty;

public class WarnLogger extends Logger {

    public WarnLogger(int level) {
        super(level);
    }

    @Override
    public void write(String str) {
        System.out.println("warn:" + str);
    }
}
