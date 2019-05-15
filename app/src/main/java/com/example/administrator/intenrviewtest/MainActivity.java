package com.example.administrator.intenrviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.intenrviewtest.customview.CustomTestActivity;
import com.example.administrator.intenrviewtest.eventdispatch.EventTestActivity;
import com.example.administrator.intenrviewtest.notification.NotifiOnClickActivity;
import com.example.administrator.intenrviewtest.notification.NotificationManagerActivity;


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

    public void EventTest(View view) {
        EventTestActivity.startActivity(this);
    }

    public void notification(View view) {
        NotificationManagerActivity.startAcitivty(this);
    }

    void finalTest() {
        byte a = 0x12;
        byte b = 0x13;
        final byte c = 0x14;
        final byte d = 0x14;

        byte e;
        byte f;
        byte g;
        e = (byte) (a + b);  //byte在进行加法运算时会自动转换成int
        f = (byte) (a + c); //同上，虽然c是final修饰的，但是a是以int运算，最后加出来是int
        g = c + d; //final 修饰的类型不会变，所以不用强转回byte


    }


    void charTest(){

        char a = 0x12;
        char b = 0x13;
        final char c = 0x14;
        final char d = 0x14;

        char e;
        char f;
        char g;

        e = (char) (a + b);  //byte在进行加法运算时会自动转换成int
        f = (char) (a + c); //同上，虽然c是final修饰的，但是a是以int运算，最后加出来是int
        g = c + d; //final 修饰的类型不会变，所以不用强转回byte

    }

}
