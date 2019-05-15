package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by YellowHuang on 2019/5/5.
 */

public class 给一个数加一_但是这个数是拆分成数组了 {


    public static void main(String a[]) {
        int[] ints = {9, 9, 8};
        int[] ints1 = plusOne(ints);
        for (int i = 0; i < ints1.length; i++) {
            System.out.print(ints1[i]);
        }

        System.out.println();

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }

    }

    public static int[] plusOne(int[] nums) {

        int i = nums.length - 1;
        if (nums[i] != 9) {
            nums[i] = ++nums[i];
        } else {

            do {
                nums[i--] = 0;
            } while (i >= 0 && nums[i] == 9);

            if (i < 0) {
                nums = new int[nums.length + 1];
                nums[0] = 1;
            } else {
                nums[i] = ++nums[i];
            }

        }

        return nums;

    }


}
