package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etFelhnev, etJelszo, etTeljesNev;
    Button btnReg, btnVissza;

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
    }

    private void init() {
        etEmail = findViewById(R.id.et_reg_email);
        etFelhnev = findViewById(R.id.et_reg_felhnev);
        etJelszo = findViewById(R.id.et_reg_jelszo);
        etTeljesNev = findViewById(R.id.et_reg_teljnev);
        btnReg = findViewById(R.id.btn_reg_regisztracio);
        btnVissza = findViewById(R.id.btn_reg_vissza);
    }
}