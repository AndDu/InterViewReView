package com.example.administrator.intenrviewtest.rxjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class RxJaveDemo {


    public static void main(final String[] a) {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onComplete();
            }
        }).defaultIfEmpty(4)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });

        /**
         * 测试分发和订阅
         */
//        subcribe();
    }


    public static void interval() {

        Observable
                .interval(5, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                        System.out.println();
                    }
                });
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


    /**
     * rxjava 创建操作符
     */
    public static void create() {

        //单纯创建一个任务
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        //--------------------------------------- fromIterable ---------------------------------------------------
        List<Integer> list = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            list.add(i);
        }
        Observable.fromIterable(list) //将数组单个返回
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        //--------------------------------------- just ---------------------------------------------------
        Observable.just(1, 1, 1, 1).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        //--------------------------------------- timer() ---------------------------------------------------
        Observable.timer(2, TimeUnit.SECONDS) //延时任务
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        //--------------------------------------- fromArray() ---------------------------------------------------
        Observable.fromArray(list) //将数组一次返回
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Integer> integers) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        //--------------------------------------- interval ---------------------------------------------------
        //下面代码表示每5秒发送一次，从0开始
        Observable.interval(5, TimeUnit.SECONDS) //定时任务
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        //--------------------------------------- intervalRange ---------------------------------------------------
        //和interval功能一样，不过多了前面的三个参数
        //     *  参数1： 起始发送值
        //         *  参数2：发送数量
        //         *  参数3：首次发送延迟事件
        //         *  参数4：每次发送事件间隔
        //         *  参数5：时间单位
        Observable.intervalRange(5, 10, 1, 10, TimeUnit.SECONDS) //定时任务
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        //--------------------------------------- range ---------------------------------------------------
        //无延时发送，
        //参数一：起始值
        //参数二：执行次数，
        Observable.range(0, 10) //
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /**
     * 转换操作符
     */
    public void change() {
        //--------------------------------------- map ---------------------------------------------------
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return String.valueOf(integer);
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        //--------------------------------------- flatMap ---------------------------------------------------
        //重新包装observable发送数据,不保证顺序
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
            }
        });
        observable.flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(final Integer integer) throws Exception {
                //ObservableSource是observable的父类
                return Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> e) throws Exception {
                        e.onNext(String.valueOf(integer));
                    }
                });
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        //--------------------------------------- concatMap ---------------------------------------------------
        //重新包装observable发送数据,和flatMap不一样，concatMap保证顺序
        observable.concatMap(new Function<Integer, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Integer integer) throws Exception {
                return null;
            }
        }).subscribe();

        //--------------------------------------- buffer ---------------------------------------------------
        //将数据分段发送  buffer 中的参数是每段数据的个数
        Observable.just(1, 2, 3, 4, 5, 6).buffer(2).subscribe();


    }


    /**
     * 合并操作符
     */
    public static void merge() {

        /**
         * ======================== merge，concat 操作符 ======================================
         *
         * merge操作符是把多个Observable合并成一个进行发射。merge可能会让合并到Observable的数据顺序发生错乱(组合被观察者数量<=4个)(并行无序)
         * mergeArray操作符和merge作用一样，但不同的是组合被观察者数量>4个)(并行无序)
         *
         * concat操作符也是把多个Observable合并成一个进行发射。但concat则保证合并的每个Observable的事件按顺序发射出去。(组合被观察者数量<=4个)(串行有序)
         * concatArray操作符和concat作用一样，但不同的是组合被观察者数量>4个)(串行有序)
         */

        Observable<Integer> just = Observable.just(1, 2, 3);
        Observable.merge(just, Observable.just("1", "b", "c")).subscribe();

        //--------------------------------------- concatArrayDelayError ---------------------------------------------------
//       * 这两个操作符的作用是： 使用concat()和merge()操作符时，若其中一个被观察者发送onError事件，则会马上终止其它被观察者继续发送事件。所以呐，这时使用concatError()/
//     * mergeDelayError()事件可以使onError事件推迟到其它被观察者发送事件结束后在再触发


        Observable.concatArrayDelayError(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new NullPointerException()); //error会被延时发送，会等到Observable.just(1, 2, 3, 4)发送完毕之后才会会发送error
                e.onNext(4);
                e.onNext(5);
            }
        }), Observable.just(1, 2, 3, 4)).subscribe();

        //--------------------------------------- zip ---------------------------------------------------
        //将两个发射源发送的数据按顺序发射，长度以短的为准

        Observable<String> just1 = Observable.just("a", "b", "c", "d");
        Observable<Integer> just2 = Observable.just(1, 2, 3, 4);
        Observable.zip(just1, just2, new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) throws Exception {
                return s + integer;
            }
        }).subscribe();

        //--------------------------------------- combineLatest ---------------------------------------------------
        //当两个Observable 中的任何一个发送了数据，将先发送了数据的Observable的最新（最后）一个数据和另一个Observable发送的每个数据结合，最终基于该结合的结果发送数据
        //与zip()的区别： zip()是按个数合并，即1对1合并；而combineLatest()是基于时间合并，，即在同一时间点上合并
        Observable.combineLatest(just1, Observable.intervalRange(1, 4, 1, 1, TimeUnit.SECONDS), new BiFunction<String, Long, String>() {
            @Override
            public String apply(String s, Long aLong) throws Exception {
                return s + aLong;
            }
        }).subscribe();

        //--------------------------------------- reduce ---------------------------------------------------、
        //reduce 减少
        //减少事件，以某种规则去把事件处理了,是否定义第一个数据
        Observable.just(1, 2, 3, 4, 5, 6, 7).reduce(-1, new BiFunction<Integer, Integer, Integer>() {
            @Override
            /**
             *
             */
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });

        //--------------------------------------- collect ---------------------------------------------------
        //将发送的数据收集到某个容器中
        Observable.just(1, 2, 3, 4, 5, 6, 7).collect(new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                return new ArrayList<>();
            }
        }, new BiConsumer<List<Integer>, Integer>() {
            @Override
            public void accept(List<Integer> integers, Integer integer) throws Exception {
                integers.add(integer);
            }
        }).subscribe();

        //--------------------------------------- startWith/startWithArray ---------------------------------------------------
        //事件数据发送前需要发送的数据
        Observable.just(1, 2, 3, 4, 5, 3)
                .startWith(1)
                .startWithArray(2, 3, 54)
//                .startWith(list)
                .startWith(Observable.just(1, 1, 1))
                .subscribe();

        //---------------------------------------count ---------------------------------------------------
        //获取发送事件的个数
        Observable.just(1, 2, 31, 5).count().subscribe();

    }


    /**
     * 功能操作符
     */
    public static void function() {
        //---------------------------------------subscribe ---------------------------------------------------
        //订阅，必须订阅了事件才会开始执行

        //---------------------------------------delay ---------------------------------------------------
        /**
         * 延迟发送事件
         *
         * delay有多个重载方法：
         *
         * delay(long delay,TimeUnit unit) :指定延迟时间。 参数一：时间 ； 参数二：时间单位
         *
         * delay(long delay, TimeUnit unit, Scheduler scheduler)  指定延迟时间&线程调度器。参数一：时间 ； 参数二：时间单位；参数三： 线程调度器
         *
         * delay(long delay, TimeUnit unit, boolean delayError)  指定延迟时间&线程调度器。参数一：时间 ； 参数二：时间单位；参数三： 是否错误延迟
         *
         * delay(long delay, TimeUnit unit, Scheduler scheduler, boolean delayError)  指定延迟时间&线程调度器&错误延迟。参数一：时间 ； 参数二：时间单位；
         * 参数三： 线程调度器; 参数四：是否错误延迟(若中间发生错误，是否如常执行，执行完在执行onError())
         */
        //延时任务
        Observable.just(1, 2, 31, 5).delay(1, TimeUnit.SECONDS).subscribe();
        Observable.just(1, 2, 31, 5).delay(1, TimeUnit.SECONDS, true).subscribe();
        Observable.just(1, 2, 31, 5).delay(1, TimeUnit.SECONDS, Schedulers.io(), true).subscribe();


        //---------------------------------------do 系列操作符 ---------------------------------------------------
        /**  * 在事件发送&接收的整个周期过程中进行操作。
         *
         * 如发送事件前的操作，发送事件后的回调请求
         *
         * do系列操作符包含以下：
         *
         * doOnEach() :当Observable每发送一次事件就会调用一次(包含onNext()，onError()，onComplete())
         * doOnNext(): 执行 onNext()前调用
         * doAfterNext()： 执行onNext()后调用
         * doOnComplete()：执行onComplete()前调用
         * doOnError():执行 onError()前调用
         * doOnTerminate(): 执行终止(无论正常发送完毕/异常终止)  正常发送完毕没见执行
         * doFinally(): 最后执行
         * doOnSubscribe() ：观察者订阅是调用
         * doOnUnScbscribe()： 观察者取消订阅时调用
         */
        Observable
                .just(1, 2, 31, 5)
                .flatMap(new Function<Integer, ObservableSource<Integer>>() {
                             @Override
                             public ObservableSource<Integer> apply(final Integer integer) throws Exception {
                                 System.out.println(integer);
                                 return Observable.create(new ObservableOnSubscribe<Integer>() {
                                     @Override
                                     public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                                         System.out.println("integer：" + integer);
                                         e.onNext(integer);
                                         e.onError(new NullPointerException());
                                     }
                                 });
                             }
                         }, true //延时错误，让所有  e.onNext(integer);全执行完再执行  onError回调，方便查看执行其他的do系列方法。
                ).doOnTerminate(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doOnTerminate");
            }
        }).doAfterTerminate(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doAfterTerminate");
            }
        }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("doFinally");
            }
        }).doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("doOnNext");
            }
        })

                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        //---------------------------------------onErrorReturn / onErrorReturnItem---------------------------------------------------
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

            }
        }).onErrorReturn(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable throwable) throws Exception {
                return 111;
            }
        }).onErrorReturnItem(1).subscribe();


        //---------------------------------------onExceptionResumeNext / onErrorResumeNext---------------------------------------------------
        //遇到错误时发送一个新的Observable 。并且正常终止.注意原Observable后面的事件不会再发送
        //如果捕获Exception的话使用onExceptionResumeNext() ，捕获错误的用onErrorResumeNext()
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> apply(Throwable throwable) throws Exception {
                return null;
            }
        }).onExceptionResumeNext(new Observable<Integer>() {
            @Override
            protected void subscribeActual(Observer<? super Integer> observer) {

            }
        }).subscribe();

        //--------------------------------------- retry ---------------------------------------------------
        /**
         * 作用是：出现错误时，让被观察者重新发送数据
         * 注：若发送错误，则一直重新发送
         *
         * 有几个重载方法：
         * retry() ： 出现错误时，让被观察者重新发送数据。若错误一直发生，则一直重新发送
         *
         * retry(long time)：与retry不同的书，若错误一直发生，被观察者则一直重新发送数据，但这持续重新发送有次数限制
         *
         * retry(Predicate predicate) ：  出现错误时，根据指定逻辑(可以捕获到发生的错误)决定是否让被观察者重新发送数据
         *
         * retry(new BiPredicate<Integer, Throwable>)：出现错误时，根据指定逻辑(可以捕获重发的次数和发生的错误)决定是否让被观察者重新发送数据
         *
         * retry（long time,Predicate predicate） ： 出现错误时，根据指定逻辑(可以捕获到发生的错误)决定是否让被观察者重新发送数据。并且有持续重发的次数限制
         */

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

            }
        })
                .retry() //一直重试
                .retry(3)//重试三次
                .retry(new Predicate<Throwable>() {
                    @Override
                    public boolean test(Throwable throwable) throws Exception {
                        return false;
                    }
                })
                .retry(new BiPredicate<Integer, Throwable>() {
                    @Override
                    public boolean test(Integer integer, Throwable throwable) throws Exception {
                        return false;
                    }
                })
                .retry(3, new Predicate<Throwable>() {
                    @Override
                    public boolean test(Throwable throwable) throws Exception {
                        return false;
                    }
                })
                .subscribe();

        //--------------------------------------- retryUntil ---------------------------------------------------
        /**
         * 发送事件遇到错误，指定规则是否重新发送。retry(Predicate predicate)。
         *
         *   return true ： 不重新发送请求，并且调用观察者的onError()方法结束
         *   return false ： 重新发送数据(若持续遇到错误，就持续重新发送)
         *
         *
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

            }
        }).retryUntil(new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() throws Exception {
                //isStop
                return false;
            }
        }).subscribe();

        //--------------------------------------- retryWhen ---------------------------------------------------
        //遇到错误时，将发生的错误传递给一个新的被观察者(Observable)，并决定是否需要重新订阅原始被观察者(Observable) &  发送事件
        //     */
        //     ------------TODO------------
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new NullPointerException());
                e.onNext(3);
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> apply(Observable<Throwable> throwableObservable) throws Exception {
//                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
//
//                        //1、若返回的Observable发送的事件 = Error ，则原始的Observable则不重新发送事件。该异常信息可在观察者的onError中获得
//                        //return Observable.error(throwable);
//
//                        //2、若返回的Observable发送的事件= Next事件(和next的内容无关)，则原始的Observable重新发送事件(若持续遇到错误，则持续发送)
//                        return Observable.just(5); //仅仅是作为一个触发重新订阅原被观察者的通知，什么数据并不重要，只有不是onComplete/onError事件
////
//                    }
//                },);

                return null;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        });


        //--------------------------------------- repeat ---------------------------------------------------

        Observable.just(1, 2).repeat(10).subscribe();

        //--------------------------------------- debounce ---------------------------------------------------

        //一段时间后无操作就会发送事件（只会发送最后一次操作的事件）,
        Observable.intervalRange(1, 5, 0, 2, TimeUnit.SECONDS).debounce(2, TimeUnit.SECONDS).subscribe();

        //--------------------------------------- subscribeOn / ObserverOn ---------------------------------------------------

    }

    /**
     *
     */
    public void filter() {
        //--------------------------------------- filter ---------------------------------------------------
        Observable.just(1, 2, 3, 4, 5, 6).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer % 2 == 0;
            }
        }).subscribe();


        //--------------------------------------- distinct ---------------------------------------------------
        //去除集合中重复的数据
        Observable.just(1, 2, 3, 4, 5, 6).distinct().subscribe();


        //--------------------------------------- distinctUntilChanged ---------------------------------------------------
        //去除连续重复的数据
        Observable.just(1, 2, 2, 2, 2, 3, 4, 5, 6).distinctUntilChanged().subscribe();

        //--------------------------------------- skip/skipLast ---------------------------------------------------
        //skip跳过前n项
        //skipLast 跳过后面的n项
        Observable.just(1, 2, 2, 2, 2, 3, 4, 5, 6).skip(2).skipLast(2).subscribe();
        //跳过前一秒的数据
        Observable.intervalRange(1, 5, 0, 1, TimeUnit.SECONDS).skip(1, TimeUnit.SECONDS).subscribe();

        //--------------------------------------- take/takeLast ---------------------------------------------------
        //take取前面N项
        //takeLast取后面N项
        Observable.just(1, 2, 3, 4, 5, 6).take(2).takeLast(2).subscribe();

        //--------------------------------------- elementAt ---------------------------------------------------

        //发射第N项数据
        Observable.just(1, 2, 3, 4, 5, 6).elementAt(1).subscribe();
        //  在elementAtError()的基础上，当出现越界情况(当获取位置的索引>事件序列的长度)，即抛出异常
        Observable.just(1, 2, 3, 4, 5, 6)
                .elementAtOrError(6)
                .subscribe(new BiConsumer<Integer, Throwable>() {
                    @Override
                    public void accept(Integer integer, Throwable throwable) throws Exception {
                        System.out.println(integer);
                    }
                });
        //--------------------------------------- ignoreElements ---------------------------------------------------
        //不管发射的数据.只希望在它完成时和遇到错误时收到通知
        Observable.just(1, 2, 3, 4, 5, 6)
                .ignoreElements()
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("完成");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("出错");
                    }
                });

        //--------------------------------------- ofType ---------------------------------------------------
        //接收某一个类型数据
        Observable.just(1, 2, 3, 4, 5, 6, "ada", "ba")
                .ofType(Integer.class)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                });

        //--------------------------------------- throttleFirst/throttleLast ---------------------------------------------------
        //throttleFirst 取前几秒的第一次事件
        //throttleFirst 取前几秒的最后一次事件
        Observable.intervalRange(1, 5, 0, 1, TimeUnit.SECONDS)
                .throttleFirst(3, TimeUnit.SECONDS)
                .throttleFirst(2, TimeUnit.SECONDS, Schedulers.io())
                .throttleLast(2, TimeUnit.SECONDS)
                .throttleLast(2, TimeUnit.SECONDS, Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                    }
                });

        //---------------------------------------sample----------------------------------

        Observable.interval(3, TimeUnit.SECONDS)
                .sample(2, TimeUnit.SECONDS) //取两秒内最后一次事件 ，和throttleLast类似
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                    }
                });

        //---------------------------------------lastElement/firstElement----------------------------------
        // lastElement 取最后一次事件
        // firstElement 取第一次事件
        Observable.just(1, 2, 3, 4, 5, 6, 7)
//                .lastElement()
//                .firstElement()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                });


    }

    int count = 2;

    public void condition() {

        //--------------------------------------- all ----------------------------------
        //是否所有数据都满足某个条件
        Observable.just(1, 2, 3, 4, 5, 6, 7).all(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer < 10;
            }
        }).subscribe();

        //---------------------------------------   ----------------------------------

        //重复发送指令直到满足某个条件后停止

        Observable.just(1).repeatUntil(new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() throws Exception {
                count++;
                return count > 10;
            }
        }).subscribe();


        //--------------------------------------- takeUntil ----------------------------------
        //不满足这个条件不会停止发送事件
        Observable.just(1, 2, 3, 4, 5, 6).takeUntil(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer == 5;
            }
        }).subscribe();

        //--------------------------------------- takeWhile ----------------------------------
        // 不满足这个条件不会发送事件
        Observable.just(1, 2, 3, 4, 5, 6).takeWhile(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return false;
            }
        }).subscribe();

        //--------------------------------------- skipWhile ----------------------------------

        //跳过满足条件的事件，发送不满足条件的事件
        Observable.just(1, 2, 3, 4, 5, 6).skipWhile(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer > 4;
            }
        }).subscribe();


        //--------------------------------------- sequenceEqual ----------------------------------
        //判断两个事件发送的数据是否相等，第三个参数亦可以通通过判断某个item来判断是否相等
        Observable
                .sequenceEqual(Observable.just(1, 2, 3, 4, 5, 6), Observable.just(1, 2, 3, 4, 5, 6), new BiPredicate<Integer, Integer>() {
                    @Override
                    public boolean test(Integer integer, Integer integer2) throws Exception {
                        return false;
                    }
                })
                .subscribe();

        //--------------------------------------- contains isEmpty ----------------------------------
        //  判断发送的数据是否包含某一项数据

        Observable.just(1, 2, 3, 4, 5, 6)
                .contains(1)
                .subscribe();

        //--------------------------------------- contains isEmpty ----------------------------------
        //发送事件的数据是否为null

        Observable.just(1, 12, 32, "", null).isEmpty().subscribe(new BiConsumer<Boolean, Throwable>() {
            @Override
            public void accept(Boolean aBoolean, Throwable throwable) throws Exception {

            }
        });


        //---------------------------------------   ----------------------------------
        //发送 先发送事件ObservableSource，另外的摒弃掉
        Observable<Integer> just = Observable.just(1, 12, 3);
        Observable<Integer> delay = Observable.just(1, 12, 32).delay(100, TimeUnit.MILLISECONDS);

        List<ObservableSource<Integer>> list = new ArrayList<>();
        list.add(just);
        list.add(delay);
        Observable.amb(list).subscribe();

        //--------------------------------------- defaultIfEmpty ----------------------------------
        //defaultIfEmpty在仅仅发送onComplete时候发送
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onComplete();

            }
        }).defaultIfEmpty(4)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });

    }

}
