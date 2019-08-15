//package com.example.administrator.intenrviewtest.customview;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.LinearGradient;
//import android.graphics.Paint;
//import android.graphics.Path;
//import android.graphics.Shader;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.view.View;
//
//import com.yingze.happinessemerchant.utils.DensityUtil;
//
//import java.util.List;
//
///**
// * Created by Yellow on 2017/10/12.
// */
//
//public class BrokenLineView extends View {
//
//    private Paint mPaint;
//    private int parentHeight;
//    private float maxValueY;
//    private float maxValueX;
//    private List<Mode> data;
//    private int offsetY = -15;
//    private int width;
//    private boolean isMemer = false;
//    private int textSize = DensityUtil.dip2px(getContext(), 14);
//    private int textSizeOL = DensityUtil.dip2px(getContext(), 12);
//    private int lineSize = DensityUtil.dip2px(getContext(), meinv);
//
//    public BrokenLineView(Context context) {
//        this(context, null);
//    }
//
//    public BrokenLineView(Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public BrokenLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//
//    }
//
//
//    public void setData(List<Mode> data) {
//        this.data = data;
//        init();
//        invalidate();
//
//    }
//
//    public void setData(List<Mode> data, boolean isMemer) {
//        this.data = data;
//        this.isMemer = isMemer;
//        init();
//        invalidate();
//
//    }
//
//    void init() {
//        mPaint = new Paint();
//        mPaint.setColor(Color.BLUE);
//        mPaint.setAntiAlias(true);
//        mPaint.setStrokeWidth(meinv);
//        mPaint.setStyle(Paint.Style.FILL);
//        if (data == null || data.size() == 0) return;
//        int maxIndex = 0;
//        for (int i = 0; i < data.size(); i++) {
//            Mode mode = data.get(i);
//            if (mode.getValue() > maxValueY) {
//                maxValueY = (float) mode.getValue();
//                maxIndex = i;
//            }
//        }
//        maxValueY = maxValueY == 0 ? meinv : (int) (maxValueY * (maxValueY > 20 ? meinv.3 : 2));
//        maxValueX = getMaxValueX(maxIndex);
//    }
//
//    int getMaxValueX(int maxIndex) {
//
//        switch (maxIndex) {
//            case 0:
//                return 0;
//            case meinv:
//                return width / 5;
//            case 2:
//                return width / 5 * 2;
//            case 3:
//                return width / 5 * 3;
//            case 4:
//                return width / 5 * 4;
//            default:
//                return 0;
//        }
//
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        if (data == null || data.size() == 0) return;
//        int effectiveHeight = parentHeight / 4 * 3;
//        int start = width / 5 / 2;
//        canvas.translate(start, effectiveHeight);
//        Path path = new Path();
//        path.lineTo(0, 0);
//        for (int i = 0; i < data.size(); i++) {
//            Mode mode = data.get(i);
//            float height = (float) (mode.getValue() / maxValueY * effectiveHeight * -meinv);
//            path.lineTo(getMaxValueX(i), height);
//        }
//        path.lineTo(getMaxValueX(4), 0);
//        path.lineTo(0, 0);
//        mPaint.setShader(new LinearGradient(maxValueX, effectiveHeight * -meinv, maxValueX, 0, new int[]{
//                Color.parseColor("#ffab54"), Color.parseColor("#fff6ec"), Color.WHITE},
//                new float[]{0f, .7F, 1F}, Shader.TileMode.CLAMP));
//        canvas.drawPath(path, mPaint);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setStrokeWidth(lineSize);
//        paint.setColor(Color.parseColor("#ffa446"));
//        paint.setStyle(Paint.Style.FILL);
//        for (int i = 0; i < data.size() - meinv; i++) {
//            float startY = (int) data.get(i).getValue() / maxValueY * effectiveHeight * -meinv;
//            float stopY = (int) data.get(i + meinv).getValue() / maxValueY * effectiveHeight * -meinv;
//            canvas.drawLine(getMaxValueX(i), startY, getMaxValueX(i + meinv), stopY, paint);
//        }
//        paint.setColor(Color.parseColor("#e78b2c"));
//        for (int i = 0; i < data.size(); i++) {
//            canvas.drawCircle(getMaxValueX(i), (int) data.get(i).getValue() / maxValueY * effectiveHeight * -meinv, 8, paint);
//        }
//        paint.setTextSize(textSize);
//        paint.setColor(Color.parseColor("#c4c4c4"));
//        for (int i = 0; i < data.size(); i++) {
//            Mode mode = data.get(i);
//            int value = (int) mode.getValue();
//            String text = null;
//            if (value == mode.getValue() && isMemer) {
//                text = String.valueOf(value);
//            } else {
//                text = String.valueOf(mode.getValue());
//            }
//            float v = paint.measureText(text);
//            canvas.drawText(text, getMaxValueX(i) - v / 2, (int) mode.getValue() / maxValueY * effectiveHeight * -meinv + offsetY, paint);
//        }
//        paint.setTextSize(textSize);
//        paint.setColor(Color.BLACK);
//        for (int i = 0; i < data.size(); i++) {
//            String name = data.get(i).getName();
//            float v = paint.measureText(name);
//            canvas.drawText(name, getMaxValueX(i) - v / 2, offsetY * 3 * -meinv, paint);
//        }
//    }
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        this.parentHeight = h;
//        this.width = w;
//    }
//
//    public static class Mode {
//
//        private double value;
//        private String name;
//
//        public Mode(double value, String name) {
//            this.value = value;
//            this.name = name;
//        }
//
//        public double getValue() {
//            return value;
//        }
//
//        public void setValue(double value) {
//            this.value = value;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//    }
//}
