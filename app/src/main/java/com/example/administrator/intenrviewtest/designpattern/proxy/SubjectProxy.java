package com.example.administrator.intenrviewtest.designpattern.proxy;

public class SubjectProxy {

    private ISubject realSubject;


    public SubjectProxy(ISubject realSubject) {
        this.realSubject = realSubject;
    }

    public void submit() {
        realSubject.submit();
    }

    public void defend() {
        realSubject.defend();
    }
}
