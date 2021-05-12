package com.example.lanchonetedobafo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class TelaPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pedido);

        String lanche = getIntent().getStringExtra("lanche");
        float precoUnitario = getIntent().getFloatExtra("precoUnitario", precoUnitario = 0);
        int quantidade = getIntent().getIntExtra("quantidade", quantidade = 1);
        float precoTotal = getIntent().getFloatExtra("precoTotal", precoTotal = 0);

        DecimalFormat precoUnitarioDF = new DecimalFormat("#.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        precoUnitarioDF.setMaximumFractionDigits(2);

        DecimalFormat precoTotalDF = new DecimalFormat("#.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        precoTotalDF.setMaximumFractionDigits(2);

        TextView textNomeDoLanche = findViewById(R.id.textNomeDoLanche);
        TextView textPrecoUnitario = findViewById(R.id.textPrecoUnitario);
        TextView textQuantidade = findViewById(R.id.textQuantidade);
        TextView textPrecoTotal = findViewById(R.id.textPrecoTotal);

        textNomeDoLanche.setText("Lanche: " + lanche);
        textPrecoUnitario.setText("Preço unitário: R$ " + precoUnitarioDF.format(precoUnitario));
        textQuantidade.setText("Quantidade: " + quantidade);
        textPrecoTotal.setText("R$ " + precoTotalDF.format(precoTotal));
    }
}