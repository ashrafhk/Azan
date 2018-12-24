package com.example.muhammadsadiq.azaantest;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class Tasbih extends AppCompatActivity {

    // Vibrator 1
    Vibrator mVibrator;
    Window window;
    ImageButton btnVibrate;
    ImageButton restz;
    boolean isTureVibrator =true;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih);

        final TextView myTextView = (TextView) findViewById(R.id.textAdd);

        ImageButton btnVibrate=(ImageButton)findViewById(R.id.CountAdd);
        final ImageButton resftz = (ImageButton)findViewById(R.id.restz);
        final ImageButton BTureVibrator = (ImageButton)findViewById(R.id.addvibrator);
        // Vibrator 2
        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        btnVibrate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Vibrates 3 : for 100 Milliseconds
                if(isTureVibrator){ mVibrator.vibrate(100);}
                count++;
                myTextView.setText( ""+count);

            }
        });

        resftz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Vibrates 3 : for 100 Milliseconds
                if(isTureVibrator){
                    mVibrator.vibrate(100);}
                count = 0;
                myTextView.setText( ""+count);
            }
        });

        BTureVibrator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Vibrates 3 : for 100 Milliseconds
                mVibrator.vibrate(100);
                if(isTureVibrator){
                    isTureVibrator=false;
                    BTureVibrator.setImageResource(R.drawable.ic_smartphone);
                    BTureVibrator.getLayoutParams().height = 160;
                }
                else {
                    isTureVibrator=true;
                    BTureVibrator.setImageResource(R.drawable.ic_vibration);
                    BTureVibrator.getLayoutParams().height = 160;
                }
            }
        });
    }
}