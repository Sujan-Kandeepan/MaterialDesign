package com.example.sujankandeepan.button;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatButton raisedButton;
    AppCompatButton flatButton;
    FloatingActionButton faButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        raisedButton = findViewById(R.id.raised_btn);
        raisedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Raised button clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        flatButton = findViewById(R.id.flat_btn);
        flatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Flat button clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        faButton = findViewById(R.id.fa_btn);
        faButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "FA button clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
