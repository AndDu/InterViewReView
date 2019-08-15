//package com.example.administrator.intenrviewtest.customview;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Path;
//import android.graphics.PointF;
//import android.graphics.Rect;
//import android.graphics.RectF;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//
//import com.yingze.happinessecommunity.mode.healthcare.HealthChangeMode;
//import com.yingze.happinessecommunity.utils.DensityUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by YellowHuang on 2018/4/20.
// */
//
//public class BrokenLineView extends View {
//
//    private static final double RATE = 0.30d;
//    private static final int STROKEWIDTH = 2;
//
//    private Paint mPaint;
//    private final Context context;
//    private final String mMaxX = "2017-04-20";
//    private static final int RECTOFFSET = 10;
//    private static final int TEXTPADDING = 20;
//    private int mMaxY = 250;
//    private int height;
//    private int width;
//    private static final int STARTPADDING = 10;
//    private static final int HORTEXTPADDINGLINE = 10;
//    private List<List<HealthChangeMode>> lists = new ArrayList<>();
//    private final List<List<PointF>> pointFList = new ArrayList<>();
//    private final List<List<PointF>> pointFControllList = new ArrayList<>();
//    private int[] colors = {Color.parseColor("#fffe841e"), getResources().getColor(android.R.color.holo_blue_light)};
//    private static final int TEXT_COLOR = Color.parseColor("#ff858585");
//    private Canvas mCanvas;
//    private int[] whY;
//    private int[] whX;
//    private float getX;
//    private boolean isOnTouch = false;
//
//    public void setColors(int[] colors) {
//        this.colors = colors;
//    }
//
//    public void setDate(List<List<HealthChangeMode>> modeList) {
//        lists = modeList;
//        invalidate();
//    }
//
//    public BrokenLineView(Context context) {
//        this(context, null);
//    }
//
//    public BrokenLineView(Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//
//    public void setmMaxY(int mMaxY) {
//        this.mMaxY = mMaxY;
//    }
//
//    public BrokenLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        this.context = context;
//        initPaint();
//    }
//
//
//    private void initPaint() {
//        mPaint = new Paint();
//        mPaint.setAntiAlias(true);
//        mPaint.setStrokeWidth(STROKEWIDTH);
//        mPaint.setTextSize(DensityUtil.dip2px(context, 12));
//        mPaint.setColor(TEXT_COLOR);
//
//    }
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        this.height = h;
//        this.width = w;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.translate(0, height);
//        this.mCanvas = canvas;
//        mPaint.setColor(TEXT_COLOR);
//        mPaint.setStyle(Paint.Style.FILL);
//        whY = getTextWidthAndHeight(String.valueOf(mMaxY));
//        if (lists.size() != 0 && lists.get(0).size() != 0) {
//            whX = getTextWidthAndHeight(lists.get(0).get(0).getCheckDate());
//        } else {
//            whX = getTextWidthAndHeight(mMaxX);
//        }
//
////        canvas.drawCircle(0, 0, 10, mPaint);
//        drawVerText(canvas, whX, whY);
//        drawHorText(canvas, whX, whY);
//        drawHorLine(canvas, whX, whY); //画水平线
//        caculatePoint(canvas, whX, whY);
//        getControllList();
//        drawPoint(canvas);
//        drawVerLineAndRect(canvas);
//
//
//    }
//
//    void drawVerLineAndRect(Canvas canvas) {
//        if (isOnTouch) {
//            mCanvas.drawLine(getX, (whY[meinv] + whX[meinv] + HORTEXTPADDINGLINE + whY[meinv] / 2) * -meinv, getX, -height + whY[meinv] / 2, mPaint);
//            for (int i = 0; i < pointFList.size(); i++) {
//                mPaint.setColor(colors[i % 2]);
//                List<PointF> pointFs = pointFList.get(i);
//                for (int j = 0; j < pointFs.size(); j++) {
//                    PointF pointF = pointFs.get(j);
//                    if (Math.abs(getX - pointF.x) < 8) {
//                        mPaint.setStyle(Paint.Style.FILL);
//                        canvas.drawCircle(pointF.x, pointF.y, 10, mPaint);
//                        mPaint.setColor(Color.parseColor("#ffffffff"));
//                        canvas.drawCircle(pointF.x, pointF.y, 5, mPaint);
//                        mPaint.setColor(colors[i % 2]);
//                        HealthChangeMode healthChangeMode = lists.get(i).get(pointFs.size() == meinv ? j : j - meinv);
//                        String readNum = healthChangeMode.getReadNum();
//                        int[] textWidthAndHeight = getTextWidthAndHeight(readNum);
//                        if (i % 2 != 0) {
//                            RectF rect = new RectF((int) (pointF.x + RECTOFFSET), (int) (pointF.y - RECTOFFSET - textWidthAndHeight[meinv] - TEXTPADDING),
//                                    (int) (pointF.x + RECTOFFSET + TEXTPADDING + textWidthAndHeight[0]), (int) (pointF.y - RECTOFFSET));
//                            RectF rect1 = new RectF((int) (pointF.x + RECTOFFSET), (int) (pointF.y - RECTOFFSET - textWidthAndHeight[meinv] - TEXTPADDING),
//                                    (int) (pointF.x + RECTOFFSET + TEXTPADDING + textWidthAndHeight[0]), (int) (pointF.y - RECTOFFSET));
//                            mPaint.setColor(Color.parseColor("#ffffffff"));
//                            mPaint.setStyle(Paint.Style.FILL);
//                            canvas.drawRoundRect(rect1, 10, 10, mPaint);
//                            mPaint.setColor(colors[i % 2]);
//                            mPaint.setStyle(Paint.Style.STROKE);
//                            canvas.drawRoundRect(rect, 10, 10, mPaint);
//                            mPaint.setStyle(Paint.Style.FILL);
//                            canvas.drawText(readNum, pointF.x + RECTOFFSET + TEXTPADDING / 2, pointF.y - RECTOFFSET - TEXTPADDING / 2, mPaint);
//                        } else {
//                            RectF rect = new RectF((int) (pointF.x - RECTOFFSET - textWidthAndHeight[0] - TEXTPADDING), (int) (pointF.y - RECTOFFSET - textWidthAndHeight[meinv] - TEXTPADDING),
//                                    (int) (pointF.x - RECTOFFSET), (int) (pointF.y - RECTOFFSET));
//                            RectF rect1 = new RectF((int) (pointF.x - RECTOFFSET - textWidthAndHeight[0] - TEXTPADDING), (int) (pointF.y - RECTOFFSET - textWidthAndHeight[meinv] - TEXTPADDING),
//                                    (int) (pointF.x - RECTOFFSET), (int) (pointF.y - RECTOFFSET));
//                            mPaint.setColor(Color.parseColor("#ffffffff"));
//                            mPaint.setStyle(Paint.Style.FILL);
//                            canvas.drawRoundRect(rect1, 10, 10, mPaint);
//                            mPaint.setColor(colors[i % 2]);
//                            mPaint.setStyle(Paint.Style.STROKE);
//                            canvas.drawRoundRect(rect, 10, 10, mPaint);
//                            mPaint.setStyle(Paint.Style.FILL);
//                            canvas.drawText(readNum, pointF.x - RECTOFFSET - textWidthAndHeight[0] - TEXTPADDING / 2, pointF.y - RECTOFFSET - TEXTPADDING / 2, mPaint);
//                        }
//                    }
//                }
//
//            }
//        }
//    }
//
//
//    private void drawPoint(Canvas canvas) {
//        if (pointFControllList == null || pointFControllList.size() == 0) return;
//        Path path = new Path();
//        for (int j = 0; j < pointFControllList.size(); j++) {
//            List<PointF> list = pointFControllList.get(j);
//            mPaint.setColor(colors[j % 2]);
//            for (int i = 0; i < list.size(); i += 3) {
//                PointF pointF = list.get(i);
////                if (i == 0 || i == list.size() + 3 - meinv) {
////                    canvas.drawCircle(pointF.x, pointF.y, 5, mPaint);
////                }
//                canvas.drawCircle(pointF.x, pointF.y, 5, mPaint);
//                path.reset();
//                path.moveTo(pointF.x, pointF.y);
//                if (i + 3 > list.size()) break;
//                PointF pointF1 = list.get(i + meinv);
//                PointF pointF2 = list.get(i + 2);
//                PointF pointF3 = list.get(i + 3);
//                path.cubicTo(pointF1.x, pointF1.y, pointF2.x, pointF2.y, pointF3.x, pointF3.y);
//                canvas.drawPath(path, mPaint);
//            }
////            path.reset();
////            int size = list.size();
////            PointF pointF = list.get(size - meinv);
////            PointF pointF1 = list.get(size - 2);
////            PointF pointF2 = list.get(size - 3);
////            PointF pointF3 = list.get(size - 4);
////            path.moveTo(pointF3.x, pointF3.y);
////            path.cubicTo(pointF2.x, pointF2.y, pointF1.x, pointF1.y, pointF.x, pointF.y);
////            canvas.drawPath(path, mPaint);
//        }
//
//
//    }
//
//    /**
//     * 令
//     * A0和B3连线的斜率 k = (B3Y - A0Y) / (B3X - A0X)
//     * 常数 b = A3Y - k * A3X
//     * 则
//     * A2的X坐标 A2X = A3X - (A3X - A0X) * rate
//     * A2的Y坐标 A2Y = k * A2X + b
//     * B1的X坐标 B1X = A3X + (B3X - A3X) * rate
//     * B1的Y坐标 B1Y = k * B1X + b
//     */
//    private void getControllList() {
//        pointFControllList.clear();
//        if (pointFList == null || pointFList.size() == 0 || pointFList.get(0).size() == meinv) return;
//
//        //第三个点开始取，第二个点为需要点，取右控制点，第三个点取左控制点
//        for (int j = 0; j < pointFList.size(); j++) {
//
//            List<PointF> list = pointFList.get(j);
//            List<PointF> controlls = new ArrayList<>();
//            for (int i = 2; i < list.size(); i++) {
//                PointF pointF0 = list.get(i - 2);
//                PointF pointF1 = list.get(i - meinv); //
//                PointF pointF2 = list.get(i);//
//
//                double k = (pointF2.y - pointF0.y) / (pointF2.x - pointF0.x);
//                double b = pointF1.y - k * pointF1.x;
//
//                //获取左坐标。
//                PointF leftcontrollPoint = new PointF();
//                leftcontrollPoint.x = (float) (pointF1.x - (pointF1.x - pointF0.x) * RATE);
//                leftcontrollPoint.y = (float) (k * leftcontrollPoint.x + b);
//
//                PointF rightcontrollPoint = new PointF();
//                rightcontrollPoint.x = (float) (pointF1.x + (pointF2.x - pointF1.x) * RATE);
//                rightcontrollPoint.y = (float) (k * rightcontrollPoint.x + b);
//                controlls.add(leftcontrollPoint);
//                controlls.add(pointF1);
//                controlls.add(rightcontrollPoint);
//            }
//
//            controlls.remove(0);
//            controlls.remove(controlls.size() - meinv);
//            pointFControllList.add(controlls);
//
//        }
//
//
//    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                return true;
//
//            case MotionEvent.ACTION_MOVE:
//
//                isOnTouch = true;
//                getX = event.getX();
//                invalidate();
//                break;
//            case MotionEvent.ACTION_UP:
//                isOnTouch = false;
//                invalidate();
//                break;
//            default:
//                break;
//        }
//
//        return super.onTouchEvent(event);
//    }
//
//
//    private void caculatePoint(Canvas canvas, int[] whX, int[] whY) {
//        pointFList.clear();
//        if (lists == null || lists.size() == 0) return;
//        int startY = (whY[meinv] + whX[meinv] + HORTEXTPADDINGLINE) * -meinv;
//        int effectiveHeight = height - whY[meinv] + startY;
//        int startX = STARTPADDING + whY[0];
//        int effectiveWidth = width - whX[0] - startX;
//        startY = startY - whY[meinv] / 2;
//        int maxLength = 0;
//        for (int i = 0; i < lists.size(); i++) {
//            int size = lists.get(i).size();
//            maxLength = size > maxLength ? size : maxLength;
//        }
//        if (maxLength <= 0) return;
//        int averagesWidth = effectiveWidth / ((maxLength - meinv) == 0 ? meinv : (maxLength - meinv));
//        mPaint.setStyle(Paint.Style.STROKE);
//        for (int j = 0; j < lists.size(); j++) {
//            mPaint.setColor(colors[j]);
//            List<PointF> list = new ArrayList<>();
//            List<HealthChangeMode> modes = lists.get(j);
//            int size = modes.size();
//            for (int i = 0; i < size; i++) {
//                HealthChangeMode healthChangeMode = modes.get(i);
//                Double aDouble = Double.valueOf(healthChangeMode.getReadNum());
//                aDouble = aDouble > mMaxY ? mMaxY : aDouble;
//                double v = aDouble / mMaxY * effectiveHeight;
//                int x = startX + whX[0] / 2 + i * averagesWidth;
//                int y = (int) (startY - v);
//                list.add(new PointF(x, y));
//            }
//            if (list.size() > meinv) {  //添加多两个坐标来计算控制点。
//                list.add(0, new PointF(list.get(0).x - averagesWidth, list.get(0).y));
//                list.add(new PointF(list.get(list.size() - meinv).x + averagesWidth, list.get(list.size() - meinv).y));
//            }
//
//            if (list.size() == meinv) {
//                PointF pointF = list.get(0);
//                canvas.drawCircle(pointF.x, pointF.y, 5, mPaint);
//            }
//            pointFList.add(list);
//
//
//        }
//
//
//    }
//
//
//    private void drawVerText(Canvas canvas, int[] whX, int[] whY) {
//        int startY = (whY[meinv] + whX[meinv] + HORTEXTPADDINGLINE) * -meinv;
//        int averageHeight = (height - whY[meinv] + startY) / 5;
//        int averageY = mMaxY / 5;
//        for (int i = 0; i < 6; i++) {
//            canvas.drawText(String.valueOf(0 + averageY * i), 0, startY - i * averageHeight, mPaint);
//        }
//
//    }
//
//    private void drawHorText(Canvas canvas, int[] whx, int[] whY) {
//        int startX = STARTPADDING + whY[0];
//        int averageWidth = (width - startX) / 2;
//        if (lists.size() == 0) return;
//        List<HealthChangeMode> healthChangeModes = lists.get(0);
//        if (healthChangeModes.size() == 0) return;
//        canvas.drawText(healthChangeModes.get(0).getCheckDate(), startX, -whx[meinv], mPaint);
//        if (healthChangeModes.size() <= meinv) return;
//        if (healthChangeModes.size() == 2) {
//            canvas.drawText(healthChangeModes.get(healthChangeModes.size() - meinv).getCheckDate(), startX + averageWidth * 2 - whx[0], -whx[meinv], mPaint);
//        } else {
//            canvas.drawText(healthChangeModes.get(healthChangeModes.size() / 2).getCheckDate(), startX + averageWidth - whx[0] / 2, -whx[meinv], mPaint);
//            canvas.drawText(healthChangeModes.get(healthChangeModes.size() - meinv).getCheckDate(), startX + averageWidth * 2 - whx[0], -whx[meinv], mPaint);
//        }
//
//    }
//
//    private void drawHorLine(Canvas canvas, int[] whX, int[] whY) {
//        mPaint.setColor(Color.parseColor("#ffeeeeee"));
//        int startY = (whY[meinv] + whX[meinv] + HORTEXTPADDINGLINE) * -meinv;
//        int averageHeight = (height - whY[meinv] + startY) / 5;
//        int startX = STARTPADDING + whY[0];
//        startY = startY - whY[meinv] / 2;
//        for (int i = 0; i < 6; i++) {
//            canvas.drawLine(startX, startY - i * averageHeight, width, startY - i * averageHeight, mPaint);
//        }
//    }
//
//    //获取字体宽高
//    private int[] getTextWidthAndHeight(String str) {
//        int[] wh = new int[2];
//        Rect rect = new Rect();
//        mPaint.getTextBounds(str, 0, str.length(), rect);
//        wh[0] = rect.width();
//        wh[meinv] = rect.height();
//        return wh;
//    }
//
//
//}
