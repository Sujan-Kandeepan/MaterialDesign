package com.example.sujankandeepan.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView dateTextView;
    AppCompatButton dateButton;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    DatePickerDialog finalPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTextView = findViewById(R.id.date_text_view);
        dateButton = findViewById(R.id.date_button);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();

                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                int currentMonth = calendar.get(Calendar.MONTH);
                int currentYear = calendar.get(Calendar.YEAR);

                datePickerDialog = DatePickerDialog.newInstance(MainActivity.this,
                        currentYear, currentMonth, currentDay);
                datePickerDialog.setAccentColor(getResources().getColor(R.color.colorPrimary));
                datePickerDialog.setTitle("Date Picker");
                datePickerDialog.setThemeDark(true);
                datePickerDialog.dismissOnPause(false);
                datePickerDialog.setOkText("OK");
                datePickerDialog.setCancelText("CANCEL");
                datePickerDialog.showYearPickerFirst(true);
                datePickerDialog.show(getSupportFragmentManager(), "datePicker");
                datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(MainActivity.this, "Cancelled",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        Toast.makeText(MainActivity.this, "Date set",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        finalPicker = (DatePickerDialog) getSupportFragmentManager().findFragmentByTag("datePicker");
        if (finalPicker != null) finalPicker.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String date = "You picked the following date: " + (++monthOfYear)
                + "/" + dayOfMonth + "/" + year;
        dateTextView.setText(date);
    }
}
