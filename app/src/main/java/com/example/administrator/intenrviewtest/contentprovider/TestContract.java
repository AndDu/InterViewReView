package com.example.administrator.intenrviewtest.contentprovider;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import com.example.administrator.intenrviewtest.sql.MySqliteHelper;

public class TestContract {


    protected static final String CONTENT_AUTHORITY = "com.example.administrator.intenrviewtest";
    protected static final String PATH_TEST = MySqliteHelper.TABLE_NAME;
    protected static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    protected static final int RETURNCODE = 0x10;

    public static final class TestEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TEST).build();

        protected static Uri buildUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        protected static final String TABLE_NAME = MySqliteHelper.TABLE_NAME;

        public static final String COLUMN_NAME = "name";
    }
}