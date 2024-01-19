package com.example.weightconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting the user input
                String inputText = editText.getText().toString();


                // Converting a string into double
                double kilos = Double.parseDouble(inputText);

                // Display the conversion result
                textView.setText(String.valueOf(makeConversion(kilos)));
            }
        });

    }


    public double makeConversion(double kilos){
        // 1 kilo = 2.20462 pounds

        return kilos * 2.20462;
    }
}