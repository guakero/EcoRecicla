package com.dario.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    boolean loginStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creamos un objeto sharedpreferences par cargar las preferenicas
        SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(this);
        loginStatus = preferencias.getBoolean("Log Out status",false);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                //Si el loginStatus es true vamos a home si no a welcome
                Intent intent;
                if(loginStatus){
                    intent = new Intent(MainActivity.this, Home.class);

                }else {
                    intent = new Intent(MainActivity.this, Welcome.class);
                }
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(tarea, 3000);



    }
}