package com.example.administrator.intenrviewtest.application;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/**
 * Created by YellowHuang on 2019/4/18.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //Android系统的入口是Application类的 onCreate（），默认为空实现

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        //通知 应用程序 当前内存使用情况（以内存级别进行识别）
        //  应用场景：根据当前内存使用情况进行自身的内存资源的不同程度释放，以避免被系统直接杀掉 & 优化应用程序的性能体验

//        系统在内存不足时会按照LRU Cache中从低到高杀死进程；优先杀死占用内存较高的应用
//                若应用占用内存较小 = 被杀死几率降低，从而快速启动（即热启动 = 启动速度快）
//        可回收的资源包括：
//        a. 缓存，如文件缓存，图片缓存
//        b. 动态生成 & 添加的View

        switch (level) {
            // 80   后台进程
            // 当前手机目前内存吃紧 （后台进程数量少），系统开始根据LRU缓存来清理进程，而该程序位于LRU缓存列表的最边缘位置，系统会先杀掉该进程，应尽释放一切可以释放的内存。
            // 官方文档：the process is nearing the end of the background LRU list, and if more memory isn't found soon it will be killed.
            case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:
                break;
            // 60   后台进程
            //当前手机目前内存吃紧（后台进程数量少），系统开始根据LRU缓存来清理进程，而该程序位于LRU缓存列表的中间位置，应该多释放一些内存提高运行效率。
            // 官方文档：the process is around the middle of the background LRU list; freeing memory can help the system keep other processes running later in the list for better overall performance.
            case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
                break;
            // 40   后台进程
            // 当前手机目前内存吃紧（后台进程数量少），系统开始根据LRU缓存来清理进程，而该程序位于LRU缓存列表的头部位置，不太可能被清理掉的，但释放掉一些比较容易恢复的资源能够提高手机运行效率，同时也能保证恢复速度。
            // 官方文档：the process has gone on to the LRU list. This is a good opportunity to clean up resources that can efficiently and quickly be re-built if the user returns to the app
            case ComponentCallbacks2.TRIM_MEMORY_BACKGROUND:
                break;
            // 20   后台进程
            // 当前应用程序的所有UI界面不可见，一般是用户点击了Home键或者Back键，导致应用的UI界面不可见，这时应该释放一些UI相关资源，TRIM_MEMORY_UI_HIDDEN是使用频率最高的裁剪等级。
            // 官方文档：the process had been showing a user interface, and is no longer doing so. Large allocations with the UI should be released at this point to allow memory to be better managed
            case ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN:
                break;
            // 15   前台RUNNING进程
            // 表示该进程是前台或可见进程，但是目前手机比较内存十分吃紧（后台及空进程基本被全干掉了），这时应当尽可能地去释放任何不必要的资源，否则，系统可能会杀掉所有缓存中的进程，并且杀一些本来应当保持运行的进程。
            // 官方文档：the process is not an expendable background process, but the device is running extremely low on memory and is about to not be able to keep any background processes running. Your running process should free up as many non-critical resources as it can to allow that memory to be used elsewhere. The next thing that will happen after this is called to report that nothing at all can be kept in the background, a situation that can start to notably impact the user.
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL:
                break;
            // 10   前台RUNNING进程
            // 表示该进程是前台或可见进程，正常运行，一般不会被杀掉，但是目前手机比较吃紧（后台及空进程被全干掉了一大波），应该去释放掉一些不必要的资源以提升系统性能。
            // 官方文档：the process is not an expendable background process, but the device is running low on memory. Your running process should free up unneeded resources to allow that memory to be used elsewhere.
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW:
                break;
            // 5    前台RUNNING进程
            // TRIM_MEMORY_RUNNING_MODERATE 表示该进程是前台或可见进程，正常运行，一般不会被杀掉，但是目前手机有些吃紧（后台及空进程存量不多），系统已经开始清理内存，有必要的话，可以释放一些内存。
            // 官方文档：the process is not an expendable background process, but the device is running moderately low on memory. Your running process may want to release some unneeded resources for use elsewhere。
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE:
                break;
        }


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
    }

    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        super.unregisterComponentCallbacks(callback);
    }

    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }

    @Override
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.unregisterActivityLifecycleCallbacks(callback);
    }


}
