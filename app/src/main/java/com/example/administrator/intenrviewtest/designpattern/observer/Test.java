package com.example.administrator.intenrviewtest.designpattern.observer;

public class Test {


    public static void main(String[]  a){
        SubscribeObject2 subscribeObject2 = new SubscribeObject2();
        subscribeObject2.addObserver(new ObserverObject());
        subscribeObject2.addObserver(new ObserverObject());
        subscribeObject2.addObserver(new ObserverObject());
        subscribeObject2.setChanged();
        subscribeObject2.notifyObservers("啊啊大");
    }

}
