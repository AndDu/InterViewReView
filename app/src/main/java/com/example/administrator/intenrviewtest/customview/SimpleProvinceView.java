package com.example.administrator.intenrviewtest.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by YellowHuang on 2019/8/21.
 */

public class SimpleProvinceView extends ViewGroup {

    public SimpleProvinceView(Context context) {
        super(context);
    }

    public SimpleProvinceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleProvinceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //空件高度
        int totalHeight = 0;
        int totalWidth = 0;
        //我在布局写死width 为MATCH_PARENT，所以直接拿宽度，不用去管了，不想写判断模式了
        //，高度的话累计高度来
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int childCount = getChildCount();
        Log.e("childCount: ", childCount + "");
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            int measuredWidth = childAt.getMeasuredWidth();
            //我传入的高度都是一样的，所以不判断最大高度就进行累加
            int measuredHeight = childAt.getMeasuredHeight();
            Log.e("measuredHeight: ", measuredHeight + "");
            //第一行不论填没填满都会有一个高度
            if (totalHeight == 0) {
                totalHeight += measuredHeight + paddingTop;
            }
            if ((totalWidth += measuredWidth) <= size - paddingLeft) {
                continue;
            } else {
                totalWidth = measuredWidth;
                totalHeight += measuredHeight;
            }
        }

        Log.e("totalHeight: ", totalHeight + "");
        width = size - paddingLeft;
        setMeasuredDimension(size, totalHeight);

    }

//暂时用不到
//    int getSize(int measureSpec, int measureSize) {
//
//        int mySize = 0;
//
//        int mode = MeasureSpec.getMode(measureSpec);
//        int size = MeasureSpec.getSize(measureSpec);
//        switch (mode) {
//            case MeasureSpec.EXACTLY:
//                mySize = size;
//                break;
//            case MeasureSpec.AT_MOST:
//                mySize = measureSize;
//                break;
//            case MeasureSpec.UNSPECIFIED:
//
//                mySize = measureSize;
//
//                break;
//            default:
//                mySize = measureSize;
//
//                break;
//        }
//
//
//        return mySize;
//    }


    private int width;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int left = paddingLeft;
        int top = paddingTop;
        int bottom = paddingTop;
        int totalWidth = 0;

        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int childWidth = childAt.getMeasuredWidth();
            int childheight = childAt.getMeasuredHeight();
            totalWidth += childWidth;

            if (totalWidth > width) {
                totalWidth = childWidth;
                left = paddingLeft;
                top += childheight;
                bottom += childheight;
            }
            childAt.layout(left, top, left + childWidth, bottom + childheight);
            left += childWidth;
        }
    }
}
