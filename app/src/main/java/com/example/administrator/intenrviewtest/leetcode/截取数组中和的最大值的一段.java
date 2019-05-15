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


    /**
     * 分治思想解决，不理解= =
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = (left + right) >> 1;
        int leftAns = helper(nums, left, mid);
        int rightAns = helper(nums, mid + 1, right);
        int leftMax = nums[mid], rightMax = nums[mid + 1];
        int temp = 0;
        for (int i = mid; i >= left; --i) {
            temp += nums[i];
            if (temp > leftMax) leftMax = temp;
        }
        temp = 0;
        for (int i = mid + 1; i <= right; ++i) {
            temp += nums[i];
            if (temp > rightMax) rightMax = temp;
        }
        return Math.max(Math.max(leftAns, rightAns), leftMax + rightMax);
    }

}
