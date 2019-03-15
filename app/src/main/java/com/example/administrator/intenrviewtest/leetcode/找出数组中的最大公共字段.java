package com.example.administrator.intenrviewtest.leetcode;

/**
 * Created by Administrator on 2019/3/14.
 * str[] ={ "fllw","fl","flwew"};
 */

public class 找出数组中的最大公共字段 {

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        int minLen = 0x7fffffff;
        for (String str : strs) minLen = Math.min(minLen, str.length());
        for (int j = 0; j < minLen; ++j)
            for (int i = 1; i < len; ++i)
                if (strs[0].charAt(j) != strs[i].charAt(j))
                    return strs[0].substring(0, j);
        return strs[0].substring(0, minLen);
    }
}
