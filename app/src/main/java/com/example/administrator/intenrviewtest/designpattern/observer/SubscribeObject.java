package com.example.administrator.intenrviewtest.designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class SubscribeObject {


    List<Observer> list = new ArrayList<>();
    private int state;

    public void subscribe(Observer observer) {
        list.add(observer);
    }

    public void setState(int state) {
        this.state = state;
        notifyObserver();
    }

    private void notifyObserver() {
        if (list.size() == 0) return;
        for (Observer observer:list){
            observer.update(null,state);
        }
    }

}
