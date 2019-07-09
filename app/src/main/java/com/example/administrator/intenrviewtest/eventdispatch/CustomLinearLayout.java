package com.example.administrator.intenrviewtest.eventdispatch;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2019/3/19.
 */

public class CustomLinearLayout extends LinearLayout {


    private Boolean isDispatch;
    private Boolean isTouch;
    private Boolean isIntercept;

    public void setDispatch(Boolean dispatch) {
        isDispatch = dispatch;
    }

    public void setTouch(Boolean touch) {
        isTouch = touch;
    }

    public void setIntercept(Boolean intercept) {
        isIntercept = intercept;
    }

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
        if (isDispatch == null) {
            return super.dispatchTouchEvent(ev);
        } else {
            return isDispatch;
        }
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

        if (isIntercept == null) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return isIntercept;
        }





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

        if (isTouch == null) {
            return super.onTouchEvent(event);
        } else {
            return isTouch;
        }


    }
}

