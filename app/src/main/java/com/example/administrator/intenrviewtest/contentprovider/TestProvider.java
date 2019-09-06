package com.example.administrator.intenrviewtest.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.administrator.intenrviewtest.sql.MySqliteHelper;

/**
 * Created by YellowHuang on 2019/4/22.
 */

public class TestProvider extends ContentProvider {


    private MySqliteHelper mySqliteHelper;

    public static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        String authority = TestContract.CONTENT_AUTHORITY;
        uriMatcher.addURI(authority, TestContract.PATH_TEST, TestContract.RETURNCODE);
        return uriMatcher;
    }


    @Override
    public boolean onCreate() {
        mySqliteHelper = new MySqliteHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri,
                        @Nullable String[] projection,
                        @Nullable String selection,
                        @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {

        Cursor cursor = null;
        switch (buildUriMatcher().match(uri)) {
            case TestContract.RETURNCODE:
                SQLiteDatabase db = mySqliteHelper.getReadableDatabase();
                cursor = db.query(TestContract.TestEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder, null, null);
                break;
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Uri uri1 = null;
        switch (buildUriMatcher().match(uri)) {
            case TestContract.RETURNCODE:
                SQLiteDatabase db = mySqliteHelper.getWritableDatabase();
                long _id = db.insert(mySqliteHelper.TABLE_NAME, null, values);
                if (_id > 0) {
                    uri1 = TestContract.TestEntry.buildUri(_id);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
            default:
                throw new android.database.SQLException("Unknown uri:" + uri);

        }
        return uri1;
    }

    @Override
    public int delete(@NonNull Uri uri,
                      @Nullable String selection,
                      @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri,
                      @Nullable ContentValues values,
                      @Nullable String selection,
                      @Nullable String[] selectionArgs) {
        return 0;
    }
}
