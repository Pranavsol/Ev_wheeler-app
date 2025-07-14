package com.example.evwheeler;

import static com.example.evwheeler.FindEv.CheckRange;
import static com.example.evwheeler.R.layout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.Arrays;

public class ListPage extends AppCompatActivity {

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_list_page);

        FindEv obj = new FindEv();
        Intent intent = getIntent();

        int orp = intent.getIntExtra("MainActivity.orp", 0);
        double mileage = intent.getDoubleExtra("MainActivity.mileage", 0);
        int commute = intent.getIntExtra("MainActivity.commute", 0);

        int[] indexlist = obj.CheckRange(commute);
        int[] finallist;

        try {
            finallist = obj.Calcprice(indexlist, orp, mileage, commute);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int max,fl[] = new int[5];
        for (int i = 0; i < 5; i++) {
            max = 100;
            for (int j = 0; j < 10; j++) {
                if(finallist[j] < max){
                    max = finallist[j];
                    finallist[j] = 100;
                    fl[i] = j;
                }
            }
        }

        String[] names = {"Ola S1 Pro Gen 1", "Ola S1 Pro Gen 2", "Ola S1 Air", "Ola S1 X", "Ola S1 X", "Ola S1 X +", "TVS IQube", "TVS IQube S", "TVS IQube ST", "Aether 450X 2.9kWh", "Aether 450X 3.7kWh", "Aether 450 S", "Aether 450  S Pro Pack", "Bajaj Chetak Premium", "Bajaj Chetak Premium 2023", "Vida V1 Pro", "Joy Mihos", "Joy Glob", "Joy Monster", "Joy Wolf", "Joy Gen Nxt", "Simple One", "Okaya Faast", "Okaya Faast F3", "Okaya Freedum", "Okaya Faast F2T", "Okaya ClassIQ", "Okaya Faast F2B", "Okaya Faast F2F"};

        TextView textView = findViewById(R.id.textView5);
        TextView textView1 = findViewById(R.id.textView6);
        TextView textView2 = findViewById(R.id.textView7);
        TextView textView3 = findViewById(R.id.textView8);
        TextView textView4 = findViewById(R.id.textView9);

        textView.setText(names[indexlist[fl[0]]]);
        textView1.setText(names[indexlist[fl[1]]]);
        textView2.setText(names[indexlist[fl[2]]]);
        textView3.setText(names[indexlist[fl[3]]]);
        textView4.setText(names[indexlist[fl[4]]]);

    }
}