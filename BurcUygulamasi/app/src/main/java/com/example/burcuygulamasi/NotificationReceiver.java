package com.example.burcuygulamasi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper.showNotification(
                context,
                "Bugünün burç yorumunu okudun mu?",
                "Günlük burç yorumun seni bekliyor. Hemen kontrol et!"
        );
    }
}
