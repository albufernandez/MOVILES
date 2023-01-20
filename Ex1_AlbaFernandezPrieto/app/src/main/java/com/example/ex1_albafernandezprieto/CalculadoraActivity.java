package com.example.ex1_albafernandezprieto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    //declaramos las variables
    private EditText etValor;
    private TextView tvValor, tvValorAnterior, tvValorPosterior, tvEsPar;
    private Switch swEncendida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        //iniciamos las variables
        etValor = findViewById(R.id.etValor);
        tvValor = findViewById(R.id.tvValor);
        tvValorAnterior = findViewById(R.id.tvValorAnterior);
        tvValorPosterior = findViewById(R.id.tvValorPosterior);
        tvEsPar = findViewById(R.id.tvEsPar);

        swEncendida = findViewById(R.id.swEncendida);
    }

    //metodo que hace los calculos
    public void calcular (View vista){


        //comprobamos que esté encendida
        if (swEncendida.isChecked()) {
            //asignamos valores a variables
            String valorString = etValor.getText().toString();

                //comprobamos que el valor no este vacio
                 if (valorString.isEmpty()){
                    Toast.makeText(this, "Valor vacio", Toast.LENGTH_SHORT).show();
                }
                 else {

                     int valor = Integer.parseInt(valorString);

                     //Comprobamos que el valor sea mayor que 0
                     if (valor < 0) {
                         Toast.makeText(this, "El valor debe ser mayor que 0", Toast.LENGTH_SHORT).show();
                     } else {
                         //declaramos variables que usaremos
                         int posterior = valor + 1;
                         int anterior = valor - 1;
                         String par = "";

                         //comprobamos si es par y asiganaoms valor a esa variable
                         if (valor % 2 == 0) {
                             par = "par";
                         } else {
                             par = "impar";
                         }

                         //modificamos los text view con su valor correspondiente
                         tvValor.setText("Valor introducido: " + valor);
                         tvValorPosterior.setText("Valor posterior " + posterior);
                         tvValorAnterior.setText("Valor anterior " + anterior);
                         tvEsPar.setText("Par o impar: " + par);
                     }
                 }

        }
        //si la calculadora no esta encendida salta un mensaje
        else {
            Toast.makeText(this, "Calculadora apagada, enciendela", Toast.LENGTH_SHORT).show();
        }
    }


    //metodo que cierra esta activity y volvemos a la main
    public void salir (View vista){
        finish();
    }
}