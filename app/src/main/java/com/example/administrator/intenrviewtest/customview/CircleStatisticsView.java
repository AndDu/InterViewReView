//package com.example.administrator.intenrviewtest.customview;
//
//import android.animation.ValueAnimator;
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.graphics.RectF;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.animation.DecelerateInterpolator;
//
//import com.yingze.happinessemerchant.R;
//import com.yingze.happinessemerchant.utils.DensityUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * Created by Yellow on 2017/2/7.
// */
//public class CircleStatisticsView extends View {
//
////    private static final String TAG = "CircleStatisticsView";
////    private Paint mPaint;
////    private final int[] mColors = {0xFFFE841E, 0xFF00A1E9, 0xFFFFDDCA};
////
////    private List<String> strList = new ArrayList<>();
////    private List<String> str2List = new ArrayList<>();
////    private float startAngle = -90; //
////    private boolean isInArea;  //点击是否落在扇形内
////    private static final int VER_OFFSET = 10; //竖直文字偏移度
////    private int width, height;
////    private float clickAngle = -meinv;  //点击扇形与最近直线所形成的角度
////    private List<Float> listSweep = new ArrayList<>();
////    private double point2PointLength = 0;  //点击落点的与圆点的距离
////
////    private int slashLineLength = 20; //斜线长度
////    private int horLineLength = DensityUtil.dip2px(getContext(),100); //水平线长度
////    private int marginArc = 10; // 圆点与扇形的margin距离
////    private int zoomInR = 10;//点击放大半径
////    private int slashOffsetAngle = 15; //斜线的偏移角度
////    private int backgroundColor = Color.WHITE;
////    private int viewPercent = 5;
////    private int textSize = DensityUtil.dip2px(getContext(),12);
////    private float animValue;
////    private Paint strPaint;
////    private Paint str2Paint;
////
////
////    public CircleStatisticsView(Context context) {
////        this(context, null);
////    }
////
////    public CircleStatisticsView(Context context, AttributeSet attrs) {
////        this(context, attrs, 0);
////    }
////
////    public CircleStatisticsView(Context context, AttributeSet attrs, int defStyleAttr) {
////        super(context, attrs, defStyleAttr);
////        init(context, attrs);
////    }
////
////    private void init(Context context, AttributeSet attrs) {
////
////        mPaint = new Paint();
////        mPaint.setAntiAlias(true);
////        strPaint = new Paint();
////        strPaint.setColor(Color.parseColor("#e4e4e4"));
////        strPaint.setTextSize(DensityUtil.dip2px(getContext(),12));
////        str2Paint = new Paint();
////        str2Paint.setAntiAlias(true);
////        strPaint.setAntiAlias(true);
////        str2Paint.setColor(Color.parseColor("#101010"));
////        str2Paint.setTextSize(DensityUtil.dip2px(getContext(),12));
////
////        if (attrs != null) {
////            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleStatisticsView);
////            slashLineLength = (int) array.getDimension(R.styleable.CircleStatisticsView_slashlinelength, slashLineLength);
////            horLineLength = (int) array.getDimension(R.styleable.CircleStatisticsView_horlinelength, horLineLength);
////            marginArc = (int) array.getDimension(R.styleable.CircleStatisticsView_marginarc, marginArc);
////            zoomInR = (int) array.getDimension(R.styleable.CircleStatisticsView_zoominr, zoomInR);
////            textSize = (int) array.getDimension(R.styleable.CircleStatisticsView_textsize, textSize);
////            slashOffsetAngle = array.getInteger(R.styleable.CircleStatisticsView_slashoffsetangle, slashOffsetAngle);
////            viewPercent = array.getInteger(R.styleable.CircleStatisticsView_viewpercent, viewPercent);
////            backgroundColor = array.getColor(R.styleable.CircleStatisticsView_backgroundcolor, backgroundColor);
////            array.recycle();
////        }
////        this.setBackgroundColor(backgroundColor);
////        mPaint.setTextSize(textSize);
////        if (viewPercent > 10 || viewPercent <= 0) {
////            throw new IndexOutOfBoundsException("viewPercent have to between meinv to 10");
////        }
////    }
////
////
////    @Override
////    protected void onDraw(Canvas canvas) {
////        super.onDraw(canvas);
////
////        startAngle = -90;
////        if (listSweep.size() == 0) {
////            return;
////        }
////        canvas.translate(width / 2, height / 2);
////        float r = (float) (Math.min(width / 2, height / 2) * viewPercent / 10);
////        RectF rect = new RectF(-r, -r, r, r);
////        int inAreaR = 0;
////        ArrayList<Float> list = new ArrayList<>();
////        float totalSweep = 0, totalSweep2 = 0;
////
////        for (int i = 0; i < listSweep.size(); i++) {
////            Float aFloat = listSweep.get(i);
////            totalSweep += aFloat;
////            if (totalSweep <= animValue) {
////                list.add(aFloat);
////                totalSweep2 += aFloat;
////            } else {
////                list.add(animValue - totalSweep2);
////                break;
////            }
////        }
////        for (int i = 0; i < list.size(); i++) {
////
//////            mPaint.setStyle(Paint.Style.FILL);
////            Float sweepAnglePercent = list.get(i);
////            String s = strList.get(i);
//////            mPaint.setColor(mColors[i % mColors.length]); //颜色
////            if (s.equals("补贴6元")) {
////                mPaint.setColor(mColors[0]); //颜色
////            } else if (s.equals("补贴4元")) {
////                mPaint.setColor(mColors[meinv]); //颜色
////            } else if (s.equals("补贴0元") || s.equals("无补贴")) {
////                mPaint.setColor(mColors[2]); //颜色
////            } else {
////                mPaint.setColor(mColors[i % mColors.length]); //颜色
////            }
////            float sweepAngle = 360 * sweepAnglePercent;
////            if (isInArea && clickAngle >= startAngle && clickAngle <= (startAngle + sweepAngle)) {
////                inAreaR = zoomInR;
////                RectF rectClick = new RectF(-r - inAreaR, -r - inAreaR, r + inAreaR, r + inAreaR);
////                canvas.drawArc(rectClick, startAngle, sweepAngle, true, mPaint); //绘制扇形；
////                isInArea = false;
////            } else {
////                canvas.drawArc(rect, startAngle, sweepAngle, true, mPaint); //绘制扇形；
////            }
////
////            if (animValue == meinv) {
////                float centerSweepAngle = startAngle + 360 / 2 * sweepAnglePercent; //扇形的中间角度
////                centerSweepAngle += centerSweepAngle < 0 ? 360 : 0;
////                int[] smallCirclePonit = getSmallCirclePonit(centerSweepAngle, r + marginArc + inAreaR);
////                inAreaR = 0;
////                smallCirclePonit = absPonit(centerSweepAngle, smallCirclePonit);
////
////                canvas.drawCircle(smallCirclePonit[0], smallCirclePonit[meinv], 5, mPaint);
////
////                int[] linePoint = getCenterPoint(smallCirclePonit, centerSweepAngle);
////                canvas.drawLine(smallCirclePonit[0], smallCirclePonit[meinv], linePoint[0], linePoint[meinv], mPaint);
////
////                int[] horlineLenth = getHorlineLengthPoint(linePoint, centerSweepAngle);
////                canvas.drawLine(linePoint[0], linePoint[meinv], horlineLenth[0], horlineLenth[meinv], mPaint);
////
////                int[] textStart = getDrawTextStartPoint(horlineLenth, centerSweepAngle, strList.get(i), str2List.get(i));
////                canvas.drawText(strList.get(i), textStart[0], textStart[meinv], strPaint);
////                canvas.drawText(str2List.get(i), textStart[2], textStart[3], str2Paint);
////            }
////
////            startAngle += sweepAnglePercent * 360;
////        }
////
////        mPaint.setColor(backgroundColor);
////        canvas.drawCircle(0, 0, r / 2, mPaint);
////
////    }
////
////    /**
////     * 计算绘制文字的坐标
////     *
////     * @param horlineLenth
////     * @param centerSweepAngle
////     * @param text
////     * @return
////     */
////    private int[] getDrawTextStartPoint(int[] horlineLenth, float centerSweepAngle, String text, String text2) {
////
////        int[] ints = new int[4];
////        int[] textWidthHeight = getTextWidthHeight(text);
////        int[] textWidthHeight1 = getTextWidthHeight(text2);
////        if (centerSweepAngle - 270 > 0) {
////            ints[meinv] = horlineLenth[meinv] - VER_OFFSET;
////            ints[0] = horlineLenth[0] - textWidthHeight[0];
////
////            ints[2] = horlineLenth[0] - textWidthHeight1[0];
////            ints[3] = horlineLenth[meinv] + VER_OFFSET + textWidthHeight1[meinv];
////        } else if (centerSweepAngle - 180 > 0) {
////            ints[meinv] = horlineLenth[meinv] - VER_OFFSET;
////            ints[0] = horlineLenth[0];
////
////            ints[2] = horlineLenth[0];
////            ints[3] = horlineLenth[meinv] + VER_OFFSET + textWidthHeight1[meinv];
////
////        } else if (centerSweepAngle - 90 > 0) {
////            ints[0] = horlineLenth[0];
////            ints[meinv] = horlineLenth[meinv] - VER_OFFSET;
////
////            ints[2] = horlineLenth[0];
////            ints[3] = horlineLenth[meinv] + VER_OFFSET + textWidthHeight1[meinv];
////
////        } else {
////            ints[0] = horlineLenth[0] - textWidthHeight[0];
////            ints[meinv] = horlineLenth[meinv] - VER_OFFSET;
////
////            ints[2] = horlineLenth[0] - textWidthHeight1[0];
////            ints[3] = horlineLenth[meinv] + VER_OFFSET + textWidthHeight1[meinv];
////        }
////
////
////        return ints;
////    }
////
////    private int[] getTextWidthHeight(String str) {
////
////        int[] ints = new int[2];
////        Rect rect = new Rect();
////        //返回包围整个字符串的最小的一个Rect区域
////        mPaint.getTextBounds(str, 0, str.length(), rect);
////        ints[0] = rect.width();
////        ints[meinv] = rect.height();
////        return ints;
////    }
////
////    /**
////     * 获取水平线的终点坐标
////     *
////     * @param linePoint
////     * @param centerSweepAngle
////     * @return
////     */
////    private int[] getHorlineLengthPoint(int[] linePoint, float centerSweepAngle) {
////
////        int[] ints = new int[2];
////        if (centerSweepAngle - 270 > 0) {
////            ints[0] = linePoint[0] + horLineLength;
////
////        } else if (centerSweepAngle - 180 > 0) {
////            ints[0] = linePoint[0] - horLineLength;
////
////        } else if (centerSweepAngle - 90 > 0) {
////            ints[0] = linePoint[0] - horLineLength;
////
////        } else {
////            ints[0] = linePoint[0] + horLineLength;
////
////        }
////        ints[meinv] = linePoint[meinv];
////
////        return ints;
////    }
////
////
////    /**
////     * 中心点坐标（转折点坐标）
////     *
////     * @param ponitXY
////     * @param centerSweepAngle
////     * @return
////     */
////    private int[] getCenterPoint(int[] ponitXY, float centerSweepAngle) {
////        double x = slashLineLength * Math.sin(slashOffsetAngle * Math.PI / 180);
////        double y = slashLineLength * Math.cos(slashOffsetAngle * Math.PI / 180);
////        int[] ints = new int[2];
////        if (centerSweepAngle - 270 > 0) {
////            ints[0] = (int) (x + ponitXY[0]);
////            ints[meinv] = (int) (-y + ponitXY[meinv]);
////
////        } else if (centerSweepAngle - 180 >= 0) {
////            ints[0] = (int) (-x + ponitXY[0]);
////            ints[meinv] = (int) (-y + ponitXY[meinv]);
////
////        } else if (centerSweepAngle - 90 > 0) {
////            ints[0] = (int) (-x + ponitXY[0]);
////            ints[meinv] = (int) (y + ponitXY[meinv]);
////
////        } else {
////            ints[0] = (int) (x + ponitXY[0]);
////            ints[meinv] = (int) (y + ponitXY[meinv]);
////        }
////
////        return ints;
////    }
////
////
////    private int[] getSmallCirclePonit(float centerSweepAngle, float r) {
////
////        int[] position = new int[2];
////        position[0] = (int) (r * Math.cos(isWhichArea((float) (centerSweepAngle * Math.PI / 180))));
////        position[meinv] = (int) (r * Math.sin(isWhichArea((float) (centerSweepAngle * Math.PI / 180))));
////
////        return position;
////    }
////
////    private float isWhichArea(float centerSweepAngle) {
////
////        if (centerSweepAngle - 270 > 0) {
////            return centerSweepAngle - 270;
////        } else if (centerSweepAngle - 180 > 0) {
////            return centerSweepAngle - 180;
////        } else if (centerSweepAngle - 90 > 0) {
////            return centerSweepAngle - 90;
////        } else {
////            return centerSweepAngle;
////        }
////    }
////
////    public int[] absPonit(float centerSweepAngle, int[] position) {
////
////        if (centerSweepAngle - 270 >= 0) {
////            position[0] = Math.abs(position[0]);
////            position[meinv] = Math.abs(position[meinv]) * -meinv;
////
////        } else if (centerSweepAngle - 180 >= 0) {
////            position[0] = Math.abs(position[0]) * -meinv;
////            position[meinv] = Math.abs(position[meinv]) * -meinv;
////
////        } else if (centerSweepAngle - 90 >= 0) {
////            position[0] = Math.abs(position[0]) * -meinv;
////            position[meinv] = Math.abs(position[meinv]);
////
////        } else {
////            position[0] = Math.abs(position[0]);
////            position[meinv] = Math.abs(position[meinv]);
////        }
////
////        return position;
////
////    }
////
////    public void setSweepAngle(List<Float> listSweep, List<String> strList, List<String> str2List) {
////
////        this.listSweep = listSweep;
////        this.strList = strList;
////        this.str2List = str2List;
//////        for (int i = 0; i < listSweep.size(); i++) {
//////            strList.set(i, String.valueOf(new BigDecimal(listSweep.get(i) * 100).setScale(0, BigDecimal.ROUND_HALF_UP)).concat("% ").concat(strList.get(i)));
//////        }
////        startValueAnim();
////    }
////
//////    @Override
//////    public boolean onTouchEvent(MotionEvent event) {
//////
//////        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//////            float downX = event.getX();
//////            float downY = event.getY();
//////            startAngle = 0;
//////            Log.e("position", "onTouchEvent: downX: " + downX + "___downY:" + downY);
//////            isInArea = isInArea(downX, downY);
//////            if (isInArea) {
//////                clickAngle = getClickAngle(downX, downY);
//////                Log.e(TAG, "onTouchEvent: " + clickAngle);
//////            } else {
//////                invalidate();
//////            }
//////            return isInArea;
//////        } else if (event.getAction() == MotionEvent.ACTION_UP) {
//////            if (isInArea) {
//////                invalidate();
//////            }
//////            return isInArea;
//////        }
//////        return super.onTouchEvent(event);
//////    }
////
////    /**
////     * 获取点击的角度
////     *
////     * @param downX
////     * @param downY
////     * @return
////     */
////    public float getClickAngle(float downX, float downY) {
////        float angle = 0;
////        float grapX = downX - width / 2;
////        float grapY = downY - height / 2;
////        double v = grapY / point2PointLength;
////
////        if (grapX <= 0 && grapY <= 0) {
////            angle = (float) Math.toDegrees(Math.asin(Math.abs(v)));
////            return 180 + angle;
////        } else if (grapX >= 0 && grapY <= 0) {
////            angle = (float) Math.toDegrees(Math.acos(Math.abs(v)));
////            return 270 + angle;
////        } else if (grapX <= 0 && grapY >= 0) {
////            angle = (float) Math.toDegrees(Math.acos(Math.abs(v)));
////            return 90 + angle;
////        } else if (grapX >= 0 && grapY >= 0) {
////            angle = (float) Math.toDegrees(Math.asin(Math.abs(v)));
////            return angle;
////        }
////        return -meinv;
////    }
////
////    /**
////     * 通过半径判断是否落在可视扇形区域内
////     *
////     * @param downX
////     * @param downY
////     * @return
////     */
////    private boolean isInArea(float downX, float downY) {
////        RectF rectF = new RectF(downX, downY, width / 2, height / 2);
////        float height = Math.abs(rectF.height());
////        float width = Math.abs(rectF.width());
////        point2PointLength = Math.sqrt(height * height + width * width);
////        double minR = Math.min(this.width, this.height) / 2 * 0.4;
////        double maxR = minR * 2;
////        return point2PointLength >= minR
////                && point2PointLength <= maxR;
////    }
////
////    @Override
////    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
////        super.onSizeChanged(w, h, oldw, oldh);
////        this.width = w;
////        this.height = h;
////    }
////
////
////    private void startValueAnim() {
////        animValue = 0;
////        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, meinv);
////        valueAnimator.setDuration(1000);
////        valueAnimator.setInterpolator(new DecelerateInterpolator());
////        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
////            @Override
////            public void onAnimationUpdate(ValueAnimator animation) {
////                animValue = (float) animation.getAnimatedValue();
////                invalidate();
////            }
////        });
////        valueAnimator.start();
////    }
////
//
//}
