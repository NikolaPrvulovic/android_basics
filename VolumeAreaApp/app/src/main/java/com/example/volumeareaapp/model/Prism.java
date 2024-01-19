package com.example.volumeareaapp.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.volumeareaapp.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Prism extends AppCompatActivity {

    EditText prism_sideA, prism_sideB, prism_height;
    TextView title, result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);

        prism_sideA = findViewById(R.id.editText_prism_sideA);
        prism_sideB = findViewById(R.id.editText_prism_sideB);
        prism_height = findViewById(R.id.editText_prism_height);
        title = findViewById(R.id.prismVolume);
        result = findViewById(R.id.result);
        button = findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = prism_sideA.getText().toString();
                String b = prism_sideB.getText().toString();
                String h = prism_height.getText().toString();

                if(a.isEmpty() || b.isEmpty() || h.isEmpty()) {

                    result.setText("Morate popuniti sva polja.");

                } else {
                    try {

                        double sideA = Double.parseDouble(a);
                        double sideB = Double.parseDouble(b);
                        double height = Double.parseDouble(h);

                        double volume = sideA * sideB * height;

                        BigDecimal bd = BigDecimal.valueOf(volume);
                        bd = bd.setScale(6, RoundingMode.HALF_UP);
                        bd = bd.stripTrailingZeros();

                        DecimalFormat decimalFormat = new DecimalFormat("#,###.######");
                        String formattedVolume = decimalFormat.format(bd.doubleValue());


                        result.setText("V = " + formattedVolume + " m^3");
                    } catch (NumberFormatException e){
                        result.setText("Unesite validne brojeve.");
                    }
                }

                closeKeyboard(v);

                prism_sideA.setText("");
                prism_sideB.setText("");
                prism_height.setText("");

            }
        });
    }
    public void closeKeyboard(View view) {

        // Get InputMethodManager
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        // Close Keyboard
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }
}