package com.example.servicesrevisited;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MyService extends Service {

    private static final String TAG = "MTAG";

    public  MyService(){}

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: Service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final Handler handler = new Handler();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "onStartCommand: Executing Task");
                for (int i = 1; i <= 10 ; i++) {
                    final int progress = i;
                    Log.d(TAG, "onStartCommand: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MyService.this, "Task Completed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        thread.start();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Service Destroyed");
    }
}











