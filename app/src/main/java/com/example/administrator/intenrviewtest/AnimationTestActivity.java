package com.example.administrator.intenrviewtest;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by Administrator on 2019/3/13.
 */

public class AnimationTestActivity extends AppCompatActivity {


    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, AnimationTestActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);
    }

    public void sca(View view) {
        float pivotX = view.getPivotX();
        float pivotY = view.getPivotY();
        ScaleAnimation animation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, pivotX, pivotY);
        animation.setDuration(1000);
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
//        animation.start();
        view.startAnimation(animation);
    }

    public void aphla(View view) {
        AlphaAnimation animation = new AlphaAnimation(1f, 0.5f);
        animation.setDuration(1000);
        view.startAnimation(animation);
    }

    public void translate(View view) {
        TranslateAnimation animation = new TranslateAnimation(1f, 0.5f, 1f, 0.5f);
        animation.setDuration(1000);
        view.startAnimation(animation);
    }

    public void rote(View view) {
        RotateAnimation animation = new RotateAnimation(0, 360, view.getPivotX(), view.getPivotY());
        animation.setDuration(1000);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(Animation.RESTART);
        view.startAnimation(animation);
    }


    public void valueAnim(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                Log.e("onAnimationUpdate: ", animatedValue + "");
            }
        });
        valueAnimator.start();
    }

    public void objectAnim(View view) {
        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator valueAnimator = ObjectAnimator.ofInt(view,"alpha",0,0);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                Log.e("onAnimationUpdate: ", animatedValue + "");
            }
        });
        valueAnimator.start();
    }


}
