package com.example.administrator.intenrviewtest.databinding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.intenrviewtest.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;

public class DataBindTestActivity extends AppCompatActivity {

    private ActivityDatabindTestBindingImpl viewDataBinding;
    private ListView lv_;


    public static void startActivity(Context context) {

        Intent intent = new Intent(context, DataBindTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_databind_test);
        final TestMode testMode = new TestMode();
        viewDataBinding.setHanlders(this);
        viewDataBinding.setTestMode(testMode);
        lv_ = findViewById(R.id.lv_);
        lv_.setAdapter(new AdapterTest());
    }


    public void ontestClick(View view) {
        TestMode testMode = viewDataBinding.getTestMode();
        ObservableBoolean aBoolean = testMode.aBoolean;
        aBoolean.set(!aBoolean.get());
    }
}
