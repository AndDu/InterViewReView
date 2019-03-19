package com.example.administrator.intenrviewtest.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2019/3/18.
 */

public class MeasureTestView extends View {


    public MeasureTestView(Context context) {
        super(context);
    }

    public MeasureTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        Log.e("onMeasure: widthMode:", getStringByMode(mode));
        Log.e("onMeasure: width:", size + "");
        int mode1 = MeasureSpec.getMode(heightMeasureSpec);
        int size1 = MeasureSpec.getSize(heightMeasureSpec);
        Log.e("onMeasure: heightMode:", getStringByMode(mode1) + "");
        Log.e("onMeasure: height:", size1 + "");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }

    String getStringByMode(int mode) {
        return mode == MeasureSpec.AT_MOST ? "AT_MOST" : mode == MeasureSpec.EXACTLY ? "EXACTLY" : "UNSPECIFIED";
    }
}
