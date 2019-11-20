package com.example.administrator.intenrviewtest.rxfamily.rxjava

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers


class RxJavaZip {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val observable1 = Observable.create(ObservableOnSubscribe<Int> {

                it.onNext(1)
                it.onNext(2)
                it.onNext(3)
                it.onNext(4)

            }).subscribeOn(Schedulers.io())

            val observable2 = Observable.create(ObservableOnSubscribe<String> {
                it.onNext("A")
                it.onNext("B")
                it.onNext("C")
            }).subscribeOn(Schedulers.io())


            Observable.zip(observable1, observable2, object : BiFunction<Int, String, String> {
                override fun apply(t1: Int, t2: String): String {
                    System.out.println(t1.toString() + t2)
                    return t1.toString() + t2;
                }

            }).subscribe(object : io.reactivex.Observer<String?> {
                override fun onComplete() {
                    System.out.print("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    System.out.print("onSubscribe")
                }

                override fun onNext(t: String) {
                    System.out.print(t)
                }

                override fun onError(e: Throwable) {
                    System.out.print("onError")
                }
            })

        }
    }

}