package com.example.sujankandeepan.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_button_1) Toast.makeText(MainActivity.this,
                        "Radio button 1 checked", Toast.LENGTH_SHORT).show();
                if (checkedId == R.id.radio_button_2) Toast.makeText(MainActivity.this,
                        "Radio button 2 checked", Toast.LENGTH_SHORT).show();
                if (checkedId == R.id.radio_button_3) Toast.makeText(MainActivity.this,
                        "Radio button 3 checked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
