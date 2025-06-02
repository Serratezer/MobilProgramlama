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
                return "Bu ay enerjinizi özellikle kariyerinize yönlendirmeniz size büyük kazançlar sağlayabilir. İş yerinde aktif olmak, liderlik rolü üstlenmek ve projeleri sahiplenmek için doğru bir zamandasınız. Ancak aceleci kararlar almaktan kaçınmalı ve stratejik düşünmelisiniz.";
            case "Boğa":
                return "Bu ay maddi konular gündeminizde olacak. Uzun süredir beklediğiniz bir fırsat nihayet kapınızı çalabilir. Yatırım yapmak ya da birikimlerinizi değerlendirmek için uygun bir dönem. Aynı zamanda harcamalar konusunda daha bilinçli hareket etmeniz gerekebilir.";
            case "İkizler":
                return "Yeni insanlarla tanışacağınız, sosyal çevrenizi genişleteceğiniz bir ay sizi bekliyor. Katıldığınız ortamlarda ilgi görebilir, iletişim becerileriniz sayesinde dikkat çekebilirsiniz. Aynı zamanda kendinizi ifade etmek için güçlü bir motivasyona sahip olacaksınız.";
            case "Yengeç":
                return "Ailevi meseleler bu ay ön planda olabilir. Ev, yuva, aile bireyleriyle ilişkiler konusunda bazı gelişmeler yaşayabilirsiniz. Duygusal olarak hassas olabileceğiniz bir dönemdesiniz. İç huzurunuzu korumak adına sevdiklerinizle vakit geçirmeniz size iyi gelecek.";
            case "Aslan":
                return "Bu ay yaratıcılığınız tavan yapacak. Sanatsal faaliyetlerde bulunabilir ya da yeni projelere imza atabilirsiniz. Aynı zamanda çevreniz tarafından takdir görebileceğiniz bir dönemdesiniz. Kendinizi daha fazla sahneye çıkarmaktan çekinmeyin.";
            case "Başak":
                return "Sağlık konuları bu ay gündeminizde olabilir. Yeni bir beslenme düzenine geçmek, egzersiz yapmak ya da bir sağlık kontrolü yaptırmak için ideal bir dönem. Aynı zamanda yaşamınızı düzene koymak adına planlamalar yapabilir ve günlük alışkanlıklarınızı gözden geçirebilirsiniz.";
            case "Terazi":
                return "İkili ilişkilerde uyum ve denge arayışı bu ay sizin için önem kazanıyor. Mevcut bir ilişkide ilerleme kaydedebilir ya da yeni biriyle anlamlı bir bağ kurabilirsiniz. Uyumlu tavırlarınız sayesinde çevrenizle daha sıcak ilişkiler kurmanız mümkün.";
            case "Akrep":
                return "Bu ay içsel olarak derinleşeceğiniz, duygusal konularla daha fazla ilgileneceğiniz bir dönem olacak. Kendinizle yüzleşebilir, bazı duygularınızı daha iyi anlamaya başlayabilirsiniz. Sezgilerinizin kuvvetli olacağı bu dönemi ruhsal gelişim için değerlendirin.";
            case "Yay":
                return "Eğitim, öğrenme ve seyahat planları için verimli bir ay. Yeni bir kursa başlamak, farklı kültürlerle tanışmak ya da uzun zamandır ertelediğiniz bir geziyi planlamak için fırsatlar doğabilir. Ufkunuzu genişleten her şey size ilham verecek.";
            case "Oğlak":
                return "Bu ay hedeflerinize odaklanarak istikrarlı adımlar atabilirsiniz. Kariyer ve kişisel gelişim açısından önemli gelişmeler yaşanabilir. Uzun vadeli planlar yapmak ve bu planlar doğrultusunda ilerlemek size başarı getirecek. Disiplinli tutumunuz takdir görecek.";
            case "Kova":
                return "Toplumsal konulara duyarlılığınız artabilir. Sosyal sorumluluk projelerine katılmak, yardım faaliyetlerinde bulunmak ya da çevrenizdeki insanlara destek olmak adına güzel bir ay. Aynı zamanda yeni fikirler üretmek için de zihinsel olarak aktifsiniz.";
            case "Balık":
                return "Bu ay hayal gücünüz ve sezgileriniz oldukça güçlü olacak. İç dünyanızla daha fazla bağlantıya geçebilir, yaratıcı projelerde başarılı sonuçlar alabilirsiniz. Duygusal paylaşımlar ve empati kurma yeteneğiniz, insanlarla bağ kurmanızda önemli rol oynayacak.";
            default:
                return "Burç bilgisi bulunamadı. Lütfen önce burcunuzu hesaplayın.";
        }
    }
}
