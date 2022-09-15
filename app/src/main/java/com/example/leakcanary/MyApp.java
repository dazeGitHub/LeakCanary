package com.example.leakcanary;

import android.app.Activity;
import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class MyApp extends Application {

    static Activity currentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }
}
