package com.mdy.leetcood;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            Log.i("MDY", "handleMessage");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1(View view) {

        new TestThread().start();
    }

    class TestThread extends Thread {
        @Override
        public void run() {
            super.run();
            Log.i("MDY", "run---1");
            Looper.prepare();
            Log.i("MDY", "run---2");
            Looper.loop();
            Log.i("MDY", "run---3");
        }
    }
}
