package com.teste.poupafcil;

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
        TextView valorTotal = findViewById(R.id.valorTotal);
        TextView aplicMensal = findViewById(R.id.aplicMensal);
        TextView vlrInicial = findViewById(R.id.vlrInicial);
        TextView temAplicacao = findViewById(R.id.temAplicacao);
        TextView vlrTaxa = findViewById(R.id.vlrTaxa);

        double total = 0;
        double aplicacao = 0;
        int tempo =  0;
        double taxa = 0;

        if(!isEmpty(vlrInicial.getText().toString())) {
            total = Double.parseDouble(vlrInicial.getText().toString().replaceAll(",","."));
        }

        if(!isEmpty(aplicMensal.getText().toString())) {
            aplicacao = Double.parseDouble(aplicMensal.getText().toString().replaceAll(",","."));
        }

        if(!isEmpty(temAplicacao.getText().toString())) {
            tempo =  Integer.parseInt(temAplicacao.getText().toString());
        }

        if(!isEmpty(vlrTaxa.getText().toString())) {
            taxa = Double.parseDouble(vlrTaxa.getText().toString().replaceAll(",","."));
        }

        if(total == 0) {
            valorTotal.setText("Por favor, informe um valor inicial.");
            return;
        }

        if(aplicacao == 0) {
            valorTotal.setText("Por favor, informe uma aplicação.");
            return;
        }

        if(tempo == 0) {
            valorTotal.setText("Por favor, informe o tempo de investimento.");
            return;
        }

        if(taxa == 0) {
            valorTotal.setText("Por favor, informe uma taxa.");
            return;
        }

        double montante = calculaMontante(aplicacao, tempo, taxa);
        double vlrFinal = calculaJuros(montante, aplicacao, total);

        Locale l = new Locale("PT","BR");
        NumberFormat nf = NumberFormat.getInstance(l);
        valorTotal.setText("R$ " + nf.format(vlrFinal));
        return;
    }

    private double calculaMontante(double aplicacao, int tempo, double taxa) {
        double montante =  aplicacao * Math.pow((1 + taxa),tempo);
        return montante;
    }

    private double calculaJuros(double montante, double aplicacao, double total) {
        double juros =  montante - aplicacao;
        double vlrFinal = total + juros;
        return vlrFinal;
    }
}
