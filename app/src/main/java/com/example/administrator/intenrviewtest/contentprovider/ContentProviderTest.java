package com.example.administrator.intenrviewtest.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.administrator.intenrviewtest.R;

/**
 * Created by YellowHuang on 2019/4/22.
 */

public class ContentProviderTest extends AppCompatActivity {

    Handler handler = new Handler();
    private ContentResolver contentResolver;
    private ContentObserverTest observer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contentprovider);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x12);
//        }


        contentResolver = getContentResolver();
        observer = new ContentObserverTest(handler, this);
        Uri contentUri = TestContract.TestEntry.CONTENT_URI;
        contentResolver.registerContentObserver(contentUri,
                true,
                observer);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    public void insert(View view) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(TestContract.TestEntry.COLUMN_NAME, "我是dsds2");
        contentResolver.insert(TestContract.TestEntry.CONTENT_URI, contentValues);
        Cursor cursor = contentResolver.query(TestContract.TestEntry.CONTENT_URI, null, null, null, null);

        Log.e("onCreate: ", cursor.getCount() + "");
        while (cursor.moveToNext()) {
            String columnName = cursor.getString(0);
            Log.e("onCreate: ", columnName);
        }
        //必须加上这一句，否则ContentObserver不生效。
        contentResolver.notifyChange(TestContract.TestEntry.CONTENT_URI, null);

    }

    @Override
    protected void onDestroy() {
        contentResolver.unregisterContentObserver(observer);
        super.onDestroy();
    }
}
