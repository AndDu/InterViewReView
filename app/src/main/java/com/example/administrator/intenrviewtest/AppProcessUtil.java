package com.example.administrator.intenrviewtest;

import android.app.ActivityManager;

import android.content.Context;




import java.util.List;

public class AppProcessUtil {

    /**
     * 当前APP是否在处于前台状态。
     */
    public static boolean isAppOnTaskTop(Context context) {
        //获取系统服务
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        //获取系统正在运行的进程
        List<ActivityManager.RunningAppProcessInfo> processInfo = activityManager.getRunningAppProcesses();
        if (processInfo.size() == 0) return false;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : processInfo) {
            //判断这个进程是否在前台显示
            if (runningAppProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                //这个处于前台的进程是否是我们的进程
                return runningAppProcessInfo.processName.equals(BuildConfig.APPLICATION_ID);
            }
        }
        return false;
    }


    /**
     * 将进程切换到前台
     */
    public static void turnToTaskTop(Context context) {
        //获取系统服务
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(100);
//        for (ActivityManager.RunningTaskInfo runningTask : runningTasks) {
//            ComponentName topActivity = runningTask.topActivity;
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                activityManager.moveTaskToFront(runningTask.taskId,ActivityManager.MOVE_TASK_NO_USER_ACTION);
//            }
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                if (runningTask.topActivity.equals(context.getPackageName())){
//
//                }
//            }
//        }
    }

//     if (!AllUtils.isRunningForeground(this)) {
//        //获取ActivityManager
//        ActivityManager mAm = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//        //获得当前运行的task
//        List<ActivityManager.RunningTaskInfo> taskList = mAm.getRunningTasks(100);
//        for (ActivityManager.RunningTaskInfo rti : taskList) {
//            //找到当前应用的task，并启动task的栈顶activity，达到程序切换到前台
//            if (rti.topActivity.getPackageName().equals(getPackageName())) {
//                mAm.moveTaskToFront(rti.id, 0);
//                return;
//            }
//        }
//        //若没有找到运行的task，用户结束了task或被系统释放，则重新启动mainactivity
//        Intent resultIntent = new Intent(MainActivity.this, MainActivity.class);
//        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        startActivity(resultIntent);
//    }
}
