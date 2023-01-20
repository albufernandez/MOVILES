package com.example.appalba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

public class activity_varios<editText> extends AppCompatActivity {

    //declaramos las variables
    private EditText etVariosPalabra;
    private EditText etVariosPagina;

    private RadioButton rbC1, rbC2, rbC3, rbV1, rbV2, rbV3;

    private SoundPool sp;
    private int idSonido;

    private MediaPlayer mpCancion;
    private VideoView video;
    private MediaRecorder grabacion;

    private String vacio ="";
    private String salida=null;
    boolean grabando = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varios);

        //iniciamos las variables
        etVariosPalabra = findViewById(R.id.etVariosPalabra);
        etVariosPagina = findViewById(R.id.etVariosPagina);

        rbC1 = findViewById(R.id.rbC1);
        rbC2 = findViewById(R.id.rbC2);
        rbC3 = findViewById(R.id.rbC3);
        rbV1 = findViewById(R.id.rbV1);
        rbV2 = findViewById(R.id.rbV2);
        rbV3 = findViewById(R.id.rbV3);

        sp = new SoundPool.Builder().build();
        idSonido = sp.load(this, R.raw.golpe, 1);

        video = findViewById(R.id.video);

        //comprobacion de que la app tiene los permisos para acceder al almacenamiento
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity_varios.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }
    }


    //Metodo que graba audio
    public void grabarAudio(View vista){

        if (grabando == false){
            salida = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Grabacion.mp3"; //ruta y nombre de salida del archivo
            grabacion = new MediaRecorder();//asignacion de nuevo objeto de la clase MediaRecorder
            grabacion.setAudioSource(MediaRecorder.AudioSource.MIC);//Se obtendra el audio de nuestro microfono
            grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);// Formato en el cual se grabara el audio
            grabacion.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);//Codificador de audio
            grabacion.setOutputFile(salida);// ruta donde se guardara el audio que se grabe

            try {

                grabacion.prepare(); //se prepara el estado de la grabacion
                grabacion.start();//se inicia el estado de la grabacion

            } catch(IOException e) {

            }
            Toast.makeText(this,getString(R.string.GrabaAudio), Toast.LENGTH_LONG).show();
            grabando = true;
        }
        else if (grabando == true){
            //si ya estamos grabando y le damos al boton entra por este else
            grabacion.stop(); //paramos de grabar
            grabacion.release(); //liberamos la grabacion para poder grabar otra
            grabacion = null;

            Toast.makeText(this,getString(R.string.AudioGrabado), Toast.LENGTH_LONG).show();
            grabando = false;
        }
    }

    //metodo que reproduce el audio que hemos grabado previamente
    public void reproducirAudio(View vista) {

        //si la ruta tiene algo
        if (salida != null) {

            //creamos objeto tipo mediaplayer
            MediaPlayer mpGrabacion = new MediaPlayer();
            try {

                //preparamos el audio de esa ruta
                mpGrabacion.setDataSource(salida);
                mpGrabacion.prepare();
            } catch (IOException e) {
            }
            //lo reproducimos
            mpGrabacion.start();
            Toast.makeText(this, getString(R.string.audioPlay), Toast.LENGTH_LONG).show();
        }
        //si la ruta no tiene nada es que aun no hemos grabado nada
        else {
            Toast.makeText(this, getString(R.string.insertAudio), Toast.LENGTH_LONG).show();
        }
    }


    //metodo que nos busca la palabra que hemos escrito en Google
    public void buscarGoogle(View vista) {
        String busqueda = etVariosPalabra.getText().toString();
        //comprobamos que hayamos pasado alguna palabra
        if (busqueda.equals(vacio)) {
            Toast.makeText(this, getString(R.string.noPalabra), Toast.LENGTH_SHORT).show();
        } else {
            //intent que nos realiza una busqueda en google abriendo el navegador predeterminado
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
            i.putExtra(SearchManager.QUERY, busqueda);
            startActivity(i);
        }
    }

    //metodo que abre la pagina que le hemos pasado
    public void abrirPagina(View vista) {
        String pagina = etVariosPagina.getText().toString();
        //Comprobamos que hayamos pasado alguna pagina
        if (pagina.equals(vacio)) {
            Toast.makeText(this, getString(R.string.noPagina), Toast.LENGTH_SHORT).show();
        }
        //intent que nos abre una pagina web
        else { String web = "http://www." + pagina + ".com";
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            startActivity(i);

        }
    }


    //metodo que reproduce la cancion seleccionada y si ya estuviera alguna en reproduccion para la anterior
    public void reproducir(View vista) {

        if (rbC1.isChecked() || rbC2.isChecked() || rbC3.isChecked()) {

            //este codigo para la cancion que se estuviera reproduciendo previamente
            if (mpCancion != null) {
                mpCancion.stop();
            }
            //reproduce la cancion1 (si su radio button esta seleccionado)
            if (rbC1.isChecked()) {
                mpCancion = MediaPlayer.create(this, R.raw.cancion1);
                mpCancion.start();
            }
            //reproduce la cancion2 (si su radio button esta seleccionado)
            if (rbC2.isChecked()) {
                mpCancion = MediaPlayer.create(this, R.raw.cancion2);
                mpCancion.start();
            }
            //reproduce la cancion3 (si su radio button esta seleccionado)
            if (rbC3.isChecked()) {
                mpCancion = MediaPlayer.create(this, R.raw.cancion3);
                mpCancion.start();
            }
        } else {
            Toast.makeText(this, getString(R.string.escogerCancion), Toast.LENGTH_SHORT).show();
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

    //metodo que para la reproduccion de cualquier cancion y/o video y cierra esta activity volviendo a la main
    public void salir(View vista) {
        video.stopPlayback();
        mpCancion.release();
        finish();
    }

    //metodo que reproduce el sonido que hemos declarado en el OnCreate para sp
    public void reproducirSonido(View vista) {
        sp.play(idSonido, 1, 1, 1, 0, 0);
    }

    //metodo que reproduce el video que hemos escogido con el radio button
    public void repoducirVideo(View vista) {


        if (rbV1.isChecked() || rbV2.isChecked() || rbV3.isChecked()) {

            //reproduce el video londres (si su radio button esta seleccionado)
            if (rbV1.isChecked()) {
                String ruta1 = "android.resource://" + getPackageName() + "/" + R.raw.londres;
                video.setVideoURI(Uri.parse(ruta1));
                video.start();
            }
            //reproduceel video edimburgo (si su radio button esta seleccionado)
            if (rbV2.isChecked()) {
                String ruta2 = "android.resource://" + getPackageName() + "/" + R.raw.edimburgo;
                video.setVideoURI(Uri.parse(ruta2));
                video.start();
            }
            //reproduce el video nueva york (si su radio button esta seleccionado)
            if (rbV3.isChecked()) {
                String ruta3 = "android.resource://" + getPackageName() + "/" + R.raw.nuevayork;
                video.setVideoURI(Uri.parse(ruta3));
                video.start();

            }
        } else {
            //si no hay ninguno seleccionado nos avisa
            Toast.makeText(this, getString(R.string.escogerVideo), Toast.LENGTH_SHORT).show();

        }
    }

}