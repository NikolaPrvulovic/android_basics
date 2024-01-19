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

public class Cube extends AppCompatActivity {

    EditText cube_side;
    TextView title, result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        cube_side = findViewById(R.id.editText_cube);
        title = findViewById(R.id.cubeVolume);
        result = findViewById(R.id.result);
        button = findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String side = cube_side.getText().toString();

                if(side.isEmpty()) {

                    result.setText("Morate popuniti polje.");

                } else {
                    try {

                        double s = Double.parseDouble(side);

                        double volume = s * s * s;

                        BigDecimal bd = BigDecimal.valueOf(volume);
                        bd = bd.setScale(6, RoundingMode.HALF_UP);
                        bd = bd.stripTrailingZeros();

                        DecimalFormat decimalFormat = new DecimalFormat("#,###.######");
                        String formattedVolume = decimalFormat.format(bd.doubleValue());


                        result.setText("V = " + formattedVolume + " m^3");
                    } catch (NumberFormatException e){
                        result.setText("Unesite validan broj.");
                    }
                }

                closeKeyboard(v);

                cube_side.setText("");
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