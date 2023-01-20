package com.example.ex1_albafernandezprieto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaramos las variables
    private EditText etUsuario;
    private EditText etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///iniciamos las variables
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);

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
            case R.id.miCalculadora:
                abrirCalculadora(null);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    //metodo para abrir la alctivity Calculadora
    public void abrirCalculadora(View vista) {
        Intent i = new Intent(this, CalculadoraActivity.class);
        startActivity(i);
    }

    //metodo para abrir la activity ZonaSecrea
    public void abrirZonaSecreta(View vista) {

        String usuario = String.valueOf(etUsuario.getText());
        String password = String.valueOf(etPassword.getText());

        //comprobamos que no haya algun valor vacio
        if (usuario.equals("") || password.equals("")) {
            Toast.makeText(this, "Alguna credencial vacía", Toast.LENGTH_SHORT).show();
        }
        //si no hay ninguno vacio
        else {
        //comprobamos que las credenciales sean las correctas
        if (usuario.equals("granjero") && password.equals("gallinas5")) {
            Intent i = new Intent(this, ZonaSecretaActivity.class);
            startActivity(i);
            } else Toast.makeText(this, "credenciales erróneas", Toast.LENGTH_SHORT).show();
         }

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