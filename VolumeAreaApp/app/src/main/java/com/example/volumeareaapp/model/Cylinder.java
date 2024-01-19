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

public class Cylinder extends AppCompatActivity {

    EditText cylinder_radius, cylinder_height;
    TextView title, result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        cylinder_radius = findViewById(R.id.editText_cylinder_radius);
        cylinder_height = findViewById(R.id.editText_cylinder_height);
        title = findViewById(R.id.cylinderVolume);
        result = findViewById(R.id.result);
        button = findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String radius = cylinder_radius.getText().toString();
                String height = cylinder_height.getText().toString();

                if(radius.isEmpty() || height.isEmpty()) {

                    result.setText("Morate popuniti sva polja.");

                } else {
                    try {

                        double r = Double.parseDouble(radius);
                        double h = Double.parseDouble(height);

                        double volume = Math.PI * (r * r) * h;

                        BigDecimal bd = BigDecimal.valueOf(volume);
                        bd = bd.setScale(6, RoundingMode.HALF_UP);
                        bd = bd.stripTrailingZeros();

                        DecimalFormat decimalFormat = new DecimalFormat("#,###.######");
                        String formattedVolume = decimalFormat.format(bd.doubleValue());


                        result.setText("V = " + formattedVolume + " m^3");
                    }catch (NumberFormatException e){
                        result.setText("Unesite validne brojeve.");
                    }
                }

                closeKeyboard(v);

                cylinder_radius.setText("");
                cylinder_height.setText("");
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