package com.example.burcuygulamasi;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Burc_Ogren extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Ana layout oluşturma
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(50, 50, 50, 50);
        mainLayout.setGravity(Gravity.CENTER);
        mainLayout.setBackgroundResource(R.drawable.background);

        // EditText (Gün)
        EditText etDay = new EditText(this);
        etDay.setHint("Gün (1-31)");
        etDay.setTextColor(Color.WHITE); // Kullanıcının yazdığı metin
        etDay.setHintTextColor(Color.WHITE); // Hint metni
        etDay.setGravity(Gravity.CENTER);
        mainLayout.addView(etDay);

        // EditText (Ay)
        EditText etMonth = new EditText(this);
        etMonth.setHint("Ay (1-12)");
        etMonth.setTextColor(Color.WHITE); // Kullanıcının yazdığı metin
        etMonth.setHintTextColor(Color.WHITE); // Hint metni
        etMonth.setGravity(Gravity.CENTER);
        mainLayout.addView(etMonth);

        // Hesaplama Butonu
        Button btnCalculate = new Button(this);
        btnCalculate.setText("Burcumu Hesapla");
        mainLayout.addView(btnCalculate);

        // Sonuç Gösterme Alanı
        TextView tvResult = new TextView(this);
        tvResult.setTextSize(18);
        tvResult.setTextColor(Color.WHITE);
        tvResult.setGravity(Gravity.CENTER);
        mainLayout.addView(tvResult);

        // Geri Dön Butonu
        Button btnBack = new Button(this);
        btnBack.setText("Geri Dön");
        btnBack.setBackgroundColor(Color.parseColor("#AA00FF")); // mor tonlarında bir geri buton
        btnBack.setTextColor(Color.WHITE);
        mainLayout.addView(btnBack);

        btnBack.setOnClickListener(v -> {
            finish(); // önceki aktiviteye döner
        });



        // Buton tıklanınca burç hesaplama
        btnCalculate.setOnClickListener(v -> {
            String dayStr = etDay.getText().toString();
            String monthStr = etMonth.getText().toString();

            if (!dayStr.isEmpty() && !monthStr.isEmpty()) {
                try {
                    int day = Integer.parseInt(dayStr);
                    int month = Integer.parseInt(monthStr);

                    if (isValidDate(day, month)) {
                        String burc = getZodiacSign(day, month);
                        tvResult.setText("Burcunuz: " + burc);

                        // BURCU KAYDET
                        SharedPreferences sharedPreferences = getSharedPreferences("BurcData", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("zodiacSign", burc);
                        editor.apply();

                    } else {
                        tvResult.setText("Geçersiz tarih! Lütfen doğru bir gün ve ay girin.");
                    }
                } catch (NumberFormatException e) {
                    tvResult.setText("Lütfen geçerli bir sayı girin!");
                }
            } else {
                tvResult.setText("Lütfen tüm alanları doldurun!");
            }
        });


        // Ana layout'u ekrana set et
        setContentView(mainLayout);
    }

    // Burç hesaplama fonksiyonu
    private String getZodiacSign(int day, int month) {
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) return "Kova";
        if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) return "Balık";
        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) return "Koç";
        if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) return "Boğa";
        if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) return "İkizler";
        if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) return "Yengeç";
        if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) return "Aslan";
        if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) return "Başak";
        if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) return "Terazi";
        if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) return "Akrep";
        if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) return "Yay";
        if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) return "Oğlak";
        return "Geçersiz tarih!";
    }

    // Geçerli tarih olup olmadığını kontrol eden fonksiyon
    private boolean isValidDate(int day, int month) {
        if (month < 1 || month > 12 || day < 1 || day > 31) return false;

        // Ayların gün sayısı
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Şubat ayı ve artık yıl kontrolü
        if (month == 2) {
            return day <= 29;
        }

        return day <= daysInMonth[month];


    }

}
