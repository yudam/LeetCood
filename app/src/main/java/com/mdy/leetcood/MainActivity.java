package com.mdy.leetcood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ExecutorService fixThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        fixThread = new ThreadPoolExecutor(3, 10, 20,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 100; i++) {
            fixThread.execute(new Runnable() {
                @Override
                public void run() {
                    Log.i("MDY", "run:" + Thread.currentThread().getName());
                }
            });
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void btn1(View view) {
        fixThread.shutdown();
    }

    /**
     * 队尾插入，队头删除，add pop
     */
}
