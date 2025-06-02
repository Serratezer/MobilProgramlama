package com.example.burcuygulamasi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class Secenekler extends AppCompatActivity {

    public void scheduleDailyNotification() {
        Intent intent = new Intent(this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9); // Sabah 09:00
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        long triggerTime = calendar.getTimeInMillis();
        if (System.currentTimeMillis() > triggerTime) {
            // Eğer o saat geçmişse, ertesi gün için ayarla
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            triggerTime = calendar.getTimeInMillis();
        }

        alarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                triggerTime,
                AlarmManager.INTERVAL_DAY,
                pendingIntent
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secenekler);

        scheduleDailyNotification();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnZodiac = findViewById(R.id.btnZodiac);
        btnZodiac.setOnClickListener(v -> {
            Intent intent = new Intent(Secenekler.this, Burc_Ogren.class);
            startActivity(intent);
        });

        Button btnAscendant = findViewById(R.id.btnAscendant);
        btnAscendant.setOnClickListener(v -> {
            Intent intent = new Intent(Secenekler.this, YukselenOgren.class);
            startActivity(intent);
        });

        Button btnTestNotification = findViewById(R.id.btnTestNotification);
        btnTestNotification.setOnClickListener(v -> {
            // Yorumları tarih bazlı rastgele al
            String zodiac = getSharedPreferences("BurcData", MODE_PRIVATE)
                    .getString("zodiacSign", "Burcun");
            String dailyComment = NotificationHelper.getRandomDailyComment(this);

            NotificationHelper.showNotification(
                    Secenekler.this,
                    zodiac + " için Günlük Yorum",
                    dailyComment
            );
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

        // Android 13+ için bildirim izni kontrolü
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }
    }
}
