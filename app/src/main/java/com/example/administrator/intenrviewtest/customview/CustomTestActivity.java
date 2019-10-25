package com.example.administrator.intenrviewtest.customview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.administrator.intenrviewtest.R;

/**
 * Created by Administrator on 2019/3/18.
 */

public class CustomTestActivity extends AppCompatActivity {


    private SimpleProvinceView simpleprovince;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CustomTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customtest);
        simpleprovince = findViewById(R.id.simpleprovince);
        int densityDpi = (int) (getResources().getDisplayMetrics().density * 4 + 0.5);

        //通过看View的时间分发源码看到的
//        Rect outRect = new Rect();
//        //获取子View的位置范围
//        simpleprovince.getHitRect(outRect);
//        //判断点(x,y)有没有落在某个范围内
//        outRect.contains(x,y)

        int widthPixels = (getResources().getDisplayMetrics().widthPixels - densityDpi);
        int width = widthPixels / 9 - 1;
        int height = width;
        String[] str = {"京", "沪", "浙", "苏", "粤", "鲁", "晋", "冀", "豫", "川", "渝", "辽", "吉", "黑", "皖",
                "鄂", "津", "贵", "云", "桂", "琼", "青", "新", "藏", "蒙", "宁", "甘", "陕", "闽", "赣", "湘", " ", "清空", "关闭"};
        for (int i = 0; i < str.length; i++) {
            TextView view = (TextView) LayoutInflater.from(this).inflate(R.layout.item_textview, simpleprovince, false);

            if (i < str.length - 3) {
                ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(width, height);
                view.setLayoutParams(lp);
                view.setBackgroundResource(R.drawable.bg_white);
            } else if (i == str.length - 3) {
                ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(width, height);
                view.setLayoutParams(lp);
                view.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
            } else if (i == str.length - 1) {
                ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(width * 2, height);
                view.setLayoutParams(lp);
                view.setBackgroundResource(R.drawable.bg_gray);
            } else if (i == str.length - 2) {
                ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(width * 2, height);
                view.setLayoutParams(lp);
                view.setBackgroundResource(R.drawable.bg_big_white);
            }
            view.setText(str[i]);
            simpleprovince.addView(view);
        }

    }
}
