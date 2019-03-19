package com.example.administrator.intenrviewtest.customview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.intenrviewtest.R;

/**
 * Created by Administrator on 2019/3/18.
 */

public class CustomTestActivity extends AppCompatActivity {


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CustomTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customtest);
    }
}
