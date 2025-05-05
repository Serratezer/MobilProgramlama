package com.example.burcuygulamasi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class GirisEkrani extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button buttonLogin, buttonRegister;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            if (!username.isEmpty() && !password.isEmpty()) {
                Intent intent = new Intent(GirisEkrani.this, Secenekler.class); // Secenekler ekranına geçiş
                startActivity(intent);
            } else {
                editTextUsername.setError("Kullanıcı adı girin");
                editTextPassword.setError("Şifre girin");
            }
        });

        // buttonRegister.setOnClickListener(...) // İstersen sonra aktifleştirebilirsin
    }
}
