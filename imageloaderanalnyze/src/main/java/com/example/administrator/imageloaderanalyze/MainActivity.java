package com.example.administrator.imageloaderanalyze;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.imageloaderanalnyze.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();获取
    }


    public void onClick(View view ){
        ImageLoader.getInstance().displayImage("http://upload.techweb.com.cn/s/640/2018/0307/1520392068979.jpg",
                (ImageView) findViewById(R.id.imageview));
    }
}
