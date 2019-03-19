package com.example.administrator.intenrviewtest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2019/3/18.
 */

public class AIDLService extends Service {


    IMyAidlInterface.Stub myAidlInterface = new IMyAidlInterface.Stub() {
        @Override
        public void testAIDL() throws RemoteException {
            Log.e( "testAIDL: ", "通信成功");
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myAidlInterface;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
