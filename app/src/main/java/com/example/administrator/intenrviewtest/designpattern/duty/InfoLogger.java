package com.example.administrator.intenrviewtest.designpattern.duty;

public class InfoLogger extends Logger {

    public InfoLogger(int level) {
        super(level);
    }

    @Override
    public void write(String str) {
        System.out.println("info:" + str);
    }
}
