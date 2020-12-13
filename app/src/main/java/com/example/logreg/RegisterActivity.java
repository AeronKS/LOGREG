package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etFelhnev, etJelszo, etTeljesNev;
    Button btnReg, btnVissza;
    DBhelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegAdatRogzit();
            }
        });

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
    }

    private void RegAdatRogzit() {
        //todo adatrögzítés
        String email = etEmail.getText().toString().trim();
        String felhnev = etFelhnev.getText().toString().trim();
        String jelszo = etJelszo.getText().toString().trim();
        String teljesnev = etTeljesNev.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "E-mail megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (felhnev.isEmpty()) {
            Toast.makeText(this, "Felhasználónév megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (jelszo.isEmpty()) {
            Toast.makeText(this, "Jelszó megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (teljesnev.isEmpty()) {
            Toast.makeText(this, "Név megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (adatbazis.adatRegisztracio(email, felhnev, jelszo, teljesnev)){
            Toast.makeText(this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sikertelen regisztráció!", Toast.LENGTH_SHORT).show();
        }

    }

    private void init() {
        etEmail = findViewById(R.id.et_reg_email);
        etFelhnev = findViewById(R.id.et_reg_felhnev);
        etJelszo = findViewById(R.id.et_reg_jelszo);
        etTeljesNev = findViewById(R.id.et_reg_teljnev);
        btnReg = findViewById(R.id.btn_reg_regisztracio);
        btnVissza = findViewById(R.id.btn_reg_vissza);

        adatbazis = new DBhelper(RegisterActivity.this);
    }
}