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
                return "Bugün cesur kararlar almak için harika bir gün. İçinizdeki liderlik ruhu sayesinde zorlukların üstesinden kolayca gelebilirsiniz. Risk almaktan çekinmeyin, başarı sizi bekliyor.";
            case "Boğa":
                return "Maddi konularda dikkatli olmanız gereken bir gündesiniz. Harcamalarınızı gözden geçirip gereksiz giderlerden kaçının. Ancak sevdiklerinizle zaman geçirmek size iyi gelecek.";
            case "İkizler":
                return "İletişim gücünüz bugün oldukça yüksek. Yeni insanlarla tanışabilir, etkili konuşmalar yapabilirsiniz. Sosyal çevrenizden ilham alabilir, yaratıcı projelere yönelebilirsiniz.";
            case "Yengeç":
                return "İç sesinize kulak vererek alacağınız kararlar sizi şaşırtabilir ama doğru yolda olduğunuzu gösterecek. Ailevi konularda destekleyici tavırlarınız olumlu sonuçlar getirebilir.";
            case "Aslan":
                return "Kendinize olan güveniniz çevrenizdeki insanları da etkisi altına alacak. Bugün dikkatleri üzerinize çekiyorsunuz. Yeni bir başlangıç yapmak ya da sahneye çıkmak için ideal bir zaman.";
            case "Başak":
                return "Detaylara gösterdiğiniz özen sayesinde fark yaratacaksınız. Bugün düzen kurma ve planlama açısından verimli bir gün olabilir. Zihniniz net, kararlarınız sağlam olacak.";
            case "Terazi":
                return "Dengenizi koruyarak hareket etmek bugün size huzur getirecek. Karar vermekte zorlanabilirsiniz ama iç huzurunuzu bozacak adımlardan uzak durmanız faydalı olacaktır.";
            case "Akrep":
                return "Bastırılmış duygularınız bugün yüzeye çıkabilir. Bunlarla yüzleşmek sizi rahatlatacak. İçsel dönüşümünüz için önemli bir fırsat olabilir, kendinize zaman ayırın.";
            case "Yay":
                return "Yeni yerler keşfetmek, farklı bakış açılarıyla tanışmak için güzel bir gün. Macera ruhunuz yükseliyor. Ufkunuzu genişletecek deneyimlere açık olun.";
            case "Oğlak":
                return "Disiplinli ve planlı yapınız sayesinde bugün ciddi anlamda yol kat edebilirsiniz. Sorumluluklarınızın farkındasınız ve çevreniz sizin bu yönünüzü takdir ediyor.";
            case "Kova":
                return "Yaratıcı fikirleriniz bugün ışıldıyor. Alışılmışın dışına çıkmaktan korkmayın. Sosyal ilişkilerinizde özgürlük ihtiyacınız ön planda olabilir.";
            case "Balık":
                return "Hayal gücünüz bugün dorukta. Sanatsal uğraşlara yönelebilir veya duygusal anlamda derin paylaşımlar yaşayabilirsiniz. Ruhsal olarak şifa bulacağınız bir gün olabilir.";
            default:
                return "Burç bilgisi bulunamadı. Lütfen önce burcunuzu hesaplayın.";
        }
    }
}
