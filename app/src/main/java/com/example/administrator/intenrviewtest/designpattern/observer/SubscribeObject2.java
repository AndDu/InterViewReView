package com.example.administrator.intenrviewtest.designpattern.observer;

import java.util.Observable;

public class SubscribeObject2 extends Observable {


    private String oldStr;

    @Override
    public synchronized void setChanged() {
        super.setChanged();
    }


    public void notifyObservers(String arg) {
        this.oldStr = arg;
        super.notifyObservers(arg);
    }

    @Override
    public synchronized boolean hasChanged() {
        return super.hasChanged();
    }

    @Override
    public synchronized void clearChanged() {
        super.clearChanged();
    }


}
