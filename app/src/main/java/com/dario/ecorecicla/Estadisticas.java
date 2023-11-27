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

    public String material1;
    public String material2;

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
                material1 = "Papel";
                material2 = "Plasticos";
                intentStadisticas(material1, material2);
            }
        });

        btnEstadisticasVidrioTextiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                material1 = "Vidrio";
                material2 = "Textiles";
                intentStadisticas(material1, material2);
            }
        });

        btnEstadisticasElectronicoBaterias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                material1 = "Electronicos";
                material2 = "Baterias";
                intentStadisticas(material1, material2);
            }
        });

        btnEstadisticasOrganicosAceites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                material1 = "Organicos";
                material2 = "Aceite";
                intentStadisticas(material1, material2);
            }
        });


    }

    private void intentStadisticas(String material1, String material2) {
        startActivity(new Intent(Estadisticas.this, Estadisticas_materiales.class).putExtra("material1",material1).putExtra("material2",material2));
    }


}