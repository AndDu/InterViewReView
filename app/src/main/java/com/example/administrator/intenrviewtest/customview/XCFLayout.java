package com.example.administrator.intenrviewtest.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by YellowHuang on 2019/6/21.
 */

public class XCFLayout extends ViewGroup {

    public XCFLayout(Context context) {
        super(context);
    }

    public XCFLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XCFLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);





    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
