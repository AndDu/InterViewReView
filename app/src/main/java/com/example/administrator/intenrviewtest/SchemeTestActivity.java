package com.example.administrator.intenrviewtest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13.
 * /**
 * 跳转格式  [scheme]://[host]/[path]?[query]
 */

public class SchemeTestActivity extends AppCompatActivity {

    public static void startActivity(Context con) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s://%s:%s/%s", "yc", "ycbjie", "8888", "from")));
        con.startActivity(intent);
    }

    /**
     * 带值跳转
     *
     * @param con
     */

    public static void startActivity(Context con, String data) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s://%s:%s/%s?%s", "yc", "ycbjie", "8888", "from", data)));
        con.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);
        String type = getIntent().getData().getQueryParameter("type");
        List<String> str2 = getIntent().getData().getQueryParameters("str2");
        Log.e("onCreate: ", type);
    }
}
