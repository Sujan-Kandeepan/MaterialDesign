package com.example.sujankandeepan.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) finish();
        if (id == R.id.search) Toast.makeText(getApplicationContext(),
                "Search selected", Toast.LENGTH_SHORT).show();
        if (id == R.id.cart) Toast.makeText(getApplicationContext(),
                "Cart selected", Toast.LENGTH_SHORT).show();
        if (id == R.id.item1) Toast.makeText(getApplicationContext(),
                "Item 1 selected", Toast.LENGTH_SHORT).show();
        if (id == R.id.item2) Toast.makeText(getApplicationContext(),
                "Item 2 selected", Toast.LENGTH_SHORT).show();
        if (id == R.id.item3) Toast.makeText(getApplicationContext(),
                "Item 3 selected", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
