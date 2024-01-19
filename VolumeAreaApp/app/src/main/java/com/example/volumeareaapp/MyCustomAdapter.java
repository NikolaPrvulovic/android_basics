package com.example.volumeareaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.volumeareaapp.model.Shape;

import java.util.ArrayList;

// This class will be responsible for creating
// the view for each item and binding data to it
public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapeArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Shape> shapeArrayList, Context context) {
        super(context, R.layout.grid_item_layout, shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context;
    }

    // View Holder: Used to cache references to the views within an item layout
    private static class MyViewHolder{
        TextView shapeName;
        ImageView shapeImg;
    }

    // GetView(): Used to create and return a view for a specific item in Grid
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // 1 - Get the shape object for the current position
        Shape shapes = getItem(position);

        // 2 - Inflating Layout
        MyViewHolder myViewHolder;

        if (convertView == null){
            // We need to convert new View for an item - no View went off-screen --> Create a new View
            myViewHolder = new MyViewHolder();
            // Utility class that is use to instantiate XML Layout files and convert them to a corresponding
            // View object
            LayoutInflater inflater = LayoutInflater.from(getContext());

            // Inflate a XML Layout file to create a View object
            convertView = inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false
            );

            // Finding the Views
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView);
            myViewHolder.shapeImg = (ImageView) convertView.findViewById(R.id.imageView);

            // Tag methods are used to attach and retrieve custom data objects to individual Views
            // within a layout. Useful when working with ListView, GridView, RecycleView when
            // you need to associate data with Views efficiently
            convertView.setTag(myViewHolder);

        } else {
            // There is a View that went off the screen and can be reused
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        // Getting the data from the model class (Shape)
        assert shapes != null;
        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImg.setImageResource(shapes.getShapeImg());

        return convertView;
    }
}
