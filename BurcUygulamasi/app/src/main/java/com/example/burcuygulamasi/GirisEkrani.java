package com.example.burcuygulamasi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GirisEkrani extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button buttonLogin, buttonRegister;
    VeritabaniYardimcisi veritabaniYardimcisi;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        veritabaniYardimcisi = new VeritabaniYardimcisi(this);

        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (!username.isEmpty() && !password.isEmpty()) {
                boolean girisBasarili = veritabaniYardimcisi.girisBilgileriniDogrula(username, password);

                if (girisBasarili) {
                    Toast.makeText(GirisEkrani.this, "Giriş başarılı!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(GirisEkrani.this, Secenekler.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(GirisEkrani.this, "Hatalı kullanıcı adı veya şifre!", Toast.LENGTH_SHORT).show();
                }
            } else {
                editTextUsername.setError("Kullanıcı adı girin");
                editTextPassword.setError("Şifre girin");
            }
        });

        buttonRegister.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (!username.isEmpty() && !password.isEmpty()) {
                boolean kayitBasarili = veritabaniYardimcisi.kullaniciEkle(username, password);

                if (kayitBasarili) {
                    Toast.makeText(GirisEkrani.this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GirisEkrani.this, "Kayıt başarısız! Kullanıcı zaten var mı?", Toast.LENGTH_SHORT).show();
                }
            } else {
                editTextUsername.setError("Kullanıcı adı girin");
                editTextPassword.setError("Şifre girin");
            }
        });
    }
}
