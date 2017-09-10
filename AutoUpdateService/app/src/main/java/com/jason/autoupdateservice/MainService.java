package com.jason.autoupdateservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jason on 2017/9/10.
 */

public class MainService  extends Service{
    private final static String TAG = "MainService";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "MainService is started!");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "MainService is stopped!");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
