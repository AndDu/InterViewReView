package com.example.administrator.intenrviewtest.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicproxyTest {


    public static void main(String[] a) {

        final RealSubject realSubject = new RealSubject();
        InvocationHandler invocationHandler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                method.invoke(realSubject, args);
                return null;
            }

        };

        ISubject iSubject = (ISubject) Proxy.newProxyInstance(
                ISubject.class.getClassLoader(),
                new Class[]{ISubject.class},
                invocationHandler
        );

        iSubject.submit();

    }

}
