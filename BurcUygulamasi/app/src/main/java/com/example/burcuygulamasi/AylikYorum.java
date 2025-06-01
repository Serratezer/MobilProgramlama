package com.example.burcuygulamasi;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AylikYorum extends AppCompatActivity {

    TextView textViewZodiac, textViewMonthlyComment;
    Button buttonBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aylik_yorum);

        textViewZodiac = findViewById(R.id.textViewZodiac);
        textViewMonthlyComment = findViewById(R.id.textViewMonthlyComment);
        buttonBack = findViewById(R.id.buttonBack);

        SharedPreferences sharedPreferences = getSharedPreferences("BurcData", MODE_PRIVATE);
        String zodiac = sharedPreferences.getString("zodiacSign", "Bilinmiyor");

        String monthlyComment = getMonthlyComment(zodiac);

        textViewZodiac.setText("Burcunuz: " + zodiac);
        textViewMonthlyComment.setText(monthlyComment);

        buttonBack.setOnClickListener(v -> finish());
    }

    private String getMonthlyComment(String zodiac) {
        switch (zodiac) {
            case "Koç":
                return "Bu ay enerjinizi kariyerinize yönlendirin.";
            case "Boğa":
                return "Maddi konularda fırsatlarla karşılaşabilirsiniz.";
            case "İkizler":
                return "Yeni sosyal çevrelere dahil olabilirsiniz.";
            case "Yengeç":
                return "Ailevi konular ön planda olabilir.";
            case "Aslan":
                return "Yaratıcılığınız sizi yeni projelere yönlendirecek.";
            case "Başak":
                return "Sağlıkla ilgili adımlar atmak için uygun bir ay.";
            case "Terazi":
                return "İlişkilerinizde uyum yakalayabilirsiniz.";
            case "Akrep":
                return "Duygusal derinlikler sizi bekliyor.";
            case "Yay":
                return "Eğitim ve seyahat planları yapabilirsiniz.";
            case "Oğlak":
                return "Hedefleriniz doğrultusunda ilerleyin.";
            case "Kova":
                return "Toplumsal konulara duyarlılığınız artabilir.";
            case "Balık":
                return "Hayal gücünüzle üretken bir ay geçireceksiniz.";
            default:
                return "Burç bilgisi bulunamadı. Lütfen önce burcunuzu hesaplayın.";
        }
    }
}
