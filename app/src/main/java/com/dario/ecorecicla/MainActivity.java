package com.dario.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {
    boolean loginStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creamos un objeto sharedpreferences par cargar las preferenicas
        SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(this);
        loginStatus = preferencias.getBoolean("Log Out status",false);

        //Si el loginStatus es true vamos a home si no a welcome
        if(loginStatus){
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
            finish();

        }else {
            Intent intent = new Intent(this, Welcome.class);
            startActivity(intent);
            finish();
        }
    }
}