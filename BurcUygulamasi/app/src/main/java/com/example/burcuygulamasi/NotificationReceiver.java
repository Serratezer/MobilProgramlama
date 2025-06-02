package com.example.burcuygulamasi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences prefs = context.getSharedPreferences("BurcData", Context.MODE_PRIVATE);
        String zodiac = prefs.getString("zodiacSign", "Burcun");

        String dailyComment = NotificationHelper.getRandomDailyComment(context);

        NotificationHelper.showNotification(
                context,
                zodiac + " için Günlük Yorum",
                dailyComment
        );
    }
}
