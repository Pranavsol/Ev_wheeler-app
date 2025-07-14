package com.example.evwheeler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findev (View view) {
        Intent intent = new Intent(this, ListPage.class);

        EditText et1 = findViewById(R.id.editTextText);
        EditText et2 = findViewById(R.id.editTextText2);
        EditText et3 = findViewById(R.id.editTextText3);

        int orp = Integer.parseInt(et1.getText().toString());
        double mileage = Double.parseDouble(et2.getText().toString());
        int commute = Integer.parseInt(et3.getText().toString());

        intent.putExtra("MainActivity.orp", orp);
        intent.putExtra("MainActivity.mileage", mileage);
        intent.putExtra("MainActivity.commute", commute);

        startActivity(intent);
    }
}