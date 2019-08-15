package com.example.administrator.intenrviewtest.databinding;

import android.view.View;

import androidx.databinding.ObservableBoolean;

public class TestMode {

    public ObservableBoolean aBoolean = new ObservableBoolean();

    public void onclick(View view) {
        aBoolean.set(!aBoolean.get());
    }
}
