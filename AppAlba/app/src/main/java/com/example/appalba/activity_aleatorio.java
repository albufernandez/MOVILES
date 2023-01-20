package com.example.appalba;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class activity_aleatorio extends AppCompatActivity {

    //declaraciones de variables
    private EditText etUno;
    private EditText etDos;

    private TextView tvAleatorio;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);

        //iniciamos las variables
        etUno = findViewById(R.id.etUno);
        etDos = findViewById(R.id.etDos);
        tvAleatorio = findViewById(R.id.tvAleatorio);

    }

    //metodo que da un numero aleatorio
    public void numeroAleatorio (View vista){

        //comprobamos que no tengamos ningun valor vacio y en caso de haberlo lanzamos un mensaje
        if (etUno.getText().toString().equals("")||etDos.getText().toString().equals("")){
            Toast.makeText(this, getString(R.string.valorVacio), Toast.LENGTH_SHORT).show();
        }

        else {
            int n1 = Integer.parseInt(etUno.getText().toString());
            int n2 = Integer.parseInt(etDos.getText().toString());

            //si el numero2 es mayor que el numero1 (lo esperado) nos da un numero aleatorio entre el n1 y n2
            if (n2>n1){
            int aleatorio = (int) Math.floor(Math.random()*(n2-n1+1)+n1);

                    //asigna ese numero aleatorio al tVAletorio para mostrarlo
                    String ale = String.valueOf(aleatorio);
                    tvAleatorio.setText(ale);}

            //en caso de que el n1 fuera mayor que el n2 lanza un mensaje advirtiendolo
            else { Toast.makeText(this, getString(R.string.numeroMayor), Toast.LENGTH_SHORT).show(); }
        }
    }

    //metodo que cierra esta activity y volvemos a la main
    public void salir (View vista){
        finish();
    }
}