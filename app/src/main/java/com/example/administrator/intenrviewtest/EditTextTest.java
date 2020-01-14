package com.example.administrator.intenrviewtest;

import android.os.Build;
import android.widget.EditText;

import java.lang.reflect.Method;

import androidx.appcompat.app.AppCompatActivity;

public class EditTextTest extends AppCompatActivity {


    /**
     * 获取去焦点不显示软键盘
     * @param editText
     */
    void whenGetFocusDontSHowKeyborad(EditText editText) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            Class<EditText> cls = EditText.class;
            Method method;
            try {
                method = cls.getMethod("setShowSoftInputOnFocus", Boolean.class);
                method.setAccessible(true);
                method.invoke(editText, false);
            } catch (Exception e) {//TODO: handle exception }
            }
        } else {
            editText.setShowSoftInputOnFocus(false);
        }
    }
}
