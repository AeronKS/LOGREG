package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etFelhnev, etJelszo;
    Button btnBej, btnReg;
    DBhelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        btnBej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nev = etFelhnev.getText().toString().trim();
                String jelszo = etJelszo.getText().toString().trim();

                if (nev.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nincs megadva felhasználónév!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (jelszo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nincs megadva jelszó!", Toast.LENGTH_SHORT).show();
                    return;
                }
                BejValid();
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regisztraciora = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(regisztraciora);
                finish();
            }
        });
    }

    private void BejValid() {
        String felhnev = etFelhnev.getText().toString().trim();
        String jelszo = etJelszo.getText().toString().trim();

        if (felhnev.isEmpty()) {
            Toast.makeText(this, "Felhasználónév megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (jelszo.isEmpty()) {
            Toast.makeText(this, "Jelszó megadása kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (adatbazis.felhnevLetezik(felhnev)) {
            if (adatbazis.jelszoLetezik(jelszo)) {
                Toast.makeText(this, "Sikeres bejelentkezes!", Toast.LENGTH_SHORT).show();

                Intent bejelentkezes = new Intent(MainActivity.this, LoggedInActivity.class);
                startActivity(bejelentkezes);
                finish();
            } else {
                Toast.makeText(this, "Hibás felhasználónév vagy jelszó!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Hibás felhasználónév vagy jelszó!", Toast.LENGTH_SHORT).show();
        }
    }

    private void init() {
        etFelhnev = findViewById(R.id.et_felhnev);
        etJelszo = findViewById(R.id.et_jelszo);
        btnBej = findViewById(R.id.btn_bejelentkezes);
        btnReg = findViewById(R.id.btn_regisztracio);

        adatbazis = new DBhelper(MainActivity.this);
    }
}