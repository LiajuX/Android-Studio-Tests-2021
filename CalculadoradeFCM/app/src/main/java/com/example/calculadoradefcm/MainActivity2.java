package com.example.calculadoradefcm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int FCM = getIntent().getIntExtra("FCM", FCM = 0);

        TextView textFCMCalculada = findViewById(R.id.textFCMCalculada);
        TextView textInformativo = findViewById(R.id.textInformativo);

        textFCMCalculada.setText("FCM = " + FCM + " bpm");
        textInformativo.setText("Sua frequência cardíaca máxima é de " + FCM + " batimentos por minutos");
    }
}