package com.example.administrator.intenrviewtest.asynctask;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.intenrviewtest.R;

import java.util.ArrayDeque;

/**
 * Created by YellowHuang on 2019/3/29.
 */

public class AsyncTaskTestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);
    }

    public void startTest(View view) {

        Test test = new Test();
        test.execute();
    }


    /**
     * AsyncTask并不会和任何组件绑定，所以activity或者fragment被销毁的时候自身并不销毁，
     * 所以ondestory时候要调用销毁
     * 类要设成静态的内部类，非静态内部类会持有外部类的引用，导致无法回收释放。
     *
     * 当Activity重新创建时（屏幕旋转 / Activity被意外销毁时后恢复），
     * 之前运行的AsyncTask（非静态的内部类）持有的之前Activity引用已无效，故复写的onPostExecute()将不生效，即无法更新UI操作
     * 在Activity恢复时的对应方法 重启 任务线程
     *
     */


    class Test extends AsyncTask<String, Integer, Bitmap> {

        int i=0;

        public String getSre(){
            return null;
        }

        @Override
        protected Bitmap doInBackground(String... params) {


            return null;
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

    }

//    /**
//     * 步骤1：创建AsyncTask子类
//     * 注：
//     *   a. 继承AsyncTask类
//     *   b. 为3个泛型参数指定类型；若不使用，可用java.lang.Void类型代替
//     *   c. 根据需求，在AsyncTask子类内实现核心方法
//     */
//
//    private class MyTask extends AsyncTask<Params, Progress, Result> {
//
//        ....
//
//        // 方法1：onPreExecute（）
//        // 作用：执行 线程任务前的操作
//        // 注：根据需求复写
//        @Override
//        protected void onPreExecute() {
//           ...
//        }
//
//        // 方法2：doInBackground（）
//        // 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
//        // 注：必须复写，从而自定义线程任务
//        @Override
//        protected String doInBackground(String... params) {
//
//            ...// 自定义的线程任务
//
//            // 可调用publishProgress（）显示进度, 之后将执行onProgressUpdate（）
//            publishProgress(count);
//
//        }
//
//        // 方法3：onProgressUpdate（）
//        // 作用：在主线程 显示线程任务执行的进度
//        // 注：根据需求复写
//        @Override
//        protected void onProgressUpdate(Integer... progresses) {
//            ...
//
//        }
//
//        // 方法4：onPostExecute（）
//        // 作用：接收线程任务执行结果、将执行结果显示到UI组件
//        // 注：必须复写，从而自定义UI操作
//        @Override
//        protected void onPostExecute(String result) {
//
//         ...// UI操作
//
//        }
//
//        // 方法5：onCancelled()
//        // 作用：将异步任务设置为：取消状态
//        @Override
//        protected void onCancelled() {
//        ...
//        }
//    }
//
//    /**
//     * 步骤2：创建AsyncTask子类的实例对象（即 任务实例）
//     * 注：AsyncTask子类的实例必须在UI线程中创建
//     */
//    MyTask mTask = new MyTask();
//
///**
// * 步骤3：手动调用execute(Params... params) 从而执行异步线程任务
// * 注：
// *    a. 必须在UI线程中调用
// *    b. 同一个AsyncTask实例对象只能执行1次，若执行第2次将会抛出异常
// *    c. 执行任务中，系统会自动调用AsyncTask的一系列方法：onPreExecute() 、doInBackground()、onProgressUpdate() 、onPostExecute()
// *    d. 不能手动调用上述方法
// */
//  mTask.execute()；
}

