package com.yingze.glideanalnyze;


import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_ = findViewById(R.id.iv_);
        Glide.with(this).load("http://upload.techweb.com.cn/s/640/2018/0307/1520392068979.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(iv_);
    }
}
