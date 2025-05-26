package com.example.sqlhesapmakinesi;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class veritabani extends SQLiteOpenHelper {

    public veritabani(Context context) {
        super(context, "Kisiler", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE kisi (ad TEXT, soyad TEXT, tel TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS kisi");
        onCreate(db);
}
}