package com.example.administrator.intenrviewtest.rxjava;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverString implements Observer<String> {


    @Override
    public void onSubscribe(Disposable d) {
        System.out.println("onSubscribe");
    }

    @Override
    public void onNext(String s) {
        System.out.println(s);
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("onError");
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
