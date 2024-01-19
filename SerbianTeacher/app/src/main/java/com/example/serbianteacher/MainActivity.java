package com.example.serbianteacher;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button blackBtn, greenBtn, purpleBtn, redBtn, yellowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        blackBtn = findViewById(R.id.blackBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        greenBtn = findViewById(R.id.greenBtn);
        redBtn = findViewById(R.id.redBtn);
        purpleBtn = findViewById(R.id.purpleBtn);


        blackBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        redBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        int clickedBtnId = v.getId();

        if(clickedBtnId == R.id.blackBtn){
            playSounds(R.raw.black);
        }else if(clickedBtnId == R.id.greenBtn){
            playSounds(R.raw.green);
        }else if(clickedBtnId == R.id.purpleBtn){
            playSounds(R.raw.purple);
        }else if(clickedBtnId == R.id.redBtn){
            playSounds(R.raw.red);
        }else if(clickedBtnId == R.id.yellowBtn){
            playSounds(R.raw.yellow);
        }
    }

    public void playSounds(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();
    }
}