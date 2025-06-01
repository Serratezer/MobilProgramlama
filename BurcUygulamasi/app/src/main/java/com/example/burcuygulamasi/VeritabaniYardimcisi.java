package com.example.burcuygulamasi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VeritabaniYardimcisi extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Kullanicilar.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "kullanici";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "kullaniciadi";
    private static final String COLUMN_PASSWORD = "sifre";

    public VeritabaniYardimcisi(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean kullaniciEkle(String kullaniciadi, String sifre) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, kullaniciadi);
        values.put(COLUMN_PASSWORD, sifre);

        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result != -1;
    }

    public boolean girisBilgileriniDogrula(String kullaniciadi, String sifre) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?";
        Cursor cursor = db.rawQuery(query, new String[]{kullaniciadi, sifre});
        boolean girisBasarili = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return girisBasarili;
    }
}

