package com.example.leakcanary;

import android.app.Activity;
import android.app.Application;

//import com.squareup.leakcanary.LeakCanary;

public class MyApp extends Application {

    static Activity currentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        //LeakCanary 有部分代码运行在一个独立的进程中, 所以 onCreate() 会在另外一个进程中再次被调用,
        //为了防止再另外的进程再次初始化, 所以在调用 LeakCanary.install(this) 前先判断,
        //如果是 LeakCanary 自己的进程, 那么就不需要初始化了
//        if(LeakCanary.isInAnalyzerProcess(this)){
//            return;
//        }
//        LeakCanary.install(this);
    }
}
