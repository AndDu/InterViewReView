package com.example.administrator.intenrviewtest.designpattern.factory;

public class 蒸米糕Factory implements IFactory {
    @Override
    public IAction createFactory() {
        return new 蒸米糕();
    }
}
