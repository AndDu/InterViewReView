package com.example.administrator.intenrviewtest.eventdispatch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2019/3/19.
 */

public class CustomView extends View {

    private Boolean isDispatch;
    private Boolean isTouch;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDispatch(Boolean dispatch) {
        isDispatch = dispatch;
    }

    public void setTouch(Boolean touch) {
        isTouch = touch;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(" CustomView", "dispatchTouchEvent_ACTION_DOWN: ");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("CustomView", "dispatchTouchEvent_ACTION_MOVE: ");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("CustomView", "dispatchTouchEvent_ACTION_UP: ");
                break;
        }
        if (isDispatch == null) {
            return super.dispatchTouchEvent(event);
        } else {
            return isDispatch;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                Log.e("CustomView", "onTouchEvent_ACTION_DOWN: ");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e("CustomView", "onTouchEvent_ACTION_MOVE: ");
                break;

            case MotionEvent.ACTION_UP:
                Log.e("CustomView", "onTouchEvent_ACTION_UP: ");
                break;

        }

        if (isTouch == null) {
            return super.onTouchEvent(event);
        } else {
            return isTouch;
        }

    }

}
