package com.example.administrator.intenrviewtest.eventdispatch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2019/3/19.
 */

public class CustomLinearLayout extends LinearLayout {

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(" CustomLinearLaoyout", "dispatchHoverEvent_ACTION_DOWN: ");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("CustomLinearLaoyout", "dispatchHoverEvent_ACTION_MOVE: ");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("CustomLinearLaoyout", "dispatchHoverEvent_ACTION_UP: ");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:
                Log.e("CustomLinearLaoyout", "onInterceptTouchEvent_ACTION_DOWN: " );
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e("CustomLinearLaoyout", "onInterceptTouchEvent_ACTION_MOVE: " );
                break;

            case MotionEvent.ACTION_UP:
                Log.e("CustomLinearLaoyout", "onInterceptTouchEvent_ACTION_UP: " );
                break;

        }

        return super.onInterceptTouchEvent(ev);



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                Log.e("CustomLinearLaoyout", "onTouchEvent_ACTION_DOWN: " );
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e("CustomLinearLaoyout", "onTouchEvent_ACTION_MOVE: " );
                break;

            case MotionEvent.ACTION_UP:
                Log.e("CustomLinearLaoyout", "onTouchEvent_ACTION_UP: " );
                break;

        }

        return super.onTouchEvent(event);

    }
}

