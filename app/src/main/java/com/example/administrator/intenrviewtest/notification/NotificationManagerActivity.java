package com.example.administrator.intenrviewtest.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.intenrviewtest.R;

/**
 * Created by Administrator on 2019/3/27.
 */

public class NotificationManagerActivity extends AppCompatActivity {

    public static void startAcitivty(Context context) {
        Intent intent = new Intent(context, NotificationManagerActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void sendNotification(View view) {
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//
//        // 设置通知的基本信息：icon、标题、内容
//        builder.setSmallIcon(R.mipmap.ic_launcher);
//        builder.setContentTitle("My notification");
//        builder.setContentText("Hello World!");
//

//
//        // 发送通知 id 需要在应用内唯一
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(0, builder.build());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sendNotifycation();
            }
        }, 3000);

    }


    void sendNotifycation() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            /**
             *  创建通知栏管理工具
             */

            NotificationManager notificationManager = (NotificationManager) getSystemService
                    (NOTIFICATION_SERVICE);

            /**
             *  实例化通知栏构造器
             */

            androidx.appcompat.app.NotificationCompat.Builder mBuilder = new androidx.appcompat.app.NotificationCompat.Builder(this);
            // 设置通知的点击行为：这里启动一个 Activity
            Intent intent = new Intent(this, NotifiOnClickActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            inboxStyle.setBigContentTitle("啦啦啦");
            inboxStyle.setSummaryText("我不素是SummaryText");
            inboxStyle.addLine("aaaaaaaaaa");
            inboxStyle.addLine("bbbbbbbbb");
            /**
             *  设置Builder
             */
            //设置标题
            mBuilder.setContentTitle("幸福e区")
                    //设置内容
                    .setContentText("超出设定的安全范围，请注意！")
                    //设置大图标
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round))
                    //设置小图标
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    //设置通知时间
                    .setWhen(System.currentTimeMillis())
                    //首次进入时显示效果
                    .setTicker("超出设定的安全范围，请注意！")
                    //设置通知方式，声音，震动，呼吸灯等效果，这里通知方式为声音
                    .setDefaults(Notification.DEFAULT_SOUND)
                    .setContentIntent(pendingIntent) // 设置通知的点击行为
                    .setPriority(NotificationCompat.PRIORITY_MAX) //设置通知等级，最大
                    .setStyle(inboxStyle)
                    .setVisibility(Notification.VISIBILITY_PUBLIC) //设置锁屏通知可见性
            ;
            //发送通知请求
//            int id = new Random().nextInt(Integer.MAX_VALUE);
            int id = 2;
            notificationManager.notify(id, mBuilder.build());
        } else {

            Notification.Builder builder = new Notification.Builder(this, "1"); //与channelId对应
            //icon title text必须包含，不然影响桌面图标小红点的展示
            Intent intent = new Intent(this, NotifiOnClickActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Notification.Style inboxStyle = new Notification.BigTextStyle();
            builder.setSmallIcon(android.R.drawable.stat_notify_chat)
                    .setContentTitle("幸福e区")
                    .setContentText("超出设定的安全范围，请注意！")
                    .setContentIntent(pendingIntent)
                    .setStyle(inboxStyle)
                    .setNumber(3); //久按桌面图标时允许的此条通知的数量
            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            // 设置通知的提示音
            builder.setSound(alarmSound);
            NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel("1", "Channel1", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setImportance(notificationManager.IMPORTANCE_MAX);  // 设置通知的优先级
            channel.setSound(alarmSound, channel.getAudioAttributes());//设置声音
            channel.enableLights(true); //是否在桌面icon右上角展示小红点
            channel.setLightColor(Color.RED); //小红点颜色
            channel.setShowBadge(true); //是否在久按桌面图标时显示此渠道的通知
            notificationManager.createNotificationChannel(channel);
            int notificationId = 1;
            notificationManager.notify(notificationId, builder.build());
        }
    }
}
