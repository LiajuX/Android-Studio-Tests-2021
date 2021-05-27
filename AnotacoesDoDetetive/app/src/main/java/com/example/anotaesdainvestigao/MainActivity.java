package com.example.anotaesdainvestigao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public final String PreferenceKey = "PREF";
    public final String fileName = "texto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPreference(String chave, String valor) {
        SharedPreferences sh = getSharedPreferences(PreferenceKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sh.edit();

        ed.putString(chave, valor).apply();
    }

    public void gravaDadoArquivo(String fileName, String data) {
        try {
            FileOutputStream fs = openFileOutput(fileName, Context.MODE_PRIVATE);

            fs.write(data.getBytes());
            fs.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public void doGravar(View view) {
        Intent proximaTela = new Intent(MainActivity.this, MainActivity2.class);

        EditText txtNomeDoSuspeito = findViewById(R.id.inputNome);
        addPreference("nome", txtNomeDoSuspeito.getText().toString());

        EditText txtDescricao = findViewById(R.id.inputDescricao);
        gravaDadoArquivo(fileName, txtDescricao.getText().toString());

        proximaTela.putExtra("PreferenceKey", PreferenceKey);
        proximaTela.putExtra("fileName", fileName);

        startActivity(proximaTela);
    }
}