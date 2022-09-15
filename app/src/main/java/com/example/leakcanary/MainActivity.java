package com.example.leakcanary;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
