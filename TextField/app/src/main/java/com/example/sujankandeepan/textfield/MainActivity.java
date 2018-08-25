package com.example.sujankandeepan.textfield;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    AppCompatEditText username;
    AppCompatEditText password;
    TextInputLayout usernameLayout;
    TextInputLayout passwordLayout;

    private void usernameEmpty() {
        if (Objects.requireNonNull(username.getText()).toString().isEmpty()) {
            usernameLayout.setErrorEnabled(true);
            usernameLayout.setError("Please enter your username!");
        } else {
            usernameLayout.setErrorEnabled(false);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.activity_main);
        relativeLayout.setOnClickListener(null);

        username = findViewById(R.id.username_TextField);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // do something just before text changed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // do something as text is changed
                usernameEmpty();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // do something after text is changed
            }
        });
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // do something when text field gains or loses focus
                if (!hasFocus) usernameEmpty();
            }
        });

        password = findViewById(R.id.password_TextField);

        usernameLayout = findViewById(R.id.username_TextInputLayout);

        passwordLayout = findViewById(R.id.password_TextInputLayout);
        passwordLayout.setCounterEnabled(true);
        passwordLayout.setCounterMaxLength(8);
    }
}
