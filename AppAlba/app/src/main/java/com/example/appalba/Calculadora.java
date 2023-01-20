package com.example.appalba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class Calculadora extends AppCompatActivity {

    //declaramos las variables
    private EditText editTextValor1;
    private EditText editTextValor2;
    private TextView textoResultado;
    private ToggleButton tbEncendido;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        //iniciamos las variables
        editTextValor1 = findViewById(R.id.editTextValor1);
        editTextValor2 = findViewById(R.id.editTextValor2);
        textoResultado = findViewById(R.id.textoResultado);
        tbEncendido = findViewById(R.id.tbEncendida);
        
    }

    //metodo que nos hace la potencia de dos numeros
    public void portencia (View vista){

        //si el togleButton esta encendido la calculadora puede funcionar
        if (tbEncendido.isChecked()){
            // Obtener valor 1
            String valor1 = editTextValor1.getText().toString();
            // Obtener valor 2
            String valor2 = editTextValor2.getText().toString();

            //en caso de que algun valor este vacio lanza un mensaje advirtiendolo
            if (valor1.isEmpty() || valor2.isEmpty()) {
                Toast.makeText(this, getString(R.string.valorVacio), Toast.LENGTH_SHORT).show();}

            else {

                //conseguimos el valor de la potencia y se lo pasamos a textoResultado
                double resultado =  Math.pow(Integer.parseInt(valor1), Integer.parseInt(valor2));
                textoResultado.setText("resultado de la potencia " + resultado); }
        }

        //si el togleButton está apagado la calculadora no puede funcionar y lo avisamos
        else {
            Toast.makeText(this, getString(R.string.encenderPrograma), Toast.LENGTH_SHORT).show();
        }
    }

    //metodo que hace la suma de dos numeros
    public void suma (View vista) {

        //comprobamos que la calculadora este encendida
        if (tbEncendido.isChecked()) {
            // Obtener valor 1
            String valor1 = editTextValor1.getText().toString();
            // Obtener valor 2
            String valor2 = editTextValor2.getText().toString();

            //comprobamos que no haya valores vacios
            if (valor1.isEmpty() || valor2.isEmpty()) {
                Toast.makeText(this, getString(R.string.valorVacio), Toast.LENGTH_SHORT).show();
            }
            // Convertir valores
            else {
                int v1 = Integer.parseInt(valor1);
                int v2 = Integer.parseInt(valor2);
                // Sumar valores
                int resultado = v1 + v2;
                // Mostrar resultado
                textoResultado.setText("Resultado suma: " + resultado);
            }

            //si la calculadora esta apagada lanzamos mensaje avisandolo
        } else {
            Toast.makeText(this, getString(R.string.encenderPrograma), Toast.LENGTH_SHORT).show();
        }
    }

    //método que hace la resta de dos numeros
    public void resta (View vista) {

        //Comprobamos que la calculadora este encendida
        if (tbEncendido.isChecked()) {
            // Obtener valor 1
            String valor1 = editTextValor1.getText().toString();
            // Obtener valor 2
            String valor2 = editTextValor2.getText().toString();

            // Comprobamos que no haya valores vacios
            if (valor1.isEmpty() || valor2.isEmpty()) {
                Toast.makeText(this, getString(R.string.valorVacio), Toast.LENGTH_SHORT).show();
            } else {
                int v1 = Integer.parseInt(valor1);
                int v2 = Integer.parseInt(valor2);
                // Sumar valores
                int resultado = v1 - v2;
                // Mostrar resultado
                textoResultado.setText("Resultado resta: " + resultado);
            }
        }
        else {
            Toast.makeText(this, getString(R.string.encenderPrograma), Toast.LENGTH_SHORT).show();
        }
    }

    //metodo que hace la multiplicacion de dos numeros
    public void multiplicacion (View vista) {

        //si la calculadora esta encendida
        if (tbEncendido.isChecked()) {
            // Obtener valor 1
            String valor1 = editTextValor1.getText().toString();
            // Obtener valor 2
            String valor2 = editTextValor2.getText().toString();
            // Comporbamos que no haya valores vacios
            if (valor1.isEmpty() || valor2.isEmpty()) {
                Toast.makeText(this, getString(R.string.valorVacio), Toast.LENGTH_SHORT).show();
            } else {
                int v1 = Integer.parseInt(valor1);
                int v2 = Integer.parseInt(valor2);
                // Sumar valores
                int resultado = v1 * v2;
                // Mostrar resultado
                textoResultado.setText("Resultado multiplicacion: " + resultado);
            }

        }
        //si la calculadora esta apagada lanzamos un mensaje
        else {
            Toast.makeText(this, getString(R.string.encenderPrograma), Toast.LENGTH_SHORT).show();
        }
    }

    //metodo que divide dos numeros y comprueba que no se divida entre cero
    public void division (View vista) {

        //comprobamos que la calculadora este encencida
        if (tbEncendido.isChecked()) {
            // Obtener valor 1
            String valor1 = editTextValor1.getText().toString();
            // Obtener valor 2
            String valor2 = editTextValor2.getText().toString();

            //si intentamos dividir entre 0 sale un mensaje de error
            if (valor2.equals("0")) {
                Toast.makeText(this, getString(R.string.divCero), Toast.LENGTH_SHORT).show();

            //si alguno de los valores esta vacio lanzamos un mensaje de error
            } else if (valor1.isEmpty() || valor2.isEmpty()) {
                Toast.makeText(this, getString(R.string.valorVacio), Toast.LENGTH_SHORT).show();

            //si no intentamos dvidivir entre 0 y no hay valores en blanco entonces dividimos
            } else {
                // Convertir valores
                int v1 = Integer.parseInt(valor1);
                int v2 = Integer.parseInt(valor2);

                // dividir valores
                int resultado = v1 / v2;

                // Mostrar resultado
                textoResultado.setText("Resultado division: " + resultado);
            }

        }

        //si la calculadora esta apaada lanzamos mensaje
        else {
            Toast.makeText(this, getString(R.string.encenderPrograma), Toast.LENGTH_SHORT).show();
        }
    }

    //metodo que vuelve a la pagina principal cerrando esta activity
    public void paginaPrincipal (View vista){

        finish();
    }

}