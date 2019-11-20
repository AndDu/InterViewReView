package com.example.administrator.intenrviewtest.rxfamily.rxlifecycle;

import android.os.Bundle;

import com.example.administrator.intenrviewtest.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 插入过多，耦合度太大
 * 放弃~
 */
public class RxLifecycle extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
