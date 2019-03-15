package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by Administrator on 2019/3/14.
 * <p>
 * 121 = 121 ;-121 !=121-
 */

public class 回文_反转整数后是否相等 {


    /**
     * 翻转对比
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int copyX = x, reverse = 0;
        while (copyX > 0) {
            reverse = reverse * 10 + copyX % 10;
            copyX /= 10;
        }
        return x == reverse;
    }

    /**
     * 只对比一半
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int halfReverseX = 0;
        while (x > halfReverseX) {
            halfReverseX = halfReverseX * 10 + x % 10;
            x /= 10;
        }
        return halfReverseX == x || halfReverseX / 10 == x;
    }


}
