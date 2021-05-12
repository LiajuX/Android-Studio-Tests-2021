package com.example.lanchonetedobafo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarTela2EProcessarPedido(View view) {
        Intent proximaTela = new Intent(MainActivity.this, TelaPedido.class);

        EditText txtCodigo = findViewById(R.id.inputTextCodigoDoLanche);
        EditText txtQuantidade = findViewById(R.id.inputTextQuantidade);

        String stCodigo = txtCodigo.getText().toString();
        String stQuantidade = txtQuantidade.getText().toString();

        int codigo = Integer.parseInt(stCodigo);
        int quantidade = Integer.parseInt(stQuantidade);

        proximaTela.putExtra("quantidade", quantidade);

        float precoUnitario;

        if (codigo == 30) {
            precoUnitario = (float) 4.30;
            String lanche = "Misto Quente";
            float precoTotal = precoUnitario * quantidade;

            proximaTela.putExtra("precoUnitario", precoUnitario);
            proximaTela.putExtra("lanche", lanche);
            proximaTela.putExtra("precoTotal", precoTotal);
        } else if (codigo == 31) {
            precoUnitario = (float) 5.70;
            String lanche = "Bauru";
            float precoTotal = precoUnitario * quantidade;

            proximaTela.putExtra("precoUnitario", precoUnitario);
            proximaTela.putExtra("lanche", lanche);
            proximaTela.putExtra("precoTotal", precoTotal);
        } else if (codigo == 32) {
            precoUnitario = (float) 10.50;
            String lanche = "Cachorro-Quente";
            float precoTotal = precoUnitario * quantidade;

            proximaTela.putExtra("precoUnitario", precoUnitario);
            proximaTela.putExtra("lanche", lanche);
            proximaTela.putExtra("precoTotal", precoTotal);
        } else if (codigo == 33) {
            precoUnitario = (float) 12.90;
            String lanche = "Hamburguer";
            float precoTotal = precoUnitario * quantidade;

            proximaTela.putExtra("precoUnitario", precoUnitario);
            proximaTela.putExtra("lanche", lanche);
            proximaTela.putExtra("precoTotal", precoTotal);
        } else if (codigo == 34) {
            precoUnitario = (float) 15.10;
            String lanche = "Cheeseburger";
            float precoTotal = precoUnitario * quantidade;

            proximaTela.putExtra("precoUnitario", precoUnitario);
            proximaTela.putExtra("lanche", lanche);
            proximaTela.putExtra("precoTotal", precoTotal);
        }  else if (codigo == 35) {
            precoUnitario = (float) 16.40;
            String lanche = "Cheese Salada";
            float precoTotal = precoUnitario * quantidade;

            proximaTela.putExtra("precoUnitario", precoUnitario);
            proximaTela.putExtra("lanche", lanche);
            proximaTela.putExtra("precoTotal", precoTotal);
        }

        Toast.makeText(getApplicationContext(), "Obrigado por comprar conosco :)", Toast.LENGTH_LONG).show();

        startActivity(proximaTela);
    }
}