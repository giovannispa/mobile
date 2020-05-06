package com.teste.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
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
        TextView salario = findViewById(R.id.salario);
        RadioButton radio_1 = findViewById(R.id.radio_1);
        RadioButton radio_2 = findViewById(R.id.radio_2);
        RadioButton radio_3 = findViewById(R.id.radio_3);
        double total = 0;

        if(!isEmpty(salario.getText().toString())) {
            total = Double.parseDouble(salario.getText().toString().replaceAll(",","."));
        }

        if(total == 0) {
            valorTotal.setText("Salário não informado");
            return;
        }

        if(radio_1.isChecked()) {
            total = total + (total * 0.4);
        }

        if(radio_2.isChecked()) {
            total = total + (total * 0.45);
        }

        if(radio_3.isChecked()) {
            total = total + (total * 0.5);
        }

        Locale l = new Locale("pt","BR");
        NumberFormat nf = NumberFormat.getInstance(l);
        valorTotal.setText("R$ " + nf.format(total));
        return;
    }
}
