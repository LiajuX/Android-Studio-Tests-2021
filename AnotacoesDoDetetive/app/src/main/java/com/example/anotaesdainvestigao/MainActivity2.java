package com.example.anotaesdainvestigao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public String getPreference(String chave) {
        SharedPreferences sh = getSharedPreferences(getIntent().getStringExtra("PreferenceKey"), Context.MODE_PRIVATE);
        return sh.getString(chave, "");
    }

    public String recuperaDadoArquivo(String filename) {
        try {
            int data;
            StringBuilder output = new StringBuilder();

            FileInputStream fi = openFileInput(filename);
            data = fi.read();

            while (data != -1) {
                output.append((char) data);
                data = fi.read();
            }
            return output.toString();
        } catch (FileNotFoundException e) {
            return "";
        } catch (IOException e) {
            return "";
        }
    }

    public void doRecuperar(View view) {
        TextView txtNome = findViewById(R.id.textNomeDoSuspeito);
        txtNome.setText(getPreference("nome"));

        TextView txtDescricao = findViewById(R.id.textDescricaoInformacoes);
        txtDescricao.setText(recuperaDadoArquivo(getIntent().getStringExtra("fileName")));
    }
}