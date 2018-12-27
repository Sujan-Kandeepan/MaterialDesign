package com.example.sujankandeepan.timepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    TextView timeTextView;
    AppCompatButton timeButton;
    Calendar calendar;
    TimePickerDialog timePickerDialog;
    TimePickerDialog finalPicker;
    Boolean time24HourMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTextView = findViewById(R.id.time_text_view);
        timeButton = findViewById(R.id.time_button);

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();

                int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                int currentMinute = calendar.get(Calendar.MINUTE);
                int currentSecond = calendar.get(Calendar.SECOND);

                timePickerDialog = TimePickerDialog.newInstance(MainActivity.this,
                        currentHour, currentMinute, currentSecond, time24HourMode);
                timePickerDialog.setAccentColor(getResources().getColor(R.color.colorPrimary));
                timePickerDialog.setTitle("Time Picker");
                timePickerDialog.setThemeDark(true);
                timePickerDialog.dismissOnPause(false);
                timePickerDialog.setOkText("OK");
                timePickerDialog.setCancelText("CANCEL");
                timePickerDialog.enableSeconds(true);
                timePickerDialog.show(getSupportFragmentManager(), "timePicker");
                timePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(MainActivity.this, "Cancelled",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                timePickerDialog.setOnTimeSetListener(new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                        Toast.makeText(MainActivity.this, "Time set",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        finalPicker = (TimePickerDialog) getSupportFragmentManager().findFragmentByTag("timePicker");
        if (finalPicker != null) finalPicker.setOnTimeSetListener(this);
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String hour = (hourOfDay < 10 ? "0" : "") + hourOfDay;
        String min = (minute < 10 ? "0" : "") + minute;
        String sec = (second < 10 ? "0" : "") + second;
        String time = "You picked the following time: " + hour + ":" + min + ":" + sec;
        timeTextView.setText(time);
    }
}
