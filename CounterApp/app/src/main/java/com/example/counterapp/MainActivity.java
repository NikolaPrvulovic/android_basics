package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView welcome_text, counter_text;
    Button btn, btn_reset;


    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn_reset = findViewById(R.id.btn_reset);
        counter_text = findViewById(R.id.counterTextView);
        welcome_text = findViewById(R.id.welcome_text);


        // Adding the functionalities
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               counter_text.setText(String.valueOf(increaseCounter()));
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                counter_text.setText(String.valueOf(counter));
            }
        });
    }

    public int increaseCounter(){
        return ++counter;
    }
}