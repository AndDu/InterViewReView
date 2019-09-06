package com.example.administrator.intenrviewtest.designpattern.duty;

public class ErrorLogger extends Logger {

    public ErrorLogger(int level) {
        super(level);
    }

    @Override
    public void write(String str) {
        System.out.println("error:" + str);
    }
}
