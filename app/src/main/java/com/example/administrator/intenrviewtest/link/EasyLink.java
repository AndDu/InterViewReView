package com.example.administrator.intenrviewtest.link;

/**
 * Created by YellowHuang on 2019/4/16.
 */

public class EasyLink<T> {

    private EasyLink<T> before;
    private T data;
    private EasyLink<T> next;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public EasyLink<T> getNext() {
        return next;
    }

    public void setNext(EasyLink<T> next) {
        this.next = next;
    }


    public static void main(String[] args) {
        EasyLink<Integer> header = new EasyLink<>();
        EasyLink<Integer> second = new EasyLink<>();
        EasyLink<Integer> three = new EasyLink<>();

        header.setNext(second);
        second.setNext(three);
    }
}
