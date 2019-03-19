package com.example.administrator.intenrviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.intenrviewtest.customview.CustomTestActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
//        SchemeTestActivity.startActivity(this);
//        SchemeTestActivity.startActivity(this, "type=string&str=1&str2=1,1,2");
        AnimationTestActivity.startActivity(this);
    }
    public void customView(View view) {
        CustomTestActivity.startActivity(this);
    }
}
