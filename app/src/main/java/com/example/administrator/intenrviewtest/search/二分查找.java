package com.example.administrator.intenrviewtest.search;

/**
 * Created by YellowHuang on 2019/5/15.
 */

public class 二分查找 {


    public static void main(String[] a) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};

        System.out.print(getIndex(nums,8));
    }

    public static int getIndex(int[] nums, int target) {
        if (nums == null) return -1;
        int head = 0, end = nums.length ;
        int half = head + end-1 >> 1;
        while (half < end) {
            if (nums[half] == target) return half;
            if (nums[half] > target) {
                end = half;
                half = head + end - 1 >> 1;
            }
            if (nums[half] < target) {
                head = half;
                half = head + 1 + end >> 1;
            }
        }
        return -1;

    }

}
