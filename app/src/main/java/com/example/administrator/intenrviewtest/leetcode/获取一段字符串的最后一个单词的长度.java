package com.example.administrator.intenrviewtest.leetcode;

/**
 * 这个字符串只包含字母和空格
 * Created by YellowHuang on 2019/5/5.
 */

public class 获取一段字符串的最后一个单词的长度 {


    public static void main(String[] s) {

        int lastWordLengthOfString = getLastWordLengthOfString("helloa world");
        System.out.println(lastWordLengthOfString);

    }


    public static int getLastWordLengthOfString(String str) {


        if (str == null || str.length() == 0) return 0;

        int p = str.length() - 1;
        int end;
        while (p >= 0 && str.charAt(p) != ' ') {
            p--;
        }
        end = p;

        return str.length() - 1 - end;
    }

}
