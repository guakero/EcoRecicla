package com.dario.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dario.ecorecicla.modelos.Materiales;

public class RegistroDeReciclaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_de_reciclaje);

        Materiales material = new Materiales("Papel","Enero",20);
        Materiales.guardarDatos(getFilesDir(),material);
    }
}