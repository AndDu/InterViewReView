package com.example.administrator.intenrviewtest.rxfamily.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class RxJavaBackPressure {


    public static void main(String[] a) {

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                for (int i = 0; ; i++) {
//                    e.onNext(i);
//                }
//            }
//        }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
////                Log.e(TAG, "accept: ", );
//            }
//        });


        Observable.zip(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; ; i++) {
                    e.onNext(1);
                }
            }
        }).subscribeOn(Schedulers.io()), Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("A");
            }
        }).subscribeOn(Schedulers.io()), new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        })
//                .sample()取样
//                .filter()过滤
                .subscribe(new ObserverString());

    }
}
