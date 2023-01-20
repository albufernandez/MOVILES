package com.example.appalba;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AcercaDeActivity extends AppCompatActivity {

    //declaracion de variable
    TextView tvNombreAcerca;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        //inicializacion de variable
        tvNombreAcerca = findViewById(R.id.tvNombreAcerca);

        //pertenece a la comunicacion de intenciones, es la recepcion del nombre
        //que damos en la main activity
        Bundle b = getIntent().getExtras();
        String nombre = b.getString("nombre");

        tvNombreAcerca.setText(nombre);
    }

    //metodo que finaliza esta actividad y vuelve al m ain
    public void atras (View vista){
        finish();
    }
}