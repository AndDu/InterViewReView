package com.example.administrator.intenrviewtest.designpattern.factory;

public class 蒸面包Factory implements IFactory {
    @Override
    public IAction createFactory() {
        return new 蒸面包();
    }
}
