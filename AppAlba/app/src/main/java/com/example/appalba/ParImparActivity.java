package com.example.appalba;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ParImparActivity extends AppCompatActivity {

    //declaramos las variables
    private EditText editTextValor1;
    private TextView tvComprobar;
    private Switch swEncendida;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_impar);

        //iniciamos las variables
        editTextValor1 = findViewById(R.id.etValor1Par);
        tvComprobar = findViewById(R.id.tvComprobar);
        swEncendida = findViewById(R.id.swEncendida);


    }

    //metodo que nos dice si un numero es par o impar
    public void esParImpar(View vista) {

        //comprobamos que el switch este encendido (es decir que el programa este encendido)
        if (swEncendida.isChecked()) {

            //cogemos el numero
            String valor = editTextValor1.getText().toString();

            //si esta vacio lanzamos un error
            if (valor.isEmpty()) {
                Toast.makeText(this, getString(R.string.valorVacio), Toast.LENGTH_SHORT).show();

            //Si no esta vacio pasamos el valor a numero y comprobamos si es par o impar
            } else {
                int numero = Integer.parseInt(valor);

                if (numero % 2 == 0) {
                    tvComprobar.setText("¡Tu numero es par!");
                } else tvComprobar.setText("¡Tu numero es impar!");

            }

        }
        //si la calcuradora esta apagada lanzamos el mensaje de error
        else {
            Toast.makeText(this, getString(R.string.encenderPrograma), Toast.LENGTH_SHORT).show();
        }
    }




    public void volverParImpar (View vista){
        finish();
    }
}