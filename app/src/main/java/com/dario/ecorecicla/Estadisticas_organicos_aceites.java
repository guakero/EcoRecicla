package com.dario.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;

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
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

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
        // creating a new array list
        barEntriesArrayList = new ArrayList<>();

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        barEntriesArrayList.add(new BarEntry(1f, 100));
        barEntriesArrayList.add(new BarEntry(2f, 0));
        barEntriesArrayList.add(new BarEntry(3f, 0));
        barEntriesArrayList.add(new BarEntry(4f, 0));
        barEntriesArrayList.add(new BarEntry(5f, 0));
        barEntriesArrayList.add(new BarEntry(7f, 0));
        barEntriesArrayList.add(new BarEntry(8f, 0));
        barEntriesArrayList.add(new BarEntry(9f, 0));
        barEntriesArrayList.add(new BarEntry(10f, 0));
        barEntriesArrayList.add(new BarEntry(11f, 0));
        barEntriesArrayList.add(new BarEntry(12f, 0));
        barEntriesArrayList.add(new BarEntry(6f, 0));
    }

}