package com.dario.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Estadisticas extends AppCompatActivity {

    public Button btnEstadisticasPapelyPlasticos;
    public Button btnEstadisticasVidrioTextiles;
    public Button btnEstadisticasElectronicoBaterias;
    public Button btnEstadisticasOrganicosAceites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        btnEstadisticasPapelyPlasticos = findViewById(R.id.btnPapelyPlastico);
        btnEstadisticasVidrioTextiles = findViewById(R.id.btnVidrioYtextiles);
        btnEstadisticasElectronicoBaterias = findViewById(R.id.btnElectronicosyBaterias);
        btnEstadisticasOrganicosAceites = findViewById(R.id.BtnOrganicosyAceite);


        btnEstadisticasPapelyPlasticos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Estadisticas.this, Estadisticas_papel_plastico.class));
            }
        });

        btnEstadisticasVidrioTextiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Estadisticas.this,Estadisticas_vidrio_textiles.class));
            }
        });

        btnEstadisticasElectronicoBaterias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Estadisticas.this, Equipos_electronicos_baterias.class));
            }
        });

        btnEstadisticasOrganicosAceites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Estadisticas.this, Estadisticas_organicos_aceites.class));
            }
        });
    }



}