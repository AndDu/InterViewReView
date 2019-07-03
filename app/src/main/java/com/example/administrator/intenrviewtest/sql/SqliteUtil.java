package com.example.administrator.intenrviewtest.sql;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by YellowHuang on 2019/6/25.
 */

public class SqliteUtil {


    MySqliteHelper mySqliteHelper;


    public  void insert(){
        SQLiteDatabase writableDatabase = mySqliteHelper.getWritableDatabase();
//        writableDatabase.delete()

//        writableDatabase.update()
//        writableDatabase.insert();
//        writableDatabase.close();
    }

}
