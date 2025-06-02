package com.example.burcuygulamasi;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;

public class NotificationHelper {

    private static final String CHANNEL_ID = "burc_channel";

    public static void showNotification(Context context, String title, String message) {
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Kanal sadece API 26+ için gerekli
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Burç Bildirimleri",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationManager.notify(1, builder.build());
    }

    // Tarihe göre günlük yorum
    public static String getRandomDailyComment(Context context) {
        String[] dailyComments = {
                "Bugün enerjiniz yüksek olabilir!",
                "Kararlarınızı dikkatle vermeye çalışın.",
                "Yeni başlangıçlara açık olun.",
                "Sezgilerinize güvenin.",
                "Bugün duygusal dengelere dikkat!",
                "Sürpriz gelişmelere hazırlıklı olun.",
                "Çevrenizdekilere destek olun.",
                "Kendinize zaman ayırmayı unutmayın.",
                "Bugün iletişim ön planda olacak.",
                "İyi haberler kapınızı çalabilir!"
        };

        Calendar calendar = Calendar.getInstance();
        int index = calendar.get(Calendar.DAY_OF_YEAR) % dailyComments.length;
        return dailyComments[index];
    }
}
