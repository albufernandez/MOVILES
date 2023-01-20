package com.example.appalba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //declaramos las variables
    private EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inciamos variables
        etNombre= findViewById(R.id.etNombre);
    }

    //creacion del menu
    public boolean onCreateOptionsMenu( Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    //coge la opcion del menu que clicamos y hace el metodo que corresponde
    //para abrir la activity
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();

        switch(id) {
            case R.id.miSalir:
                salir(null);
                break;
            case R.id.miAcercaDe:
                abrirAcercaDe(null);
                break;
            case R.id.miVarios:
                abrirVarios(null);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //metodo para abrir la alctivity varios
    public void abrirVarios(View vista){
        Intent i = new Intent(this, activity_varios.class);
        startActivity(i);
    }

    //metodo para abrir la alctivity calculadora
    public void abrirCalculadora(View vista) {
        Intent i = new Intent(this, Calculadora.class);
        startActivity(i);
        Log.d("boton calculadora", "se ha abierto la calculadora");
    }

    //metodo para abrir la alctivity numero par o impar
    public void abrirParImpar (View vista){
        Intent i = new Intent(this, ParImparActivity.class);
        startActivity(i);
        Log.d("boton calculadora", "se ha abierto par impar");
    }

    //metodo para abrir la alctivity numero primo
    public void abrirPrimo(View vista){
        Intent i = new Intent(this,PrimoActivity.class);
        startActivity(i);
        Log.d("boton calculadora", "se ha abierto primo");
    }

    //metodo para abrir la alctivity test
    public void abrirTest(View vista){
        Intent i = new Intent(this,TestActivity.class);
        startActivity(i);
        Log.d("boton calculadora", "se ha abierto test");
    }

    //metodo para abrir acerca de
    public void abrirAcercaDe(View vista){
        Intent i = new Intent(this,AcercaDeActivity.class);

        //pertenece a la comunicacion de intenciones se crea un objeto bundle
        Bundle b  = new Bundle();
        //cogemos el valor del etNombre
        String nombre = String.valueOf(etNombre.getText());
        //lo insertamos en el intent que luego recogemos en la activity acercade
        b.putString("nombre", nombre);
        i.putExtras(b);

        //arrancamos la intencion
        startActivity(i);
        Log.d("boton calculadora", "se ha abierto acerca de");
    }

    //metodo para abrir la alctivity numero aleatorio
    public void abirNaleatorio (View vista){
        Intent i = new Intent(this,activity_aleatorio.class);
        startActivity(i);
        Log.d("boton calculadora", "se ha abierto numero aleatorio");
    }

    //metodo para salir de la app
    public void salir (View vista) {
        //lanza un mensaje para confirmar que realmente queremos salir de la aplicacion
        new AlertDialog.Builder(this)
                .setTitle("Salir")
                .setMessage("¿Deseas realmente salir?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {

        //recoge con el onclick si decimos si o no y cierrra o no la app
            public void onClick(DialogInterface dialogInterface, int i){
                finish();
            }
        })
                .setNegativeButton("No", null)
                .show();
    }


}

