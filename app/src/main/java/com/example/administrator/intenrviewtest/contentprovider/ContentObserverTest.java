package com.example.administrator.intenrviewtest.contentprovider;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

public class ContentObserverTest extends ContentObserver {

    private Context context;

    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public ContentObserverTest(Handler handler,Context context) {
        super(handler);
        this.context=context;
    }


    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        Log.e("onChange: ", selfChange + "");
    }


    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);
        int match = TestProvider.buildUriMatcher().match(uri);
        if (match == TestContract.RETURNCODE) {
            Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    Log.e("onChange: ", name);

                }
            }
            cursor.close();
        }

    }


    @Override
    public boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }
}

