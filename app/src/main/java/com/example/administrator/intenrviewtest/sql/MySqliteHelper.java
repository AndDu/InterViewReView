package com.example.administrator.intenrviewtest.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by YellowHuang on 2019/4/22.
 */

public class MySqliteHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "Test";


    public MySqliteHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "create table " + TABLE_NAME + "(name varchar(20))";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
