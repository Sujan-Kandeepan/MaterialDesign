package com.example.sujankandeepan.progressdialog2;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;

    Handler handler;
    Runnable runnable;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(MainActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setIndeterminate(false);
        dialog.setTitle("Progress Dialog");
        dialog.setMessage("Please wait...");
        dialog.show();
        dialog.setProgress(0);
        dialog.setMax(100);
        //dialog.cancel();

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                if (dialog.getProgress() < 100) dialog.setProgress(dialog.getProgress() + 10);
                else {
                    timer.cancel();
                    dialog.cancel();
                }
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
