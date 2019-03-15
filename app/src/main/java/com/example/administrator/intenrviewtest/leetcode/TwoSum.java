package com.example.administrator.intenrviewtest.leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/3/14.
 * 给定一个数组，和一个值，求这个值是由数组中哪两个数之和的下标
 */


public class TwoSum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }


    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
