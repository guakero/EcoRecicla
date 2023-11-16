package com.dario.ecorecicla;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dario.ecorecicla.modelos.FileManager;
import com.shawnlin.numberpicker.NumberPicker;

import com.dario.ecorecicla.modelos.Materiales;

import java.util.Locale;

public class RegistroDeReciclaje extends AppCompatActivity {

    private SeekBar cantidadSeekbar;
    private NumberPicker numberPickerMes;
    private NumberPicker numberPickerYear;
    private TextView cantidadTV;
    private Button registrarBtn;


    private int cantidad;

    private ImageButton btnRegistroPapel;
    private ImageButton btnRegistroPlasticos;
    private ImageButton btnRegistroElectronicos;
    private ImageButton btnRegistroAceite;
    private ImageButton btnRegistroVidrio;
    private ImageButton btnRegistroOrganicos;
    private ImageButton btnRegistroBaterias;
    private ImageButton btnRegistroTextiles;
    private TextView seleccionRegistroTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_de_reciclaje);

        numberPickerMes = findViewById(R.id.timeSelektaMes);
        numberPickerYear = findViewById(R.id.timeSelektaYear);
        cantidadSeekbar = findViewById(R.id.cantidad_seekbar);
        cantidadTV = findViewById(R.id.cantidadTV);
        registrarBtn = findViewById(R.id.buttonRegistrarReciclaje);
        btnRegistroPapel = findViewById(R.id.btnPapelRegistro);
        btnRegistroAceite = findViewById(R.id.btnAceiteRegistro);
        btnRegistroBaterias = findViewById(R.id.btnBateriasRegistro);
        btnRegistroElectronicos = findViewById(R.id.btnElectronicosRegistro);
        btnRegistroOrganicos = findViewById(R.id.btnOrganicosRegistro);
        btnRegistroPlasticos = findViewById(R.id.btnPlasticoRegistro);
        btnRegistroTextiles = findViewById(R.id.btnTextilesRegistro);
        btnRegistroVidrio = findViewById(R.id.btnVidrioRegistro);
        seleccionRegistroTV = findViewById(R.id.tvSeleccionRegistro);






        numberPickerMes.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });

        numberPickerYear.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {


            }
        });

        cantidadSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                cantidadTV.setText(String.valueOf(progress));
                cantidad = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        registrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mes = numberPickerMes.getValue();
                int year = numberPickerYear.getValue();
                String materialStr = (String) seleccionRegistroTV.getText();
                String datosLeidos = FileManager.LeerArchivo()
                Materiales material = new Materiales(materialStr, mes, year,cantidad);
                Materiales.guardarDatos(getFilesDir(), material);
            }

        });

        btnRegistroPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionRegistroTV.setText("Papel");

            }
        });
    }
}