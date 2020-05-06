package com.teste.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        TextView textConsumo = findViewById(R.id.textConsumo);
        TextView textCouvert = findViewById(R.id.textCouvert);
        TextView textDivisao = findViewById(R.id.textDivisao);
        TextView textTaxa = findViewById(R.id.textTaxa);
        TextView textTotal = findViewById(R.id.textTotal);
        TextView textTotalPessoa = findViewById(R.id.textTotalPessoa);

        if(isEmpty(textConsumo.getText().toString())) {
            return;
        }

        double consumo = Double.parseDouble(textConsumo.getText().toString().replaceAll(",","."));
        double couvert = Double.parseDouble(textCouvert.getText().toString().replaceAll(",","."));
        int divisao = Integer.parseInt(textDivisao.getText().toString().replaceAll(",","."));
        double taxa = Double.parseDouble(textTaxa.getText().toString().replaceAll(",","."));
        double total = 0;
        double totalPessoa = 0;

        total = consumo + couvert + (consumo * taxa);
        if(divisao != 0) {
            totalPessoa = total / divisao;
        }

        Locale l = new Locale("pt-BR", "BR");
        NumberFormat nf = NumberFormat.getInstance(l);

        textTotal.setText("R$ " + nf.format(total));
        textTotalPessoa.setText("R$ " + nf.format(totalPessoa));
    }
}
