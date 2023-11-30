package com.dario.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class RegistroCompletado extends AppCompatActivity {

    public boolean loginStatus;
    public Button btnHome;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_completado);

        // se genera el objeto preferencias de tipo shared preferences
        SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(this);
        loginStatus = preferencias.getBoolean("Log Out status",false);
        // se genera un objeto editor de shared preferences para editarlas en el boton de abajo
        SharedPreferences.Editor editor = preferencias.edit();

        btnHome = findViewById(R.id.btnHome);
        String user = bundle.getString("user");
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("Log Out status", true);
                editor.putString("user",user);
                editor.apply();

                Intent intent = new Intent(RegistroCompletado.this, Home.class);
                startActivity(intent);
                finish();
            }
        });
    }


}