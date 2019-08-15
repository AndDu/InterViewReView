package com.example.administrator.intenrviewtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.demo.viewpager.ViewPagerTestActivity;
import com.example.administrator.intenrviewtest.customview.CustomTestActivity;
import com.example.administrator.intenrviewtest.databinding.DataBindTestActivity;
import com.example.administrator.intenrviewtest.eventdispatch.EventTestActivity;
import com.example.administrator.intenrviewtest.notification.NotificationManagerActivity;


public class MainActivity extends AppCompatActivity {

    private TestBrocastReciver testBrocastReciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testBrocastReciver = new TestBrocastReciver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("test");
        registerReceiver(testBrocastReciver, filter);
    }

    public void onClick(View view) {
//        SchemeTestActivity.startActivity(this);
//        SchemeTestActivity.startActivity(this, "type=string&str=meinv&str2=meinv,meinv,2");
        AnimationTestActivity.startActivity(this);
    }


    public void customView(View view) {
        CustomTestActivity.startActivity(this);
    }

    public void databinding(View view) {
        DataBindTestActivity.startActivity(this);
    }

    public void EventTest(View view) {
        EventTestActivity.startActivity(this);
    }

    public void ViewPager(View view) {
        ViewPagerTestActivity.startActivity(this);
    }

    public void notification(View view) {
        NotificationManagerActivity.startAcitivty(this);
    }

    public void sendNotificationInThread(View view) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
        Intent intent = new Intent(MainActivity.this, TestBrocastReciver.class);
        intent.setAction("test");
        sendBroadcast(intent);
//                }
//            }
//        }).start();
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

    void charTest() {

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

    static class TestBrocastReciver extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {
            Thread thread = Thread.currentThread();
            Log.e("onReceive: ", intent.getAction() + ":  ---" + thread.getName());
        }

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(testBrocastReciver);
        super.onDestroy();

    }
}
