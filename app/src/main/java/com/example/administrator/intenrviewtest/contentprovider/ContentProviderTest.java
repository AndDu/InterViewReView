package com.example.administrator.intenrviewtest.contentprovider;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by YellowHuang on 2019/4/22.
 */

public class ContentProviderTest extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x12);
//        }

        ContentResolver contentResolver = getContentResolver();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TestContract.TestEntry.COLUMN_NAME, "我是dsds1");
        contentValues.put(TestContract.TestEntry.COLUMN_NAME, "我是dsds2");
        contentResolver.insert(TestContract.TestEntry.CONTENT_URI, contentValues);
        Cursor cursor = contentResolver.query(TestContract.TestEntry.CONTENT_URI, null, null, null, null);
        Log.e("onCreate: ", cursor.getCount() + "");
        while (cursor.moveToNext()) {
            String columnName = cursor.getString(0);
            Log.e("onCreate: ", columnName);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }
}
