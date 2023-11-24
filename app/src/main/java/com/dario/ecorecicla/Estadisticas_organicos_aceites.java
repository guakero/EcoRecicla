package com.dario.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;


import java.io.File;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dario.ecorecicla.modelos.FileManager;
import com.dario.ecorecicla.modelos.YearClass;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.charts.LineChart;

public class Estadisticas_organicos_aceites extends AppCompatActivity {

    // variable for our bar chart
    private BarChart barChart;

    // variable for our bar data.
    private BarData barData;

    // variable for our bar data set.
    private BarDataSet barDataSet;

    // array list for storing entries.
    private ArrayList barEntriesArrayList;
    private SeekBar yearSeekBar;
    private TextView yearsTv;
    private int indexYear = 0;
    private List<YearClass> yearsClasList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas_organicos_aceites);

        yearsTv = findViewById(R.id.years_Tv);
        yearSeekBar = findViewById(R.id.years_seekbar);
        yearSeekBar.setProgress(2023);

        // inicializamos el componente
        barChart = findViewById(R.id.estadisticaOrganicos);
        // si invoca la funcio para crear la grafica
        crearBarchar();


        yearSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                yearsTv.setText(String.valueOf(progress));
                indexYear += 1;
                //enviamos a la funcion que borra los datos
                clear();
                //se limpia el barchar
                barChart.clear();
                //se vuelve a cargar con el nuevo indice
                crearBarchar();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


    }


    private void getBarEntries() {

        List<String> yearsList = new ArrayList<>();

        String nombreArchivo = "/" + "Organicos" + ".txt";
        // leemos los datos y los partimos por dada mes usando el reg ex "\n "
        File file = FileManager.crearAbrirArchivo(getFilesDir(), nombreArchivo);
        String datos = FileManager.LeerArchivo(file);
        String[] datosPorMeses = datos.split("\n ");

        String[] datosMeslist;

        // se crea el array para los datos de la grafica
        barEntriesArrayList = new ArrayList<>();


        for (String datoMes : datosPorMeses) {
            // partimos de cada mes en un arreglo para sacar la cantidad y la castiamos a float
            datosMeslist = datoMes.split(", ");
            /*            cantidad = Float.parseFloat(datosMeslist[3]);*/

            // si no existe el año en la lista años creamos objeto años y los agregamos a listas
            if (datosMeslist.length < 2) {
                // saltamos un bug que genera espacio en la data
            } else if (!yearsList.contains(datosMeslist[2])) {
                YearClass newyear = new YearClass(datosMeslist[2], datosMeslist);
                yearsList.add(datosMeslist[2]);
                yearsClasList.add(newyear);
                // si existe solo agregamos el mes al año ya existente
            } else {
                int indexy = 0;
                // por cada año en la lista de años ponemos el dato del mes en el año correspondiente
                for (String yearIterado : yearsList) {
                    if (datosMeslist[2].equals(yearsClasList.get(indexy).get_year())) {
                        yearsClasList.get(indexy).setmes(datosMeslist);
                    }
                    indexy = +1;
                }
            }

        }

        // variables para el array
        printarBarras(yearsClasList);

    }


    private void printarBarras(List<YearClass> yearsClasList) {
        barEntriesArrayList.clear();
        int numberOfYearsRegistred = yearsClasList.size();
        YearClass datosAnualesList = yearsClasList.get(indexYear);
        ArrayList<Float> cantidadesYear = new ArrayList<>(datosAnualesList.getCantidadesPorYear());

        float x = 0f;
        float cantidad = 0;
        int index = 0;

        while (x < 13f) {

            x += 1f;
            cantidad = cantidadesYear.get(index);
            index += 1;
            // adding new entry to our array list with bar
            // entry and passing x and y axis value to it.
            barEntriesArrayList.add(new BarEntry(x, cantidad));

        }
    }

    private void clear() {
        barEntriesArrayList.clear();
        float x = 0f;
        float cantidad = 0;
        int index = 0;

        while (x < 13f) {
            x += 1f;
            index += 1;
            // adding new entry to our array list with bar
            // entry and passing x and y axis value to it.
            barEntriesArrayList.add(new BarEntry(x, cantidad));

        }
    }

    private void crearBarchar(){

        getBarEntries();
        barDataSet = new BarDataSet(barEntriesArrayList, "Cantidad por mes");

        // creating a new bar data and
        // passing our bar data set.
        barData = new BarData(barDataSet);

        // below line is to set data
        // to our bar chart.
        barChart.setData(barData);
        // adding color to our bar data set.
        barDataSet.setColors(ColorTemplate.getHoloBlue());

        // setting text color.
        barDataSet.setValueTextColor(Color.BLACK);

        // setting text size
        barDataSet.setValueTextSize(15f);
        barChart.getDescription().setEnabled(false);

    }
}