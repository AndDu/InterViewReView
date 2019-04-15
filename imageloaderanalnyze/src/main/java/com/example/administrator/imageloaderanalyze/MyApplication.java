package com.example.administrator.imageloaderanalyze;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.ImageView;

import com.example.imageloaderanalnyze.R;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

import java.io.File;
import java.io.IOException;

/**
 * Created by YellowHuang on 2018/4/9.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this);
//        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        DisplayImageOptions.Builder options = new DisplayImageOptions.Builder();
        options.bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageOnLoading(R.mipmap.ic_launcher_round)
                .considerExifParams(true)
//                .cloneFrom()
//                .decodingOptions(bitmapOptions)
//                .delayBeforeLoading()//延时加载
                .displayer(new CircleBitmapDisplayer())
//        .extraForDownloader()       //????????这个方法有待考究
                .imageScaleType(ImageScaleType.EXACTLY) //具体效果待考究
//                .handler()  //不记得是初始化还是加载时候看到，之后再看。
                .postProcessor(new BitmapProcessor() {//bitmap在展示后的处理，之后保存到内存中。
                    @Override
                    public Bitmap process(Bitmap bitmap) {
                        return bitmap;
                    }
                })
                .preProcessor(new BitmapProcessor() {  //可以在缓存进内存前进行预处理
                    @Override
                    public Bitmap process(Bitmap bitmap) {
                        return bitmap;
                    }
                })
                .resetViewBeforeLoading(false);

        builder.denyCacheImageMultipleSizesInMemory() //deny否定  拒绝缓存图片的多重尺寸进内存
                .defaultDisplayImageOptions(options.build())
                .memoryCacheExtraOptions(300,300)
                .diskCache(new LimitedAgeDiskCache(Environment.getDataDirectory(), 100)) //本地缓存路径
//                .diskCacheExtraOptions(200, 200, new BitmapProcessor() {
//                    @Override
//                    public Bitmap process(Bitmap bitmap) {
//                        return bitmap;
//                    }
//                })
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .imageDecoder(new BaseImageDecoder(true))
                .writeDebugLogs();

//        ImageLoaderConfiguration build = builder.build();
        ImageLoaderConfiguration imageLoaderConfiguration = builder.build();
        ImageLoader.getInstance().init(imageLoaderConfiguration);
    }
}
