package com.example.administrator.intenrviewtest.designpattern.factory;

public class 蒸饺子Factory implements IFactory {
    @Override
    public IAction createFactory() {
        return new 蒸饺子();
    }
}
