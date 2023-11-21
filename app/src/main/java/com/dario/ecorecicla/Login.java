package com.dario.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    public Button iniciarSesionBtn;
    public boolean loginStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // se genera el objeto preferencias de tipo shared preferences
        SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(this);
        loginStatus = preferencias.getBoolean("Log Out status",false);
        // se genera un objeto editor de shared preferences para editarlas en el boton de abajo
        SharedPreferences.Editor editor = preferencias.edit();

        iniciarSesionBtn = findViewById(R.id.btnIniciarSesion);

        iniciarSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // se edita el shared preference luego lo movemos a un condicional
                editor.putBoolean("Log Out status", true);
                editor.apply();

                startActivity(new Intent(Login.this, Home.class));
                finish();

            }


        });
    }


}