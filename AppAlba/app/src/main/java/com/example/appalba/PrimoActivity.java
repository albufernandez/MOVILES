package com.example.appalba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class PrimoActivity extends AppCompatActivity {

    //declaramos las variables
    private EditText etValor;
    private TextView tvComprobar;
    private Switch swPrimo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primo);

        //iniciamos las variables
         etValor = findViewById(R.id.etValor);
         tvComprobar = findViewById(R.id.tvComprobar);
         swPrimo = findViewById(R.id.swPrimo);
    }

    //metodo que comprueba si un numero es primo
    public void esPrimo (View vista) {
        //comprobamos que el switch de la calculadora esté activado
        if (swPrimo.isChecked()) {

            //cogemos el valor del edit text
            String valor = etValor.getText().toString();

            //si un valor esta vacio lanzamos error
            if (valor.isEmpty()) {
                Toast.makeText(this, getString(R.string.valorVacio), Toast.LENGTH_SHORT).show();

            //si no hay valores vacios
            } else {

                //Se comprueba si es primo o no y se imprime
                int numero = Integer.parseInt(valor);
                int contador = 2;
                boolean primo = true;
                while ((primo) && (contador != numero)) {
                    if (numero % contador == 0)
                        primo = false;
                    contador++;
                }

                if (primo) {
                    tvComprobar.setText("¡Tu numero es primo!");
                } else tvComprobar.setText("Tu numero no es primo");

            }
        }
        //si el switch esta apagado lanzamos mensaje
        else{
            Toast.makeText(this, getString(R.string.encenderPrograma), Toast.LENGTH_SHORT).show();
        }
    }

    public void volverPrimo(View vista){
        finish();
    }
}