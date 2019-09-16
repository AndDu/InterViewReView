package com.example.administrator.intenrviewtest;

public class WeiYiCalcu {




    public static void main(String[] atgs) {

        int a = -11;
        System.out.println(Integer.toBinaryString(a));
        a = (-11 >> 2);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a);
        a = (-11 >>> 2);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a);

        a = 11;
        System.out.println(Integer.toBinaryString(a));
        a = 11 >> 2;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a);

//        a = -11 << 2;
//        System.out.println(a);
    }
}
