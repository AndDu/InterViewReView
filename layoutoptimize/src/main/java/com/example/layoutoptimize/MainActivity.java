package com.example.layoutoptimize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.debug.hv.ViewServer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewServer.get(this).addWindow(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Integer.valueOf(123);
        ViewServer.get(this).setFocusedWindow(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewServer.get(this).removeWindow(this);
    }
}
