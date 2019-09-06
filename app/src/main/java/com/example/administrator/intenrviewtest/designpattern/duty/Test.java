package com.example.administrator.intenrviewtest.designpattern.duty;

public class Test {

    public static void main(String[] a) {


        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger infoLogger = new InfoLogger(Logger.INFO);
        Logger warnLogger = new WarnLogger(Logger.WARN);
        Logger debugLogger = new DebugLogger(Logger.DEBUG);


        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(warnLogger);
        warnLogger.setNextLogger(errorLogger);


        debugLogger.print(Logger.ERROR, "ERROR");
        debugLogger.print(Logger.INFO, "INFO");
        debugLogger.print(Logger.WARN, "WARN");
        debugLogger.print(Logger.DEBUG, "DEBUG");


    }
}
