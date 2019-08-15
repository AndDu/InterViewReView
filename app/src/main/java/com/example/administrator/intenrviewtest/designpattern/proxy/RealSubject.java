package com.example.administrator.intenrviewtest.designpattern.proxy;

public class RealSubject implements ISubject {

    @Override
    public void submit() {
        System.out.println("提交");
    }

    @Override
    public void defend() {
        System.out.println("石锤");
    }
}
