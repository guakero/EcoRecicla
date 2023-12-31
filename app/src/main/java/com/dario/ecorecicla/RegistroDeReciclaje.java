package com.dario.ecorecicla;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dario.ecorecicla.modelos.FileManager;
import com.dario.ecorecicla.modelos.User;
import com.shawnlin.numberpicker.NumberPicker;

import com.dario.ecorecicla.modelos.Materiales;

import java.io.File;
import java.util.Locale;

public class RegistroDeReciclaje extends AppCompatActivity {

    private SeekBar cantidadSeekbar;
    private NumberPicker numberPickerMes;
    private NumberPicker numberPickerYear;
    private TextView cantidadTV;
    private Button registrarBtn;
    private ImageView imageViewIcon;

    private int cantidad;

    private String unidad;

    private ImageButton btnRegistroPapel;
    private ImageButton btnRegistroPlasticos;
    private ImageButton btnRegistroElectronicos;
    private ImageButton btnRegistroAceite;
    private ImageButton btnRegistroVidrio;
    private ImageButton btnRegistroOrganicos;
    private ImageButton btnRegistroBaterias;
    private ImageButton btnRegistroTextiles;
    private TextView seleccionRegistroTV;
    private RadioButton radioButtonLibras;
    private RadioButton radioButtonKilos;
    private RadioButton radioButtonLitros;
    private RadioButton radioButtonItems;
    private String user;


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
        imageViewIcon = findViewById(R.id.iconRegistro);
        radioButtonLibras = findViewById(R.id.radioBtnLibras);
        radioButtonKilos = findViewById(R.id.radioBtnKilos);
        radioButtonLitros = findViewById(R.id.radioBtnLitros);
        radioButtonItems = findViewById(R.id.radioBtnItems);

        SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(this);
        user = preferencias.getString("user","");


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
                // obtener datos
                int mes = numberPickerMes.getValue();
                int year = numberPickerYear.getValue();
                String materialStr = (String) seleccionRegistroTV.getText();

                // validar selección de material
                if (materialStr.equals("Ninguno")){
                    String alerta = "Por favor seleccione material de reciclaje";
                    alertDialog(alerta, materialStr);
                }
                else{
                    guardarDatos(materialStr,mes,year,cantidad);
                }
            }

        });

        btnRegistroPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionRegistroTV.setText("Papel");
                imageViewIcon.setImageResource(R.drawable.note_stack_fill0_wght400_grad0_opsz24);
                radioButtonLibras.setChecked(true);
                unidad = "Libras";
            }
        });

        btnRegistroPlasticos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionRegistroTV.setText("Plasticos");
                imageViewIcon.setImageResource(R.drawable.local_dining_fill0_wght400_grad0_opsz24);
                radioButtonLibras.setChecked(true);
                unidad = "Libras";
            }
        });

        btnRegistroElectronicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionRegistroTV.setText("Electronicos");
                imageViewIcon.setImageResource(R.drawable.devices_other_fill0_wght400_grad0_opsz24);
                radioButtonItems.setChecked(true);
                unidad = "Items";
            }
        });

        btnRegistroAceite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionRegistroTV.setText("Aceite");
                imageViewIcon.setImageResource(R.drawable.format_color_fill_fill0_wght400_grad0_opsz24);
                radioButtonLitros.setChecked(true);
                unidad = "MLitros";
            }
        });

        btnRegistroVidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionRegistroTV.setText("Vidrio");
                imageViewIcon.setImageResource(R.drawable.liquor_fill0_wght400_grad0_opsz24);
                radioButtonLibras.setChecked(true);
                unidad = "Libras";

            }
        });

        btnRegistroOrganicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionRegistroTV.setText("Organicos");
                imageViewIcon.setImageResource(R.drawable.compost_fill0_wght400_grad0_opsz24);
                radioButtonLibras.setChecked(true);
                unidad = "Libras";
            }
        });

        btnRegistroBaterias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionRegistroTV.setText("Baterias");
                imageViewIcon.setImageResource(R.drawable.battery_full_fill0_wght400_grad0_opsz24);
                radioButtonItems.setChecked(true);
                unidad = "Items";
            }
        });

        btnRegistroTextiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionRegistroTV.setText("Textiles");
                imageViewIcon.setImageResource(R.drawable.styler_fill0_wght400_grad0_opsz24);
                radioButtonItems.setChecked(true);
                unidad = "Items";
            }
        });

        radioButtonLitros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unidad = "MLitros";
            }
        });

        radioButtonLibras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unidad = "Libras";
            }
        });

        radioButtonKilos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unidad = "Kilos";
            }
        });
        radioButtonItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unidad = "Items";
            }
        });
    }

    private void guardarDatos(String materialStr, int mes, int year, int cantidad) {
        String alerta = "";
        // creamos objeto material con el tipo seleccionado
        Materiales material = new Materiales(materialStr, mes, year,cantidad, unidad, user);
        // guardamos datos y obtenemos el status de guardado
        String savestatus = Materiales.guardarDatos(getFilesDir(), material);
        // printiamos resultado
        if (savestatus.equals("Guardado con exito")){
            alerta = "Se ha guardado el archivo exitosamente";

            alertDialog(alerta, materialStr);
        }else {
            alerta = "Los datos ya existen desea sobre escribirlos ?";
            alertDialog2(alerta,materialStr, mes, year,cantidad);
        }

    }

    private void alertDialog (String alerta, String materialStr){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(alerta)
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción al presionar el botón Aceptar
                        leerDatosGuardados(materialStr);
                        dialog.cancel();
                    }
                });
        builder.show();

    }
    private void alertDialog2 (String alerta,String materialStr,int mes, int year, int cantidad){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(alerta)
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción al presionar el botón Aceptar
                        Materiales material = new Materiales(materialStr, mes, year,cantidad, unidad, user);
                        // guardamos datos y obtenemos el status de guardado
                        Materiales.sobrescribirDatos(getFilesDir(), material);
                        leerDatosGuardados(materialStr);
                        dialog.cancel();

                        alertDialog("Archivo modificado",materialStr);

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción al presionar el botón Cancelar

                        dialog.cancel();

                    }
                });
        builder.show();

    }

    private void leerDatosGuardados (String material){

        String nombreArchivo = "/"+"Datos"+material+"_"+user+".txt";

        File fileInput = FileManager.crearAbrirArchivo(getFilesDir(),nombreArchivo);
        String datosLeidos = FileManager.LeerArchivo(fileInput);
        System.out.println(datosLeidos);


    }




}