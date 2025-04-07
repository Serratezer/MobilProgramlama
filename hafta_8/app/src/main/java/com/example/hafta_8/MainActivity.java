package com.example.hafta_8;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    int oran1 = 0, oran2 = 0, oran3 = 0; // 🔹 Global değişkenler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        SeekBar sb1 = findViewById(R.id.seekBar1);
        SeekBar sb2 = findViewById(R.id.seekBar2);
        SeekBar sb3 = findViewById(R.id.seekBar3);

        TextView txt1 = findViewById(R.id.textView1);
        TextView txt2 = findViewById(R.id.textView2);
        TextView txt3 = findViewById(R.id.textView3);

        ConstraintLayout arkarenk = findViewById(R.id.arkaplan);

        sb1.setMax(255);
        sb2.setMax(255);
        sb3.setMax(255);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                oran1 = i;
                int renk = Color.rgb(oran1, oran2, oran3);
                arkarenk.setBackgroundColor(renk);
                txt1.setText(String.valueOf(i));
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                oran2 = i;
                int renk = Color.rgb(oran1, oran2, oran3);
                arkarenk.setBackgroundColor(renk);
                txt2.setText(String.valueOf(i));
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                oran3 = i;
                int renk = Color.rgb(oran1, oran2, oran3);
                arkarenk.setBackgroundColor(renk);
                txt3.setText(String.valueOf(i));
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
