package com.example.administrator.intenrviewtest.leetcode;

import android.util.Log;

/**
 * Created by Administrator on 2019/3/14.
 * ()[]{} true ，{[()]} true ,[)} false
 */

public class 括号匹配 {


    public static void main(String[] a) {
        boolean valid = isValid("{[()]{}}");
        System.out.print(valid);
    }

    public static boolean isValid(String s) {
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }


}
