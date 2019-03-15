package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by Administrator on 2019/3/14.
 * 给定一个32位的无符号整数，反转 321 ->123 -321 ->-123
 */

public class 反转整数 {

    public int reverse(int x) {
        long res = 0;
        for (; x != 0; x /= 10)
            res = res * 10 + x % 10;
        //如果反转之后大过整数的最大值，则返回0
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }


}
