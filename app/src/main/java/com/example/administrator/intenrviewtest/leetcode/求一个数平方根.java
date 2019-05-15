package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by YellowHuang on 2019/5/5.
 */

public class 求一个数平方根 {


    public static void main(String[] a) {

        int sqrt = sqrt(9);
        System.out.print(sqrt);
    }

    public static int sqrt(int x) {

        long n = x;
        while (n * n > x) {
            n = (n + x / n) / 2;
        }
        return (int) n;


    }
}
