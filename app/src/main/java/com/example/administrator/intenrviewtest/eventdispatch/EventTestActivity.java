package com.example.administrator.intenrviewtest.eventdispatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.example.administrator.intenrviewtest.R;

/**
 * Created by Administrator on 2019/3/19.
 */

public class EventTestActivity extends Activity {



    public static void startActivity(Context context){
        Intent intent = new Intent(context, EventTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(" EventTestActivity", "dispatchHoverEvent_ACTION_DOWN: ");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("EventTestActivity", "dispatchHoverEvent_ACTION_MOVE: ");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("EventTestActivity", "dispatchHoverEvent_ACTION_UP: ");
                break;
        }

        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                Log.e("EventTestActivity", "onTouchEvent_ACTION_DOWN: ");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e("EventTestActivity", "onTouchEvent_ACTION_MOVE: ");
                break;

            case MotionEvent.ACTION_UP:
                Log.e("EventTestActivity", "onTouchEvent_ACTION_UP: ");
                break;

        }

        return super.onTouchEvent(event);

    }
}
