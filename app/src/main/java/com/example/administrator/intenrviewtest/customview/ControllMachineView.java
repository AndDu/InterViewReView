package com.example.administrator.intenrviewtest.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ControllMachineView extends View {


    private int width;
    private Paint paint;
    private int height;
    private int cx;
    private int cy;
    private int innerCr = 80;
    private int outerCr = 200;
    private RectF innerRectF;
    private RectF outerRectF;
    int division = 2;

    private List<Region> regions;


    public ControllMachineView(Context context) {
        this(context, null);
    }

    public ControllMachineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ControllMachineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        regions = new ArrayList<>();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        cx = width / 2;
        cy = height / 2;
        innerRectF = new RectF(cx - innerCr, cy - innerCr, cx + innerCr, cy + innerCr);
        outerRectF = new RectF(cx - outerCr, cy - outerCr, cx + outerCr, cy + outerCr);
        Path path = new Path();
        //内圆
        path.addCircle(cx, cy, innerCr - 2 * division, Path.Direction.CW);

        Region region = new Region();
        region.setPath(path, new Region(cx - outerCr, cy - outerCr, cx + outerCr, cy + outerCr));
        regions.add(region);
        //外部按钮
        path.reset();
        float disAngleInner = (float) (division / (2 * Math.PI * innerCr) * 360);//内弧偏转角度
        float disAngleOuter = (float) (division / (2 * Math.PI * outerCr) * 360);//内弧偏转角度

        float sweeppAngleInner = 90 - 2 * disAngleInner; // 内转偏角
        float sweeppAngleOuter = 90 - 2 * disAngleOuter;//外传偏角

        path.addArc(innerRectF, -135 + disAngleInner, sweeppAngleInner);
        path.lineTo((float) (cx + outerCr * Math.sin(sweeppAngleOuter * Math.PI / 360)),
                (float) (cy - outerCr * Math.cos(sweeppAngleOuter * Math.PI / 360)));

        path.addArc(outerRectF, -45 - disAngleOuter, -sweeppAngleOuter);
        path.lineTo((float) (cx - innerCr * Math.sin(sweeppAngleInner * Math.PI / 360)),
                (float) (cy - innerCr * Math.cos(sweeppAngleInner * Math.PI / 360)));

        Region region2 = new Region();
        region2.setPath(path, new Region(cx - outerCr, cy - outerCr, cx + outerCr, cy + outerCr));
        regions.add(region2);

        //继续添加其他区域

        for (int i = 0; i < 3; i++) {

            Matrix matrix = new Matrix();
            matrix.setRotate(90, cx, cy);
            path.transform(matrix);

            Region region3 = new Region();
            region3.setPath(path, new Region(cx - outerCr, cy - outerCr, cx + outerCr, cy + outerCr));
            regions.add(region3);

        }

    }


    @Override
    protected void onDraw(Canvas canvas) {

        for (Region region : regions) {
            canvas.drawPath(region.getBoundaryPath(), paint);
        }
        super.onDraw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_UP) {
            int x = (int) event.getX();
            int y = (int) event.getY();


            for (int i = 0; i < regions.size(); i++) {

                if (regions.get(i).contains(x, y)) {
                    this.setTag(getId(), i);
                    return super.onTouchEvent(event);
                }

            }

            return false;

        }

        return super.onTouchEvent(event);
    }
}
