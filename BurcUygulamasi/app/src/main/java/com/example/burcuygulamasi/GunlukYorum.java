package com.example.burcuygulamasi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GunlukYorum extends AppCompatActivity {

    TextView textViewZodiac, textViewDailyComment;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunluk_yorum);


        textViewZodiac = findViewById(R.id.textViewZodiac);
        textViewDailyComment = findViewById(R.id.textViewDailyComment);
        buttonBack = findViewById(R.id.buttonBack);

        // SharedPreferences'tan burç bilgisini al
        SharedPreferences sharedPreferences = getSharedPreferences("BurcData", MODE_PRIVATE);
        String zodiac = sharedPreferences.getString("zodiacSign", "Bilinmiyor");

        // Yorumu al
        String dailyComment = getDailyComment(zodiac);

        textViewZodiac.setText("Burcunuz: " + zodiac);
        textViewDailyComment.setText(dailyComment);

        buttonBack.setOnClickListener(v -> finish());
    }

    // Burca göre günlük yorum döndüren fonksiyon
    private String getDailyComment(String zodiac) {
        switch (zodiac) {
            case "Koç":
                return "Bugün cesur kararlar alma zamanı.";
            case "Boğa":
                return "Finansal konularda dikkatli olun.";
            case "İkizler":
                return "İletişim becerilerinizle öne çıkabilirsiniz.";
            case "Yengeç":
                return "İç sesinize kulak verin. Kararlarınız sizi şaşırtabilir.";
            case "Aslan":
                return "Özgüveniniz çevrenizi etkileyecek.";
            case "Başak":
                return "Detaylara dikkat edin, fırsatlar oralarda gizli.";
            case "Terazi":
                return "Dengeyi korumak size iyi gelecek.";
            case "Akrep":
                return "Gizli duygularınız yüzeye çıkabilir.";
            case "Yay":
                return "Yeni maceralara açık olun.";
            case "Oğlak":
                return "Disiplinli çalışmanız takdir toplayacak.";
            case "Kova":
                return "Yaratıcılığınızı konuşturma zamanı.";
            case "Balık":
                return "Hayal gücünüzle harikalar yaratabilirsiniz.";
            default:
                return "Burç bilgisi bulunamadı. Lütfen önce burcunuzu hesaplayın.";
        }
    }
}
