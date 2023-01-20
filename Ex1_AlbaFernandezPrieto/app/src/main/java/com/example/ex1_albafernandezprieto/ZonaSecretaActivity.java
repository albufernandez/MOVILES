package com.example.ex1_albafernandezprieto;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class ZonaSecretaActivity extends AppCompatActivity {

    private SoundPool sp;
    private int idSonido;
    private Spinner spSintonias;
    private MediaPlayer mpCancion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona_secreta);


        spSintonias = findViewById(R.id.spSintonias);


    }

    //metodo que reproduce la cancion seleccionada y si ya estuviera alguna en reproduccion para la anterior
    public void reproducir(View vista) {

            //este codigo para la cancion que se estuviera reproduciendo previamente
            if (mpCancion != null) {
                mpCancion.stop();
            }
            //reproduce la cancion1 (si su radio button esta seleccionado)
            if (spSintonias.getSelectedItemPosition() ==0){
                mpCancion = MediaPlayer.create(this, R.raw.sintonia1);
                mpCancion.start();

            }

        if (spSintonias.getSelectedItemPosition() ==1){
            mpCancion = MediaPlayer.create(this, R.raw.sintonia2);
            mpCancion.start();

        }

    }

    //metodo que pausa la cancion
    public void parar(View vista) {
        if (mpCancion.isPlaying())mpCancion.pause();
        else {
            mpCancion.start();
        }
    }

    //metodo que hace stop a la cancion
    public void stop(View vista) {
        mpCancion.stop();
    }




    //metodo que cierra esta activity y volvemos a la main
    public void salir (View vista){
        mpCancion.release();
        finish();
    }
}