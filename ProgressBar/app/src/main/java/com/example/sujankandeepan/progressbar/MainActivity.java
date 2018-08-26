package com.example.sujankandeepan.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar1;
    ProgressBar progressBar2;

    Handler handler;
    Runnable runnable;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progress_bar_1);
        progressBar1.setVisibility(View.VISIBLE);

        progressBar2 = findViewById(R.id.progress_bar_2);
        progressBar2.setVisibility(View.VISIBLE);
        progressBar2.setProgress(0);
        progressBar2.setSecondaryProgress(0);
        progressBar2.setMax(100);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                if (progressBar2.getProgress() < 100)
                    progressBar2.setProgress(progressBar2.getProgress() + 5);
                else timer.cancel();

                if (progressBar2.getSecondaryProgress() < 100)
                    progressBar2.setSecondaryProgress(progressBar2.getSecondaryProgress() + 10);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 3000, 1000);
    }
}
