package com.example.administrator.intenrviewtest.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 已经可以运行
 */
public class CustomView extends View {


    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 数据的前面2个bit用于区分不同的布局模式，后面30个bit存放的是尺寸的数据。
     *
     * @param widthMeasureSpec  包含宽的测量模式和长度
     * @param heightMeasureSpec 包含高的测量模式和长度
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = getSize(widthMeasureSpec, 100);
        int height = getSize(heightMeasureSpec, 100);

        setMeasuredDimension(width,height);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


   public static int getSize(int measureSpec, int defaultSize) {

        int mySize = 0;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                mySize = size;
                break;
            case MeasureSpec.AT_MOST:
                mySize = defaultSize;
                break;
            case MeasureSpec.UNSPECIFIED:

                mySize = defaultSize;

                break;
            default:
                mySize = defaultSize;

                break;
        }


        return mySize;
    }
}
