package com.dario.ecorecicla;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dario.ecorecicla.modelos.BarchartObj;
import com.dario.ecorecicla.modelos.Herramientas;
import com.github.mikephil.charting.charts.BarChart;

public class Estadisticas_materiales extends AppCompatActivity {
    private Bundle bundle;
    // variable for our bar chart
    private BarChart barChart;
    private BarChart barChart2;
    private SeekBar yearSeekBar;
    private TextView yearsTv;
    private int indexYear = 0;


    private TextView textViewPromedio;
    private TextView textViewPromedio2;
    private TextView textViewGrafico1;
    private TextView textViewGrafico2;

    private ImageView imageViewMaterial1;
    private ImageView imageViewMaterial2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas_materiales);

        bundle = getIntent().getExtras();
        String nombreMaterial = bundle.getString("material1");
        String nombreMaterial2 = bundle.getString("material2");

        textViewPromedio = findViewById(R.id.promedioTextView);
        textViewPromedio2 = findViewById(R.id.promedio2TextView);
        textViewGrafico1 = findViewById(R.id.texViewGraficos1);
        textViewGrafico2 = findViewById(R.id.texViewGraficos2);

        String TVgraficos1 = "Graficos "+nombreMaterial;
        String Tvgraficos2 = "Graficos " +nombreMaterial2;

        textViewGrafico1.setText(TVgraficos1);
        textViewGrafico2.setText(Tvgraficos2);

        imageViewMaterial1 = findViewById(R.id.imgMaterial1);
        imageViewMaterial2 = findViewById(R.id.imgMaterial2);

        switch (nombreMaterial){
            case "Papel":
                imageViewMaterial1.setImageResource(R.drawable.note_stack_fill0_wght400_grad0_opsz24);
                break;
            case "Electronicos":
                imageViewMaterial1.setImageResource(R.drawable.devices_other_fill0_wght400_grad0_opsz24);
                break;
            case "Vidrio":
                imageViewMaterial1.setImageResource(R.drawable.liquor_fill0_wght400_grad0_opsz24);
                break;
            case "Organicos":
                imageViewMaterial1.setImageResource(R.drawable.compost_fill0_wght400_grad0_opsz24);
                break;
        }

        switch (nombreMaterial2){
            case "Plasticos":
                imageViewMaterial2.setImageResource(R.drawable.local_dining_fill0_wght400_grad0_opsz24);
                break;
            case "Baterias":
                imageViewMaterial2.setImageResource(R.drawable.battery_full_fill0_wght400_grad0_opsz24);
                break;
            case "Textiles":
                imageViewMaterial2.setImageResource(R.drawable.styler_fill0_wght400_grad0_opsz24);
                break;
            case "Aceites":
                imageViewMaterial2.setImageResource(R.drawable.format_color_fill_fill0_wght400_grad0_opsz24);
                break;
        }

        yearsTv = findViewById(R.id.years_Tv);
        yearSeekBar = findViewById(R.id.years_seekbar);
        yearSeekBar.setProgress(2023);


        // inicializamos el componente
        barChart = findViewById(R.id.estadisticaOrganicos);
        barChart2 = findViewById(R.id.estadistica2);
        // si invoca la funcio para crear la grafica
        // con herramientas getshareduser traemos el usuario almacenado en sharedpreferences
        BarchartObj grafico1 = new BarchartObj(indexYear, getFilesDir(),barChart,nombreMaterial, Herramientas.getSharedUser(this));
        BarchartObj grafico2 = new BarchartObj(indexYear,getFilesDir(),barChart2,nombreMaterial2, Herramientas.getSharedUser(this));

        grafico1.crearBarchar();
        grafico2.crearBarchar();
        textViewPromedio.setText(grafico1.getPromedio());
        textViewPromedio2.setText(grafico2.getPromedio());

        int maxYear;
        // determinamos quien tiene mas años y lo ponemos como max en el seekbar
        if(grafico1.getNumberOfYearsRegistred()<grafico2.getNumberOfYearsRegistred() ){
            maxYear = grafico2.getNumberOfYearsRegistred();
        }else {
            maxYear = grafico1.getNumberOfYearsRegistred();
        }
        yearSeekBar.setMax(2022+maxYear);

        yearSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                yearsTv.setText(String.valueOf(progress));
                // el idexYear nos indica en print barras que año imprimir
                indexYear = progress -2023;

                if(grafico1.getNumberOfYearsRegistred()>indexYear){
                    //enviamos a la funcion que borra los datos
                    grafico1.clear();
                    //se vuelve a cargar con el nuevo indice
                    grafico1.setIndexYear(indexYear);
                    grafico1.crearBarchar();
                }
                if(grafico2.getNumberOfYearsRegistred()>indexYear){
                    grafico2.clear();
                    grafico2.setIndexYear(indexYear);
                    grafico2.crearBarchar();

                }else {
                    grafico2.clear();
//                    grafico2.clearBars();
                }



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }











}

