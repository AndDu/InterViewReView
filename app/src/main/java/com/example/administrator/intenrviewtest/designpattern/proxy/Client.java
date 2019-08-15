package com.example.administrator.intenrviewtest.designpattern.proxy;

public class Client {

    public static void main(String[] a){

        //构建一个被代理对象
        RealSubject realSubject = new RealSubject();
        //代理对象
        SubjectProxy proxy = new SubjectProxy(realSubject);
        //代理对象帮忙调用
        proxy.submit();
        //代理对象帮忙调用
        proxy.defend();


    }

}
