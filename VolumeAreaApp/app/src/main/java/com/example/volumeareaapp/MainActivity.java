package com.example.volumeareaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.volumeareaapp.model.Cube;
import com.example.volumeareaapp.model.Cylinder;
import com.example.volumeareaapp.model.Prism;
import com.example.volumeareaapp.model.Shape;
import com.example.volumeareaapp.model.Sphere;

import java.util.ArrayList;
import java.util.Arrays;

import kotlin.random.Random;

public class MainActivity extends AppCompatActivity {

    // 1 - AdapterView: GridView
    GridView gridView;

    // 2 - Data Source: ArrayList<Shape>
    ArrayList<Shape> shapeArrayList;

    // 3 - Adapter: MyCustomAdapter
    MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        shapeArrayList = new ArrayList<>();

        Shape s1 = new Shape(R.drawable.sphere, "Lopta");
        Shape s2 = new Shape(R.drawable.cylinder, "Valjak");
        Shape s3 = new Shape(R.drawable.cube, "Kocka");
        Shape s4 = new Shape(R.drawable.prism, "Prizma");

        shapeArrayList.addAll(Arrays.asList(s1, s2, s3, s4));

        myCustomAdapter = new MyCustomAdapter(shapeArrayList, getApplicationContext());

        gridView.setAdapter(myCustomAdapter);
        // Number of columns can also be set in activity_main.xml by adding
        // android:numColumns="2" in GridView
        gridView.setNumColumns(2);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Shape selectedShape = shapeArrayList.get(position);

                Intent i;
                switch (selectedShape.getShapeName()){
                    case ("Lopta"):
                        i = new Intent(getApplicationContext(), Sphere.class);
                        break;
                    case ("Valjak"):
                        i = new Intent(getApplicationContext(), Cylinder.class);
                        break;
                    case ("Kocka"):
                        i = new Intent(getApplicationContext(), Cube.class);
                        break;
                    case ("Prizma"):
                        i = new Intent(getApplicationContext(), Prism.class);
                        break;
                    default:
                        i = new Intent(getApplicationContext(), Random.Default.class);
                }
                startActivity(i);
            }
        });

    }
}