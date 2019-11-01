package com.example.administrator.intenrviewtest.designpattern.factory;

/**
 *
 * 面包店： 蒸饺子，蒸面包，蒸米糕，甜甜圈
 */
public class BreadMan {


    public static void main(String[] args){


        IFactory iFactory=null;
        //蒸饺子
        System.out.println("饺子没了");
        iFactory=new 蒸饺子Factory();
        iFactory.createFactory().cook();
        //蒸面包
        System.out.println("面包没了");
        iFactory=new 蒸面包Factory();
        iFactory.createFactory().cook();

    }



}
