package com.example.burcuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Secenekler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secenekler);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Buton tanımlama ve tıklama olayını ekleme
        Button btnZodiac = findViewById(R.id.btnZodiac);

        btnZodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Secenekler.this, Burc_Ogren.class);
                startActivity(intent);
            }

        });
        Button btnDailyHoroscope = findViewById(R.id.btnDaily);

        btnDailyHoroscope.setOnClickListener(v -> {
            Intent intent = new Intent(Secenekler.this, GunlukYorum.class);
            startActivity(intent);
        });

        Button btnMonthly = findViewById(R.id.btnMonthly);
        btnMonthly.setOnClickListener(v -> {
            Intent intent = new Intent(Secenekler.this, AylikYorum.class);
            startActivity(intent);
        });

        Button btnWeeklyHoroscope = findViewById(R.id.btnWeekly);

        btnWeeklyHoroscope.setOnClickListener(v -> {
            Intent intent = new Intent(Secenekler.this, HaftalikYorum.class);
            startActivity(intent);
        });


    }
}
