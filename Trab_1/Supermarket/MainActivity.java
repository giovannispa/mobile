package com.teste.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        TextView valorTotal = findViewById(R.id.valorTotal);
        CheckBox arroz = findViewById(R.id.arroz);
        CheckBox leite = findViewById(R.id.leite);
        CheckBox carne = findViewById(R.id.carne);
        CheckBox feijao = findViewById(R.id.feijao);
        CheckBox refrigerante = findViewById(R.id.refrigerante);

        double total = 0;

        if(arroz.isChecked()) {
            total += 3.35;
        }

        if(leite.isChecked()) {
            total += 5.54;
        }

        if(carne.isChecked()) {
            total += 22;
        }

        if(feijao.isChecked()) {
            total += 6.65;
        }

        if(refrigerante.isChecked()) {
            total += 7.30;
        }

        if(total == 0) {
            valorTotal.setText("Não foi efetuado uma compra");
            return;
        }

        Locale l = new Locale("pt","BR");
        NumberFormat nf = NumberFormat.getInstance(l);
        valorTotal.setText("R$ " + nf.format(total));
    }
}
