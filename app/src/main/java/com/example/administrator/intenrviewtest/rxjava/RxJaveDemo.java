package com.example.administrator.intenrviewtest.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxJaveDemo {


    public static void main(String[] a) {

        /**
         * 测试分发和订阅
         */
        subcribe();
    }

    /**
     * 分发和订阅
     */
    public static void subcribe() {

        /**
         * 观察者
         */
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            /**
             *
             * @param e  事件发射~~，(づ￣3￣)づ╭❤～ biubiu~
             * @throws Exception
             */
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });

        observable
                .observeOn(AndroidSchedulers.mainThread())//观察者操作执行在主线程。
                .subscribeOn(Schedulers.io()) //中间过程执在异步线程
                .subscribe(observer);
    }
}
