package com.example.administrator.intenrviewtest.match;

import android.os.Bundle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MatchTest {


    /**
     * .  匹配换行符以外的的任何字符
     * \w 匹配字母或数字或下划线或汉字
     * \s 匹配任意的空白符
     * \d 匹配数字
     * \b 匹配字母
     * ^  匹配字符串的开始
     * $  匹配字符串的结束
     */
    public static void main(String p[]) {
        //.  匹配换行符以外的的任何字符
//        String str = "\n";  //false
//        String str = "aa";  //true
//        Pattern compile = Pattern.compile(".");
//        Matcher matcher = compile.matcher(str);
//        System.out.println(matcher.find());
        // --------------------------------------
        //暂时没搞明白
        //\w 匹配字母或数字或下划线或汉字
//        String str = "\n"; //false
//        String str = "中文";
//        Pattern compile = Pattern.compile("\\w");
//        Matcher matcher = compile.matcher(str);
//        System.out.println(matcher.find());
        // --------------------------------------

        //\s 匹配任意的空白符
//        String str = " "; //true
//        String str = "ada"; //false
//        String str = "ada "; //true
//        String str = "a d a"; //true
//        Pattern compile = Pattern.compile("\\s");
//        Matcher matcher = compile.matcher(str);
//        System.out.println(matcher.find());

        //\d 匹配数字  \d{n} 匹配连续n位数字
//        String str = "2345"; //true
//        String str = "ada2dfs"; //false
//        String str = "ada24fs"; //true
//        Pattern compile = Pattern.compile("\\d{2}"); //匹配连续两位数字
//        Matcher matcher = compile.matcher(str);
//        System.out.println(matcher.find() ?"true:------"+ matcher.group() + " index :" + matcher.group(0) : "false");

        //\b 匹配字母 ps:好像只能匹配开始，不能匹配结束
//        String str = "ada24fs"; //true
//        String str = "fsa24ad"; //true
////        Pattern compile = Pattern.compile("\\bad"); //匹配ad开始
//        Pattern compile = Pattern.compile("\\bfs"); //匹配fs开始
//        Matcher matcher = compile.matcher(str);
//        System.out.println(matcher.find() ?"true:------"+ matcher.group() + " index0=" + matcher.group(0) : "false");

        //^  匹配字符串的开始
        //$  匹配字符串的结束
        String str = "fsd"; //true
//        System.out.println(str.matches("^f.d$"));
        Pattern compile = Pattern.compile("^fd$"); //匹配fs开始
        Matcher matcher = compile.matcher(str);
        System.out.println(matcher.find() ?"true:------"+ matcher.group() + " index0=" + matcher.group(0) : "false");


    }

}
