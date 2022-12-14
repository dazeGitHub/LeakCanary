package com.example.leakcanary;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.e("MainActivity", "finalize");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //因为执行 onDestroy() 的时候 Activity 还没有被回收, 所以这里开启个线程, 过一会再 GC
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Runtime.getRuntime().gc();
            }
        }).start();
    }

    public void leak(View view){
        MyApp.currentActivity = this;
    }

    public void finish(View view) {
        finish();
    }
}
