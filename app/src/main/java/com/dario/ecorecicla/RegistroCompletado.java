package com.dario.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.View;
import android.widget.Button;

import com.dario.ecorecicla.modelos.Herramientas;

public class RegistroCompletado extends AppCompatActivity {

    public boolean loginStatus;
    public Button btnHome;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_completado);
        // se obtiene el login status de shared preferences
        loginStatus = Herramientas.getLoginStatus(this);



        btnHome = findViewById(R.id.btnHome);

        bundle = getIntent().getExtras();
        String user = bundle.getString("user");
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Herramientas.editPreferences(RegistroCompletado.this ,user,true);

                 Intent intent = new Intent(RegistroCompletado.this, Home.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }


}