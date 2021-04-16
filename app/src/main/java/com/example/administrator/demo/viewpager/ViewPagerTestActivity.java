package com.example.administrator.demo.viewpager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.intenrviewtest.MainActivity;
import com.example.administrator.intenrviewtest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerTestActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private ArrayList<View> views;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ViewPagerTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);


//        Vector<String>

        views = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ImageView view = (ImageView) LayoutInflater.from(this).inflate(R.layout.layout_imageview, viewpager, false);

            views.add(view);
        }

        viewpager = findViewById(R.id.viewpager);
        viewpager.setOffscreenPageLimit(3);
        viewpager.setPageTransformer(false, new ViewPager.PageTransformer() {

            private static final float defaultScale = 0.80f;
            private static final float MIN_ALPHA = 0.5f;

            @Override
            public void transformPage(View page, float position) {
//                Log.e("transformPage: ", position + "");
//                if (position < -1 || position > 1) {
//                    page.setAlpha(MIN_ALPHA);
//                    page.setScaleX(MIN_SCALE);
//                    page.setScaleY(MIN_SCALE);
//                } else if (position <= 1) { // [-1,1]
//                    float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
//                    if (position < 0) {
//                        float scaleX = 1 + 0.3f * position;
//                        page.setScaleX(scaleX);
//                        page.setScaleY(scaleX);
//                    } else {
//                        float scaleX = 1 - 0.3f * position;
//                        page.setScaleX(scaleX);
//                        page.setScaleY(scaleX);
//                    }
//                    page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
//                }

                if (position < -1) { // [-Infinity,-1)
                    page.setScaleX(defaultScale);
                    page.setScaleY(defaultScale);

                } else if (position <= 0) { // [-1,0]
                    page.setScaleX((float) 1 + position / (float) 15);
                    page.setScaleY((float) 1 + position / (float) 15);

                } else if (position <= 1) { // (0,1]
                    page.setScaleX((float) 1 - position / (float) 15);
                    page.setScaleY((float) 1 - position / (float) 15);

                } else { // (1,+Infinity]
                    page.setScaleX(defaultScale);
                    page.setScaleY(defaultScale);
                }

            }
        });
        viewpager.setAdapter(new MyAdapter());
    }


    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }


        @Override
        public int getItemPosition(@NonNull Object object) {
            /**
             * 在ViewPager中同样有notifyDataSetChanged()对PagerAdpter中数据更新，
             * 但是通常像ListView中的ArrayAdapter调用notifyDataSetChange()，
             * 页面不会像我们认为的那样立即进行更新。因为PagerAdapter在刷新过程中，
             * 每次都会调用notifyDataSetChanged()时，都会调用getItemPosition(Object object)方法，
             * 该方法会便历ViewPager所有的Item，并且为每个Item返回一个状态值（POSITION_NONE/POSITION_UNCHANGED），
             * 如果返回值为POSITION_NONE 那么该Item会被destroyItem(ViewGroup container,
             * int position, Object object)方法remove掉，然后重新加载，如果是POSITION_UNCHANGED，
             * 则不会重新加载，在默认的情况下，始终为POSITION_UNCHANGED，所以我们要在ViewPager更新数据，
             * 就需要重写getItemPosition(Object object)
             */
            return POSITION_NONE;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView view = (ImageView) views.get(position);
            view.setImageResource(R.drawable.meiren);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

}
