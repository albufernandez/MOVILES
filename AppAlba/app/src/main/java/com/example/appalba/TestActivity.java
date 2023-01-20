package com.example.appalba;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity<imageView> extends AppCompatActivity {

    //declaramos las variables
    private Button btBorrar, btResolver, btLimpiarP1, btLimpiarP2;

    private Switch swTodas;

    private ImageView iv1Bien, iv2Bien, iv3Bien, iv4Bien;

    private TextView tvResultado;

    private RadioButton rb1_1, rb1_2, rb1_3;

    private RadioButton rb2_1, rb2_2, rb2_3;

    private CheckBox cb3_1, cb3_2, cb3_3;

    private CheckBox cb4_1, cb4_2, cb4_3;

    private Spinner spinner5, spinner6;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);


        //iniciamos las variables
        btBorrar = findViewById(R.id.btAcerca); btResolver = findViewById(R.id.btResolver); btLimpiarP1 = findViewById(R.id.btLimpiarP1); btLimpiarP2 = findViewById(R.id.btLimpiarP2);

        swTodas = findViewById(R.id.swTodas);

        iv1Bien = findViewById(R.id.iv1Bien); iv2Bien = findViewById(R.id.iv2Bien); iv3Bien = findViewById(R.id.iv3Bien); iv4Bien = findViewById(R.id.iv4Bien);

        tvResultado = findViewById(R.id.tvResultado);

        rb1_1 = findViewById(R.id.rb1_1); rb1_2 = findViewById(R.id.rb1_2); rb1_3 = findViewById(R.id.rb1_3);

        rb2_1 = findViewById(R.id.rb2_1); rb2_2 = findViewById(R.id.rb2_2); rb2_3 = findViewById(R.id.rb2_3);

        cb3_1 = findViewById(R.id.cb3_1); cb3_2 = findViewById(R.id.cb3_2); cb3_3 = findViewById(R.id.cb3_3);

        cb4_1 = findViewById(R.id.cb4_1); cb4_2 = findViewById(R.id.cb4_2); cb4_3 = findViewById(R.id.cb4_3);

        spinner5 = findViewById(R.id.spinner5); spinner6 = findViewById(R.id.spinner6);

    }


    //metodo que borra las respuestas seleccionadas (las deja como estaban al principio)
    public void borrarRespuestas(View vista) {

        rb1_1.setChecked(false); rb1_2.setChecked(false); rb1_3.setChecked(false);

        rb2_1.setChecked(false); rb2_2.setChecked(false); rb2_3.setChecked(false);

        cb3_1.setChecked(false); cb3_2.setChecked(false); cb3_3.setChecked(false);

        cb4_1.setChecked(false); cb4_2.setChecked(false); cb4_3.setChecked(false);

        spinner5.setSelection(0); spinner6.setSelection(0);

    }

    //metodo que borra la respuesta a la pregunta 1
    public void borrarP1 (View vista){

        if (rb1_1.isChecked()||rb1_2.isChecked()||rb1_3.isChecked()){
            rb1_1.setChecked(false);
            rb1_2.setChecked(false);
            rb1_3.setChecked(false);
        }
        else {
            Toast.makeText(this, getString(R.string.respuestaBorrar), Toast.LENGTH_SHORT).show();
        }
    }

    //metodo que borra la respuesta a la pregunta 2
    public void borrarP2 (View vista){

        if (rb2_1.isChecked()||rb2_2.isChecked()||rb2_3.isChecked()){
            rb2_1.setChecked(false);
            rb2_2.setChecked(false);
            rb2_3.setChecked(false);
        }
        else {
            Toast.makeText(this, getString(R.string.respuestaBorrar), Toast.LENGTH_SHORT).show();
        }
    }

    //comprueba si la pregunta 1 esta bien y en caso de estar bien enseña una imagen
    public void comprobarP1 (){
        if (rb1_2.isChecked()) {
            iv1Bien.setVisibility(View.VISIBLE);
        }
    }

    //comprueba si la pregunta 2 esta bien y en caso de estar bien enseña una imagen
    public void comprobarP2(){
        if (rb2_2.isChecked()) {
            iv2Bien.setVisibility(View.VISIBLE);
        }
    }

    //comprueba si la pregunta 3 esta bien y en caso de estar bien enseña una imagen
    public void comprobarP3 (){
        if (cb3_1.isChecked() && cb3_3.isChecked()) {
            iv3Bien.setVisibility(View.VISIBLE);
        }
    }

    //comprueba si la pregunta 4 esta bien y en caso de estar bien enseña una imagen
    public void comprobarP4 (){
        if (cb4_2.isChecked() && cb4_3.isChecked()) {
            iv4Bien.setVisibility(View.VISIBLE);
        }
    }


    //metodo que comprueba que respuestas esta bien y da un resultado
    public void comprobarResultado(View vista) {

        int contadorTodas = 0;

        int respuesta5 = spinner5.getSelectedItemPosition();
        int respuesta6 = spinner6.getSelectedItemPosition();


        //comprobamos que todas esten seleccionadas
        if (swTodas.isChecked()) {

            if (rb1_1.isChecked() || rb1_2.isChecked() || rb1_3.isChecked()) {
                contadorTodas++;
            }
            if (rb2_1.isChecked() || rb2_2.isChecked() || rb2_3.isChecked()) {
                contadorTodas++;
            }
            if (cb3_1.isChecked() || cb3_2.isChecked() || cb3_3.isChecked()) {
                contadorTodas++;
            }
            if (cb4_1.isChecked() || cb4_2.isChecked() || cb4_3.isChecked()) {
                contadorTodas++;
            }

            //comprobamos las que estan bien
            if (contadorTodas == 4) {
                int contador = 0;

                if (rb1_2.isChecked()) {
                    contador++;
                }
                if (rb2_2.isChecked()) {
                    contador++;
                }
                if (cb3_1.isChecked() && cb3_3.isChecked()) {
                    contador++;
                }
                if (cb4_2.isChecked() && cb4_3.isChecked()) {
                    contador++;
                }
                if (respuesta5 == 1) {
                    contador++;
                }
                if (respuesta6 == 0) {
                    contador++;
                }

                tvResultado.setText("Resultado:" + contador);

                comprobarP1();
                comprobarP2();
                comprobarP3();
                comprobarP4();

            } else {
                //Si no estan todas seleccionadas lanza un error
                Toast.makeText(this, getString(R.string.contestarPreguntas), Toast.LENGTH_SHORT).show();
            }

        }

        //en caso de que no tengamos que contestarlas todas comprobamos las que estan bien
        else {

            int contador = 0;

            if (rb1_2.isChecked()) {
                contador++;
            }
            if (rb2_2.isChecked()) {
                contador++;
            }
            if (cb3_1.isChecked() && cb3_3.isChecked()) {
                contador++;
            }
            if (cb4_2.isChecked() && cb4_3.isChecked()) {
                contador++;
            }
            if (respuesta5 == 1) {
                contador++;
            }
            if (respuesta6 == 0) {
                contador++;
            }
            tvResultado.setText("Resultado:" + contador);

            comprobarP1();
            comprobarP2();
            comprobarP3();
            comprobarP4();
        }
    }

    public void volverPrincipal(View vista){
        finish();
    }
}