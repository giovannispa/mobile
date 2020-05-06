package com.teste.bestfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        TextView textoConsumoAlcool = findViewById(R.id.textoConsumoAlcool);
        TextView textoConsumoGasolina = findViewById(R.id.textoConsumoGasolina);
        TextView textoPrecoAlcool = findViewById(R.id.textoPrecoAlcool);
        TextView textoPrecoGasolina = findViewById(R.id.textoPrecoGasolina);
        TextView resultado = findViewById(R.id.resultado);

        double consumoAlcool = 0, consumoGasolina = 0;
        double precoAlcool = 0, precoGasolina = 0;
        String melhorCombustivel = "";

        if(isEmpty(textoPrecoAlcool.getText().toString()) || isEmpty(textoPrecoGasolina.getText().toString())) {
            resultado.setText("Por favor, informe o preço da gasolina e do álcool");
            return;
        }

        precoAlcool = Double.parseDouble(textoPrecoAlcool.getText().toString().replaceAll(",","."));
        precoGasolina = Double.parseDouble(textoPrecoGasolina.getText().toString().replaceAll(",","."));

        if(precoAlcool == 0 || precoGasolina == 0) {
            resultado.setText("Por favor, informe o preço da gasolina e do álcool");
            return;
        }

        if(!isEmpty(textoConsumoAlcool.getText().toString())) {
            consumoAlcool = Double.parseDouble(textoConsumoAlcool.getText().toString().replaceAll(",","."));
        }

        if(!isEmpty(textoConsumoGasolina.getText().toString())) {
            consumoGasolina = Double.parseDouble(textoConsumoGasolina.getText().toString().replaceAll(",","."));
        }

        if(consumoGasolina != 0 && consumoAlcool != 0) {
            double razao = consumoAlcool / consumoGasolina;
            melhorCombustivel = (( (precoGasolina * razao) > precoAlcool) ? "Álcool" : "Gasolina");
        } else {
            melhorCombustivel = ((precoAlcool / precoGasolina >= 0.7) ? "Gasolina" : "Álcool");
        }

        resultado.setText(melhorCombustivel);
        return;
    }
}
