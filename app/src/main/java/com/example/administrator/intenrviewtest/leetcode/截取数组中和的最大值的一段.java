package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by YellowHuang on 2019/4/30.
 */

public class 截取数组中和的最大值的一段 {


    public static void main(String[] args) {
        int[] nums={-3,1,-3,4,-10,4,1,-3,5};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length, dp = nums[0], max = dp;
        for (int i = 1; i < len; ++i) {
            dp = nums[i] + (dp > 0 ? dp : 0);
            if (dp > max) max = dp;
        }
        return max;
    }
}
