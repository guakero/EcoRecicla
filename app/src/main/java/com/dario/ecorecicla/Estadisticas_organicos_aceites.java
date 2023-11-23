package com.dario.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;

import com.dario.ecorecicla.modelos.FileManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.charts.LineChart;

public class Estadisticas_organicos_aceites extends AppCompatActivity {

    // variable for our bar chart
    BarChart barChart;

    // variable for our bar data.
    BarData barData;

    // variable for our bar data set.
    BarDataSet barDataSet;

    // array list for storing entries.
    ArrayList barEntriesArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas_organicos_aceites);

//        BarChart chart = (BarChart) findViewById(R.id.estadisticaOrganicos);
        // initializing variable for bar chart.
        barChart = findViewById(R.id.estadisticaOrganicos);
        getBarEntries();

        barDataSet = new BarDataSet(barEntriesArrayList, "Geeks for Geeks");

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

        List<String> data = new ArrayList<>();
        data.add("Organiscos");
        data.add("enero");
        data.add("10lilos");

        List<Entry> entries = new ArrayList<Entry>();



    }



    private void getBarEntries() {
        String nombreArchivo = "/"+ "Organicos" + ".txt";
        // leemos los datos y los partimos por dada mes usando el reg ex "\n "
        File file = FileManager.crearAbrirArchivo(getFilesDir(),nombreArchivo);
        String datos = FileManager.LeerArchivo(file);
        String[] datosePorMes = datos.split("\n ");


        // variables para el array
        float x = 1f;

        int index = 0;
        float cantidad = 0;
        String[] datosMeslist;

        // se crea el array para los datos de la grafica
        barEntriesArrayList = new ArrayList<>();

        while (x < 13f) {
            // obtenemos el index de los datospormes para ponerlos en 0 si no existen
            int idexTotales = datosePorMes.length;

            if (idexTotales<x){
                cantidad = 0;
            }else{
                // partimos de cada mes en un arreglo para sacar la cantidad y la castiamos a float
                datosMeslist = datosePorMes[index].split(", ");
                cantidad = Float.parseFloat(datosMeslist[3]);
            }



            x += 1f;
            index +=1;
            // adding new entry to our array list with bar
            // entry and passing x and y axis value to it.
            barEntriesArrayList.add(new BarEntry(x, cantidad));

        }
    }
}