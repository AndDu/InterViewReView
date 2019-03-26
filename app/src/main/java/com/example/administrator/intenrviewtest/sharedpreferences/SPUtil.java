package com.example.administrator.intenrviewtest.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2019/3/26.
 */

public class SPUtil {

    public static void setSomething(Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("name", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
//        edit.putStringSet()
    }

}
