package com.example.goliathnationalbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final String PreferenceKey = "PREF";

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

    public String getPreference(String chave) {
        SharedPreferences sh = getSharedPreferences(PreferenceKey, Context.MODE_PRIVATE);
        return sh.getString(chave, "");
    }

    public void gravaPreferencias(View view) {
        EditText txtUsuario = findViewById(R.id.inputUsuario);
        EditText txtSenha = findViewById(R.id.inputSenha);

        addPreference("usuario", txtUsuario.getText().toString());
        addPreference("senha", txtSenha.getText().toString());
    }

    public void recuperaPreferencias(View view) {
        EditText txtUsuario = findViewById(R.id.inputUsuario);
        EditText txtSenha = findViewById(R.id.inputSenha);

        txtUsuario.setText(getPreference("usuario"));
        txtSenha.setText(getPreference("senha"));
    }
}