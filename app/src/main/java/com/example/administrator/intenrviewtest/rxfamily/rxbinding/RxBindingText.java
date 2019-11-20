package com.example.administrator.intenrviewtest.rxfamily.rxbinding;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;

import com.example.administrator.intenrviewtest.R;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.view.ViewScrollChangeEvent;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.concurrent.TimeUnit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

public class RxBindingText extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxView
//                .clicks(new View(this))//点击
//                .longClicks(new View(this))//点击
//                .attaches(new View(this)) //绑定
//                .attachEvents(new View(this))
//                .detaches(new View(this))
//                .drags(new View(this))//拖拽
//                .focusChanges(new View(this))//焦点变化
//                .scrollChangeEvents(new View(this))//滑动事件变化 api 23
//                .draws(new View(this))//绘制事件变化 api 16 ,
//                .globalLayouts(new View(this))//绘制事件变化 api 16 ,
                .globalLayouts(new View(this))//绘制事件变化 api 16 ,
                .as(AutoDispose.<Unit>autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(new Consumer<Unit>() {
                    @Override
                    public void accept(Unit unit) throws Exception {

                    }
                });
    }
}
