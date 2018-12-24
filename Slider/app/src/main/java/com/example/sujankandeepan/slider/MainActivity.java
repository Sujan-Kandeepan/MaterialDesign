package com.example.sujankandeepan.slider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.appyvet.materialrangebar.RangeBar;

public class MainActivity extends AppCompatActivity {

    AppCompatSeekBar seekBar;
    TextView seekBarValue;

    RangeBar rangeBar1;
    TextView rangeBar1Value;

    RangeBar rangeBar2;
    TextView rangeBar2LeftValue;
    TextView rangeBar2RightValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seek_bar);
        seekBarValue = findViewById(R.id.seek_bar_value);
        rangeBar1 = findViewById(R.id.range_bar_1);
        rangeBar1Value = findViewById(R.id.range_bar_1_value);
        rangeBar2 = findViewById(R.id.range_bar_2);
        rangeBar2LeftValue = findViewById(R.id.range_bar_2_left_value);
        rangeBar2RightValue = findViewById(R.id.range_bar_2_right_value);

        seekBar.setProgress(0); // default value
        seekBar.setKeyProgressIncrement(1); // step value
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seek bar touched",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seek bar released",
                        Toast.LENGTH_SHORT).show();
            }
        });

        rangeBar1.setSeekPinByIndex(0);
        rangeBar1.setPinTextColor(getResources().getColor(R.color.colorRangeBarText));
        rangeBar1.setSelectorColor(getResources().getColor(R.color.colorAccent));
        rangeBar1.setTickColor(getResources().getColor(R.color.colorAccent));
        rangeBar1.setConnectingLineColor(getResources().getColor(R.color.colorPrimary));
        //rangeBar1.setBarColor(getResources().getColor(R.color.colorAccent));
        rangeBar1.setPinColor(getResources().getColor(R.color.colorPrimary));
        rangeBar1.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex, String leftPinValue,
                                              String rightPinValue) {
                rangeBar1Value.setText(String.valueOf(rightPinValue));
            }
        });

        rangeBar2.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex, String leftPinValue,
                                              String rightPinValue) {
                rangeBar2LeftValue.setText(String.valueOf(leftPinValue));
                rangeBar2RightValue.setText(String.valueOf(rightPinValue));
            }
        });
    }
}
