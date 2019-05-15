package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by YellowHuang on 2019/5/5.
 */
public class 两个二进制字符串相加 {


    public static void main(String a[]) {

        String s = binaryStrAdd("1111", "1111");
        System.out.print(s);
    }

    /**
     * 还有一种方法，用char转int(char-'0')来也行
     * @param str1
     * @param str2
     * @return
     */
    public static String binaryStrAdd(String str1, String str2) {

        Long aLong1 = Long.valueOf(str1);
        Long aLong2 = Long.valueOf(str2);
        int ins = 0;
        String str = "";
        while (aLong1 > 0 || aLong2 > 0) {
            long l1 = aLong1 > 0 ? aLong1 % 10 : 0;
            long l2 = aLong2 > 0 ? aLong2 % 10 : 0;
            long temp = l1 + l2 + ins;
            if (temp >= 2) {
                ins = 1;
                temp = temp % 2;
            } else {
                ins = 0;
            }
            str = temp + str;
            aLong1 /= 10;
            aLong2 /= 10;
        }
        return ins == 0 ? str : ins + str;
    }
}
