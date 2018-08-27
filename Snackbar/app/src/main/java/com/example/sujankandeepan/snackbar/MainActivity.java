package com.example.sujankandeepan.snackbar;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton button;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(view, "Hello Snackbar!", Snackbar.LENGTH_LONG).show();
                snackbar = Snackbar.make(v, "Message sent!", Snackbar.LENGTH_INDEFINITE);
                snackbar.setDuration(3000);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,
                                "Message discarded", Toast.LENGTH_SHORT).show();
                    }
                });

                View view = snackbar.getView();
                view.setBackgroundColor(getResources().getColor(R.color.colorSnackbarBackground));

                TextView snackbarText = view.findViewById(android.support.design.R.id.snackbar_text);
                snackbarText.setTextColor(getResources().getColor(R.color.colorSnackbarText));

                TextView snackbarAction = view.findViewById(android.support.design.R.id.snackbar_action);
                snackbarAction.setTextColor(getResources().getColor(R.color.colorSnackbarAction));

                snackbar.show();
                //snackbar.dismiss();
            }
        });
    }
}
