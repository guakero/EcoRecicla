package com.dario.ecorecicla;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    Button iniciarSesionBtn ;
    Button registrarseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        iniciarSesionBtn = findViewById(R.id.iniciarSesionBtn);
        registrarseBtn = findViewById(R.id.registrarseBtn);


        iniciarSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarIniciarSesion();
            }
        });

        registrarseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarRegistrarse();
            }
        });
    }

    private void lanzarRegistrarse() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);

    }

    private void lanzarIniciarSesion() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

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