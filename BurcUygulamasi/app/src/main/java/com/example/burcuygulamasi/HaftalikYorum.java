package com.example.burcuygulamasi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HaftalikYorum extends AppCompatActivity {

    TextView textViewZodiac, textViewWeeklyComment;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haftalik_yorum);

        textViewZodiac = findViewById(R.id.textViewZodiac);
        textViewWeeklyComment = findViewById(R.id.textViewWeeklyComment);
        buttonBack = findViewById(R.id.buttonBack);

        // SharedPreferences'tan burç bilgisini al
        SharedPreferences sharedPreferences = getSharedPreferences("BurcData", MODE_PRIVATE);
        String zodiac = sharedPreferences.getString("zodiacSign", "Bilinmiyor");

        // Yorumu al
        String weeklyComment = getWeeklyComment(zodiac);

        textViewZodiac.setText("Burcunuz: " + zodiac);
        textViewWeeklyComment.setText(weeklyComment);

        buttonBack.setOnClickListener(v -> finish());
    }

    // Burca göre haftalık yorum döndüren fonksiyon
    private String getWeeklyComment(String zodiac) {
        switch (zodiac) {
            case "Koç":
                return "Bu hafta yeni başlangıçlar sizi bekliyor.";
            case "Boğa":
                return "İstikrar ve güven arayışınız ön planda.";
            case "İkizler":
                return "Sosyal çevrenizden sürprizler gelebilir.";
            case "Yengeç":
                return "Duygusal dengelerle ilgili gelişmeler olabilir.";
            case "Aslan":
                return "Liderlik özellikleriniz öne çıkıyor.";
            case "Başak":
                return "Planlama ve düzenle ilgili işleriniz hızlanacak.";
            case "Terazi":
                return "İlişkilerinizde netlik zamanı.";
            case "Akrep":
                return "İç dünyanızda değişim yaşayabilirsiniz.";
            case "Yay":
                return "Yolculuklar ve keşifler için uygun bir hafta.";
            case "Oğlak":
                return "Kariyerinizde olumlu gelişmeler yaşanabilir.";
            case "Kova":
                return "Farklı düşünceler sizi başarıya götürebilir.";
            case "Balık":
                return "Hayal gücünüzü pratiğe dökme zamanı.";
            default:
                return "Burç bilgisi bulunamadı. Lütfen önce burcunuzu hesaplayın.";
        }
    }
}
