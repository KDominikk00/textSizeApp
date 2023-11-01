package com.example.textsizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textSize;
    SeekBar pasek;
    Button btn;
    TextView rozmiar;

    int current = 0;

    String[] greetings = {"Dzień dobry", "Hello", "Buenos Dias"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSize = findViewById(R.id.textSize);
        pasek = findViewById(R.id.pasek);
        btn = findViewById(R.id.btn);
        rozmiar = findViewById(R.id.rozmiar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current +=1;
                if(current > greetings.length -1){
                    current = 0;
                }
                textSize.setText(greetings[current]);
            }
        });
        pasek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int prog = seekBar.getProgress();
                textSize.setTextSize(prog);
                rozmiar.setText("Rozmiar: " + prog);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}