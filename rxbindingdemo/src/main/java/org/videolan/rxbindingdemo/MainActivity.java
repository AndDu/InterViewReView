package org.videolan.rxbindingdemo;


import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding3.view.RxView;

import java.lang.reflect.Method;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

public class MainActivity extends AppCompatActivity {


    private TextView tv_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_=findViewById(R.id.tv_);

        RxView.clicks(tv_).subscribe(new Consumer<Unit>() {
            @Override
            public void accept(Unit unit) throws Exception {

            }
        });
    }




}
