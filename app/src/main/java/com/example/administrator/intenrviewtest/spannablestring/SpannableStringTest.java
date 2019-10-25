package com.example.administrator.intenrviewtest.spannablestring;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import com.example.administrator.intenrviewtest.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SpannableStringTest extends AppCompatActivity {

    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;

    public static void startActivity(Context context){
        context.startActivity(new Intent(context,SpannableStringTest.class));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spannablestring);
        String str = "红橙黄绿青蓝紫下划线";
        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);
        tv_4 = findViewById(R.id.tv_4);

        SpannableStringBuilder ssb1 = new SpannableStringBuilder(str);
        int a=0;

        /**
         * what ：文本格式，如前景色、下划线、模糊、超链接等，常用几个：
         * ForegroundColorSpan前景色&BackgroundColorSpan背景色
         * RelativeSizeSpan相对大小&AbsoluteSizeSpan绝对大小（单位：像素px）
         * StrikethroughSpan中划线&UnderlineSpan下划线
         * SuperscriptSpan上标&SubscriptSpan下标
         * StyleSpan 可设置粗体new StyleSpan(Typeface.BOLD)、斜体new StyleSpan(Typeface.ITALIC)
         */

        /**
         * flags ：标识start和end是否被包括，符号[和]表示包括，符号(和)表示不包括，四种属性：
         * Spanned.SPAN_INCLUSIVE_EXCLUSIVE：[起始下标,结束下标)
         * Spanned.SPAN_EXCLUSIVE_EXCLUSIVE ：(起始下标,结束下标)
         * Spanned.SPAN_INCLUSIVE_INCLUSIVE ：[起始下标,结束下标]
         * Spanned.SPAN_EXCLUSIVE_INCLUSIVE：(起始下标,结束下标]
         */
        ssb1.setSpan(new ForegroundColorSpan(Color.RED),0,++a, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb1.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFA500")),a,++a, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb1.setSpan(new ForegroundColorSpan(Color.YELLOW),a,++a, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb1.setSpan(new ForegroundColorSpan(Color.GREEN),a,++a, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb1.setSpan(new ForegroundColorSpan(Color.CYAN),a,++a, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb1.setSpan(new ForegroundColorSpan(Color.BLUE),a,++a, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb1.setSpan(new ForegroundColorSpan(Color.parseColor("#FF800080")),a,++a, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb1.setSpan(new UnderlineSpan(),a,str.length(),Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv_1.setText(ssb1);

    }
}
