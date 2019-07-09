package com.example.administrator.intenrviewtest.alrammanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.intenrviewtest.MainActivity;

import java.util.Calendar;

/**
 * Created by YellowHuang on 2019/4/29.
 */

public class AlramManagerTestActivity extends AppCompatActivity {


    private AlarmManager manager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    void startAlramClock() {


        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, MainActivity.class);
        //闹铃的动作
        //在activity处理用getActivity,在广播用getReciver，在服务用getService

        pendingIntent = PendingIntent.getActivity(this, 0x12, intent, 0);

        //通过Calendar来设定某个准确时间相应，这里是设置第二天的凌晨00:00
        Calendar instance = Calendar.getInstance();
//        int hour = instance.get(Calendar.HOUR_OF_DAY);
        int day = instance.get(Calendar.DAY_OF_MONTH);
//        int minute = instance.get(Calendar.MINUTE);

//        Log.e("startAlramClock: ", day + " " + hour + ":" + minute + "---" + instance.getTimeInMillis());
        instance.set(Calendar.DAY_OF_MONTH, day + 1);
//        instance.set(Calendar.DAY_OF_MONTH, day );
        instance.set(Calendar.HOUR_OF_DAY, 00);
        instance.set(Calendar.MINUTE, 00);

        int hour = instance.get(Calendar.HOUR_OF_DAY);
        day = instance.get(Calendar.DAY_OF_MONTH);
        int minute = instance.get(Calendar.MINUTE);
        Log.e("startAlramClock: ", day + " " + hour + ":" + minute + "---" + instance.getTimeInMillis());
        manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, instance.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
//        manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 10 * 1000, 10 * 1000, pendingIntent);

//        取消闹铃的方法
//        manager.cancel(pendingIntent);
    }
}
