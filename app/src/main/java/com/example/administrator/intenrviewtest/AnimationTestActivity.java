package com.example.administrator.intenrviewtest;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by Administrator on 2019/3/13.
 * Android 动画分属性动画的帧动画
 * ————————————————————————————————————————
 * 帧动画：
 * <p>
 * ————————————————————————————————————————\
 * <p>
 * _________________________________________________________
 * <p>
 * 补间动画：
 * ScaleAnimation AlphaAnimation TranslateAnimation RotateAnimation
 * 使用new来创建时直接构建相应属性，组合动画用AnimationSet ,直接addAnimation
 * 使用XML相对简单 ，在res下新建Anim即可，使用AnimationUtils 直接加载
 * <p>
 * <p>
 * ___________________________________________________
 * <p>
 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 属性动画：valueAnimator ObjectAnimator
 * ValueAnimator valueAnimator1 = ValueAnimator.ofInt(0, 100);
 * <p>
 * ObjectAnimator 派生自ValueAnimator ,所以ValueAnimator有的他也有
 * ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view,"alpha",0f, 1f);
 * ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view,"TranslationX",100f, 0f);
 * ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view,"TranslationY",100f, 0f,-100f);
 * ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view,"TranslationZ",0f,100f,0f);
 * ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f, -1f);  //倒转
 * ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f, 1f);
 *
 * 组合动画用AnimatorSet , set.play(valueAnimator).with().before().after()
 * 暂时这么多
 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *
 * activity启动动画
 *
 *
 */

public class AnimationTestActivity extends AppCompatActivity {


//    public static void startActivity(Context context){
//        Intent intent = new Intent(context, AnimationTestActivity.class);
//
//        ActivityCompat.startActivity(context,intent,);
//    }


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

    public void animSet(View view) {
        float pivotX = view.getPivotX();
        float pivotY = view.getPivotY();
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, view.getPivotX(), view.getPivotY());
        TranslateAnimation translateAnimation = new TranslateAnimation(1f, 0.5f, 1f, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0.5f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, pivotX, pivotY);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(2000);
        view.startAnimation(animationSet);

    }


    public void objectAnim(View view) {
        AnimatorSet set=new AnimatorSet();

//        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view,"alpha",0f, 1f);
//        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view,"TranslationX",100f, 0f);
//        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view,"TranslationY",100f, 0f,-100f);
//        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view,"TranslationZ",0f,100f,0f);
//        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f, -1f);  //倒转
//        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f, 1f);
        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(view, "Rotation", 0, 270, 0);
//        set.play(valueAnimator).with().before().after()
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                Log.e("onAnimationUpdate: ", animatedValue + "");
            }
        });
        valueAnimator.start();
    }


}
