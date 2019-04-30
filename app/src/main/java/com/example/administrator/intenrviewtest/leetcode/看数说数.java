package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by YellowHuang on 2019/4/30.
 */

/**
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 1 is read off as "one 1" or 11.
 * <p>
 * 11 is read off as "two 1s" or 21.
 * <p>
 * 21 is read off as "one 2, then one 1" or 1211.
 */
public class 看数说数 {


//    static void countAndSay(int num) {
//        System.out.println();
//        char[] nums = String.valueOf(num).toCharArray();
//        char a = nums[0];
//        int count = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != a) {
//                System.out.print(count + "" + a);
//                a = nums[i];
//                count = 1;
//            } else {
//                count++;
//            }
//        }
//
//        System.out.print(count + "" + a);
//
//    }


    public static void main(String[] args) {
        int[] nums = {1, 11, 21, 1211, 111221};
        for (int i = 0; i < nums.length; i++) {
            countAndSay(nums[i]);
        }
    }


    public static String countAndSay(int n) {
        String str = "1";
        while (--n > 0) {
            int times = 1;
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            int len = chars.length;
            for (int j = 1; j < len; j++) {
                if (chars[j - 1] == chars[j]) {
                    times++;
                } else {
                    sb.append(times).append(chars[j - 1]);
                    times = 1;
                }
            }
            str = sb.append(times).append(chars[len - 1]).toString();
        }
        System.out.println(str);
        return str;
    }

}
