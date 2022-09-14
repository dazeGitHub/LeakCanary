package com.example.leakcanary

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import com.squareup.leakcanary.LeakCanary

class App : Application() {

    companion object {
        @JvmStatic
        @SuppressLint("StaticFieldLeak")
        lateinit var currentActivity: Activity
    }

    override fun onCreate() {
        super.onCreate()
        if(LeakCanary.isInAnalyzerProcess(this)){
            return
        }
        LeakCanary.install(this)
    }
}