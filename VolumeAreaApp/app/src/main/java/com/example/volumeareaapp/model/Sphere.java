package com.example.volumeareaapp.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.volumeareaapp.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Sphere extends AppCompatActivity {

    EditText sphere_radius;
    TextView title, result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        sphere_radius = findViewById(R.id.editText_sphere);
        title = findViewById(R.id.sphereVolume);
        result = findViewById(R.id.result);
        button = findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String radius = sphere_radius.getText().toString();

                if(radius.isEmpty()) {

                    result.setText("Morate popuniti polje.");

                } else {
                    try {

                        double r = Double.parseDouble(radius);

                        // V = (4/3) * pi * r^3

                        double volume = (4 * Math.PI * (r * r * r)) / 3;

                        BigDecimal bd = BigDecimal.valueOf(volume);
                        bd = bd.setScale(6, RoundingMode.HALF_EVEN);
                        bd = bd.stripTrailingZeros();

                        DecimalFormat decimalFormat = new DecimalFormat("#,###.######");
                        String formattedVolume = decimalFormat.format(bd.doubleValue());


                        result.setText("V = " + formattedVolume + " m^3");
                    } catch (NumberFormatException e){
                        result.setText("Unesite validan broj.");
                    }
                }

                closeKeyboard(v);

                sphere_radius.setText("");

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