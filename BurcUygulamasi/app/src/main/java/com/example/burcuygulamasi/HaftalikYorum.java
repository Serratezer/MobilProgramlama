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
                return "Bu hafta hayatınızda yeni başlangıçlara hazır olun. Uzun süredir ertelediğiniz bir karar artık gündeminize gelebilir. Cesaretiniz ve enerjiniz sayesinde yeni adımlar atmaktan çekinmeyeceksiniz. İnisiyatif almak size fayda sağlayacak.";
            case "Boğa":
                return "İstikrar ve güven arayışınız bu hafta ön planda olacak. Hem iş hem özel hayatınızda sağlam temeller atmak isteyebilirsiniz. Kendinizi huzurlu hissettiğiniz ortamlarda bulunmak size iyi gelecek. Maddi konularda dikkatli davranmakta fayda var.";
            case "İkizler":
                return "Bu hafta sosyal çevrenizden sürpriz gelişmelerle karşılaşabilirsiniz. Yeni insanlarla tanışmak, yeni fikirler üretmek açısından hareketli bir hafta sizi bekliyor. Ani planlar, eğlenceli ortamlarda bulunmak ruh halinizi olumlu etkileyecek.";
            case "Yengeç":
                return "Duygusal anlamda yoğun bir haftaya giriş yapıyorsunuz. Aile içi meseleler ya da geçmişe dair bazı konular gündeminize gelebilir. Bu duygusal yoğunluk size farkındalık kazandıracak. Kendinize vakit ayırmak, iç sesinizi dinlemek önemli olacak.";
            case "Aslan":
                return "Bu hafta liderlik özellikleriniz ön plana çıkıyor. Grup çalışmalarında öne çıkabilir, sorumluluk alabilirsiniz. Karar verme yetiniz ve özgüveniniz sayesinde çevrenizden takdir göreceksiniz. Ancak kibirli tavırlardan kaçınmanızda fayda var.";
            case "Başak":
                return "Planlama ve düzenle ilgili işler bu hafta hız kazanıyor. Yapılacaklar listenizi düzene koymak ve detaylarla ilgilenmek açısından verimli bir dönem. Aynı zamanda sağlık ve yaşam rutinlerinizle ilgili düzenlemeler yapmak için de uygun bir zaman.";
            case "Terazi":
                return "İkili ilişkilerde netlik kazanacağınız bir hafta olabilir. Kararsız kaldığınız bazı konularda artık bir tercih yapma zamanı gelmiş olabilir. Dengenizi koruyarak hareket etmek, karşı tarafı da anlamaya çalışmak size kazandıracak.";
            case "Akrep":
                return "Bu hafta iç dünyanızda derin bir dönüşüm yaşayabilirsiniz. Kendi motivasyonlarınızı gözden geçireceğiniz, belki de bazı yönlerinizi değiştirmek isteyeceğiniz bir süreç olabilir. Gizli kalan bazı gerçeklerle yüzleşmek sizi özgürleştirebilir.";
            case "Yay":
                return "Yolculuklar, keşifler ve yeni deneyimler için harika bir hafta. Uzaklardan gelen haberler veya seyahat planları gündeme gelebilir. Aynı zamanda entelektüel olarak da gelişmeye açık bir dönem. Eğitim ve öğrenme konularında destek görebilirsiniz.";
            case "Oğlak":
                return "Kariyer hayatınızda olumlu gelişmeler kapınızda. Yeni bir sorumluluk, terfi ya da proje gündeminize gelebilir. Çalışmalarınızın karşılığını almaya başlayacağınız bir süreçtesiniz. Planlı ve disiplinli olmanız size avantaj sağlayacak.";
            case "Kova":
                return "Bu hafta farklı düşünceler ve yenilikçi yaklaşımlar sizi başarıya götürebilir. Kalıpların dışına çıkmak size ilham verecek. Özellikle teknoloji, bilim veya toplumsal konulara ilgi duymanız mümkün. Yeni projelere açık olun.";
            case "Balık":
                return "Hayal gücünüzü pratiğe dökme zamanı geldi. Yaratıcılığınızı daha somut işler için kullanabilirsiniz. Sanatsal faaliyetler, duygusal paylaşımlar ve ruhsal gelişim için uygun bir hafta olacak. Sezgilerinizden faydalanın.";
            default:
                return "Burç bilgisi bulunamadı. Lütfen önce burcunuzu hesaplayın.";
        }
    }
}
