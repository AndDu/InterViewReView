package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by Administrator on 2019/3/14.
 * 移除数组中值等于 val 的元素，并返回之后数组的长度
 */


public class 移除数组中值等于val的元素 {

    public int removeElement(int[] nums, int val) {
        int tail = 0;
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (nums[i] != val) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }
}
