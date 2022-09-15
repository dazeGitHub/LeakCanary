//package com.example.leakcanary
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import java.lang.Thread.sleep
//import kotlin.concurrent.thread
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//
//    protected fun finalize() {
//        Log.e("MainActivity", "finalize");
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        thread {
//            sleep(200)
//            Runtime.getRuntime().gc()
//        }
//    }
//
//    fun leak(view: View){
//        MyApp.currentActivity = this
//    }
//
//    fun finish(view: View){
//        finish()
//    }
//}