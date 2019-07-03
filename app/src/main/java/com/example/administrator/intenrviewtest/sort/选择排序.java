package com.example.administrator.intenrviewtest.sort;

/**
 * Created by YellowHuang on 2019/6/26.
 */

public class 选择排序 {

    /**
     * 时间复杂度：O(log2^n)
     *
     * @param a
     */
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
            int index = i;
            int temp = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < temp) {
                    index = j;
                    temp = nums[j];
                }
            }
            if (index != i) {
                nums[index] = nums[i];
                nums[i] = temp;

            }

        }

    }

}
