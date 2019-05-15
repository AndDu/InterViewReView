package com.example.administrator.intenrviewtest.sort;

/**
 * Created by YellowHuang on 2019/5/15.
 */

public class 冒泡排序 {


    public static void main(String[] a) {
        int[] nums1 = new int[4];
        nums1[0] = nums1[2];
        nums1[2] = 3;
        int[] nums = {4, 2, 4, 1, 2, 89, 7, 8, 5, 45, 6, 4, 31, 7, 8, 74, 6};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }


    public static void sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp;
                if (nums[j] < nums[i]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

        }

    }


}
