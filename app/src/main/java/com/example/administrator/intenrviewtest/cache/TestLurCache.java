package com.example.administrator.intenrviewtest.cache;

import android.graphics.Bitmap;

import java.lang.ref.SoftReference;

import androidx.collection.LruCache;

/**
 * Created by YellowHuang on 2019/6/18.
 */

public class TestLurCache  {
    private LruCache<String,SoftReference<Bitmap> > cache=new LruCache<>((int) (Runtime.getRuntime().maxMemory()*1/8));
}
