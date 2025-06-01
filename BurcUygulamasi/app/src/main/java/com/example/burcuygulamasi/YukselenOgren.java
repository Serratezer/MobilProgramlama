package com.example.burcuygulamasi;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class YukselenOgren extends AppCompatActivity {

    EditText editDay, editMonth, editYear, editHour;
    Button buttonCalculate;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yukselen_ogren);

        editDay = findViewById(R.id.editDay);
        editMonth = findViewById(R.id.editMonth);
        editYear = findViewById(R.id.editYear);
        editHour = findViewById(R.id.editHour);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(v -> {
            String hourStr = editHour.getText().toString().trim();
            if (hourStr.isEmpty()) {
                textViewResult.setText("Lütfen doğum saatinizi girin.");
                return;
            }

            int hour = Integer.parseInt(hourStr);
            String yukselen = getYukselenByHour(hour);
            textViewResult.setText("Yükselen burcunuz: " + yukselen);
        });
        Button btnGDon = new Button(this);
        btnGDon.setText("Geri Dön");
        btnGDon.setBackgroundColor(Color.parseColor("#AA00FF")); // mor tonlarında bir geri buton
        btnGDon.setTextColor(Color.WHITE);

        btnGDon.setOnClickListener(v -> {
            finish(); // önceki aktiviteye döner
        });
    }

    private String getYukselenByHour(int hour) {
        if (hour >= 6 && hour < 8) return "Koç";
        if (hour >= 8 && hour < 10) return "Boğa";
        if (hour >= 10 && hour < 12) return "İkizler";
        if (hour >= 12 && hour < 14) return "Yengeç";
        if (hour >= 14 && hour < 16) return "Aslan";
        if (hour >= 16 && hour < 18) return "Başak";
        if (hour >= 18 && hour < 20) return "Terazi";
        if (hour >= 20 && hour < 22) return "Akrep";
        if (hour >= 22 || hour < 0) return "Yay";
        if (hour >= 0 && hour < 2) return "Oğlak";
        if (hour >= 2 && hour < 4) return "Kova";
        if (hour >= 4 && hour < 6) return "Balık";
        return "Bilinmiyor";
    }
}
