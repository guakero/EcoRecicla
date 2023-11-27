package com.dario.ecorecicla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Toolbar toolbar;
    public Button categorias;
    public Button registro;
    public Button estadisticas;
    public Button consejos;
    public boolean loginStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        categorias = findViewById(R.id.btnCategorias);
        registro = findViewById(R.id.btnRegistro);
        estadisticas = findViewById(R.id.btnEstadisticas);
        consejos = findViewById(R.id.btnConsejos);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Categorias.class));
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, RegistroDeReciclaje.class));
            }
        });

        estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Estadisticas.class));
            }
        });

        consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Consejos.class));
            }
        });

        PreferenceManager.setDefaultValues(this, R.xml.ajustes, false);
        loadPreferences();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            int id = (item.getItemId());
            if(id == R.id.logOut1){
                Intent intent = new Intent(this, Ajustes.class);
                startActivity(intent );
                return true;
            }else{
                return super.onOptionsItemSelected(item);
            }
    }
    public void loadPreferences (){
        SharedPreferences preferenicas= PreferenceManager.getDefaultSharedPreferences(this);
        loginStatus = preferenicas.getBoolean("Log Out status",false);
        if(!loginStatus){
            Intent intent = new Intent(this, Welcome.class);
            startActivity(intent);
            System.out.println(loginStatus);
        }
        System.out.println(loginStatus);
    }

    public void onRestart()
    {
        super.onRestart();
        loadPreferences();
    }
    @Override
    public void onBackPressed() {
        // Muestra un mensaje de confirmación
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("¿Desea cerrar la aplicación?")
                .setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cierra la aplicación
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // No hace nada
            }
        });

        builder.show();
    }
}