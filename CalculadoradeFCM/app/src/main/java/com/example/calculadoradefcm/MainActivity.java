package com.example.calculadoradefcm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarTela2ECalcularFCM(View view) {
        Intent proximaTela = new Intent(MainActivity.this,MainActivity2.class);

        EditText txtIdade = findViewById(R.id.inputTextIdade);

        String stIdade = txtIdade.getText().toString();

        int idade = Integer.parseInt(stIdade);

        int FCM = 220 - idade;

        proximaTela.putExtra("FCM", FCM);

        startActivity(proximaTela);
    }
}