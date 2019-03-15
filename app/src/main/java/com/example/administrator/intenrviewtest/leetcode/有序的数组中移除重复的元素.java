package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by Administrator on 2019/3/14.
 * 从一个有序的数组中移除重复的元素，并返回之后数组的长度
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 */

public class 有序的数组中移除重复的元素 {

        public int removeDuplicates(int[] nums) {
            int len = nums.length;
            if (len <= 1) return len;
            int tail = 1;
            for (int i = 1; i < len; ++i) {
                if (nums[i - 1] != nums[i]) {
                    nums[tail++] = nums[i];
                }
            }

//            System.arraycopy();
            return tail;
        }

}
