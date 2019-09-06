package com.example.administrator.intenrviewtest.eventdispatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RadioGroup;

import com.example.administrator.intenrviewtest.R;

/**
 * Created by Administrator on 2019/3/19.
 */

public class EventTestActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    private CustomLinearLayout ll_praent;
    private CustomView v_child;

    private RadioGroup p_r_d;
    private RadioGroup p_r_i;
    private RadioGroup p_r_t;
    private RadioGroup c_r_d;
    private RadioGroup c_r_t;


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, EventTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        p_r_d = findViewById(R.id.p_r_d);
        p_r_i = findViewById(R.id.p_r_i);
        p_r_t = findViewById(R.id.p_r_t);
        c_r_d = findViewById(R.id.c_r_d);
        c_r_t = findViewById(R.id.c_r_t);
        ll_praent = findViewById(R.id.ll_praent);
        v_child = findViewById(R.id.v_child);
        p_r_d.setOnCheckedChangeListener(this);
        p_r_i.setOnCheckedChangeListener(this);
        p_r_t.setOnCheckedChangeListener(this);
        c_r_d.setOnCheckedChangeListener(this);
        c_r_t.setOnCheckedChangeListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        RectF rectF = new RectF();

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

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//        Boolean nullBoolean=null;
        if (group == p_r_d) {
            ll_praent.setDispatch(checkedId == R.id.p_d_1);
            if (R.id.p_d_3==checkedId){
                ll_praent.setDispatch(null);
            }
        } else if (group == p_r_i) {
            ll_praent.setIntercept(checkedId == R.id.p_i_1);
            if (R.id.p_i_3==checkedId){
                ll_praent.setIntercept(null);
            }
        } else if (group == p_r_t) {
            ll_praent.setTouch(checkedId == R.id.p_t_1 );
            if (R.id.p_t_3==checkedId){
                ll_praent.setTouch(null);
            }
        }else if (group==c_r_d){
            v_child.setDispatch(checkedId == R.id.c_d_1);
            if (R.id.c_d_3==checkedId){
                v_child.setDispatch(null);
            }
        }else if (group==c_r_t){
            v_child.setTouch(checkedId == R.id.c_t_1);
            if (R.id.c_t_3==checkedId){
                v_child.setTouch(null);
            }
        }
    }
}
