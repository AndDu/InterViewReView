package com.example.administrator.intenrviewtest.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CustomViewGroup2 extends ViewGroup {

    private int totalHeight = 0;
    private int maxWidth = 0;

    public CustomViewGroup2(Context context) {
        super(context);
    }

    public CustomViewGroup2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.measure(widthMeasureSpec, heightMeasureSpec);
            int measuredHeight = childAt.getMeasuredHeight();
            MarginLayoutParams lp = (MarginLayoutParams) childAt.getLayoutParams();
            totalHeight += measuredHeight + lp.topMargin + lp.bottomMargin;
            maxWidth = Math.max(childAt.getMeasuredWidth() + lp.leftMargin + lp.rightMargin, maxWidth);
        }

        //totalHeight是测量得到的高度，maxWidth是测量得到的宽度
        //接下来是要根据xml文件设置的实际的高度
        int width = getSize(widthMeasureSpec, maxWidth);
        int height = getSize(heightMeasureSpec, totalHeight);

        setMeasuredDimension(width, height);

    }

    static int getSize(int measureSpec, int measureSize) {

        int mySize = 0;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                mySize = size;
                break;
            case MeasureSpec.AT_MOST:
                mySize = measureSize;
                break;
            case MeasureSpec.UNSPECIFIED:

                mySize = measureSize;

                break;
            default:
                mySize = measureSize;

                break;
        }


        return mySize;
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int left = l;
        int right = r;
        int top = t;
        int bottom = b;

        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            MarginLayoutParams lp = (MarginLayoutParams) childAt.getLayoutParams();

            childAt.layout(lp.leftMargin + left, top + lp.topMargin, right + measuredWidth, b + measuredHeight + lp.topMargin);

            top = top + lp.topMargin + lp.bottomMargin +measuredHeight;
            left = left;
            right = right;
            b = bottom + measuredHeight + lp.topMargin + lp.bottomMargin;

        }
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }
}
