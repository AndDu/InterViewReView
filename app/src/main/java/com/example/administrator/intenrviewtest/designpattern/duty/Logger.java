package com.example.administrator.intenrviewtest.designpattern.duty;

public abstract class Logger {

    public final static int DEBUG = 1;
    public final static int INFO = 2;
    public final static int WARN = 3;
    public final static int ERROR = 4;
    //下一个责任对象
    private Logger nextLogger;

    private int level;

    public Logger(int level) {
        this.level = level;
    }

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void print(int level, String str) {

        if (this.level == level) {
            write(str);
            return;
        }

        if (nextLogger != null) {
            nextLogger.print(level, str);
        } else {
            System.out.println("无下一个责任对象");
        }


    }

    public abstract void write(String str);

}
