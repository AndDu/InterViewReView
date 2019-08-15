package com.example.administrator.intenrviewtest.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者?
 */
public class ObserverObject implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
