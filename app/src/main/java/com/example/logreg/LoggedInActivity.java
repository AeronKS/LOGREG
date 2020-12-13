package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    TextView tvNev;
    Button btnKij;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        init();
        //todo setText db.teljesnev

        btnKij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kijelentkezes = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(kijelentkezes);
                finish();
            }
        });
    }

    private void init() {
        tvNev = findViewById(R.id.tv_bej_teljesnev);
        btnKij = findViewById(R.id.btn_bej_kijelentkezes);
    }
}