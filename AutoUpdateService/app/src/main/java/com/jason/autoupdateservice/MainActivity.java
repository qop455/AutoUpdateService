package com.jason.autoupdateservice;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    Button startBtn;
    Button stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void createView(){
        setContentView(R.layout.activity_main);
        startBtn = (Button) findViewById(R.id.btn_start_service);
        stopBtn = (Button) findViewById(R.id.btn_stop_service);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isServiceRunning(MainService.class)) {

                }
                else{
                    startService(new Intent(MainActivity.this, MainService.class));
                }
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isServiceRunning(MainService.class)){
                    stopService(new Intent(MainActivity.this, MainService.class));
                }
                else{

                }
            }
        });
    }

    private boolean isServiceRunning(Class<?> serviceClass){
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i(TAG, "MainService is running!");
                return true;
            }
        }
        return false;
    }
}
