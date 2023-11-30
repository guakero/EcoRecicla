package com.dario.ecorecicla.modelos;

import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BarchartObj {
    private BarChart barChart;
    // variable for our bar data.
    private BarData barData;
    // variable for our bar data set.
    private BarDataSet barDataSet;
    // array list for storing entries.
    private ArrayList barEntriesArrayList;
    private List<YearClass> yearsClasList = new ArrayList<>();
    int numberOfYearsRegistred;
    int indexYear;
    private String promedio;
    private File path;
    private String nombreMaterial;

    private String user;

    public BarchartObj (int indexYear, File path, BarChart barChart, String nombreMaterial, String user){
        this.indexYear = indexYear;
        this.path = path;
        this.barChart = barChart;
        this.nombreMaterial = nombreMaterial;
        this.user = user;

    }

    public void setIndexYear(int indexYear) {
        this.indexYear = indexYear;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public int getNumberOfYearsRegistred() {
        return numberOfYearsRegistred;
    }

    public void crearBarchar(){

        getBarEntries(this.user);

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

        Legend legend = barChart.getLegend();
        legend.setFormSize(10f);
    }

    public void crearEmtyBarchar(){


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

        Legend legend = barChart.getLegend();
        legend.setFormSize(10f);
    }

    private void printarBarras(List<YearClass> yearsClasList) {

        barEntriesArrayList.clear();
        numberOfYearsRegistred = yearsClasList.size();
        // hacemos la variable del objeto para que sea mas claro
        YearClass datosAnualesList = yearsClasList.get(indexYear);
        // si es un año vacio se genera una grafica vacia
        // si no se hace una grafica con los datos obtenidos
        if(datosAnualesList.isEmtyYear()){
            float x = 0f;
            float cantidad = 0;

            while (x < 12f) {
                cantidad = 0;
                // adding new entry to our array list with bar
                // entry and passing x and y axis value to it.
                barEntriesArrayList.add(new BarEntry(x, cantidad));
                x += 1f;

            }
        }else {
            promedio = datosAnualesList.getPromedio();

            ArrayList<Float> cantidadesYear = new ArrayList<>(datosAnualesList.getCantidadesPorYear());

            float x = 0f;
            float cantidad = 0;
            int index = 1;

            while (x < 12f) {

                cantidad = cantidadesYear.get(index);
                // adding new entry to our array list with bar
                // entry and passing x and y axis value to it.
                barEntriesArrayList.add(new BarEntry(x, cantidad));
                index += 1;
                x += 1f;

            }
        }
    }
    public void clear() {
        barEntriesArrayList.clear();

        //se limpia el barchar
        barChart.clear();

    }

    private void getBarEntries(String user) {

        // se crea el array para los datos de la grafica
        barEntriesArrayList = new ArrayList<>();
        // si no hay años en yearsClasList
        if (yearsClasList.isEmpty()){
            List<String> yearsList = new ArrayList<>();
            String nombreArchivo = "/" + nombreMaterial +"_"+user+".txt";
            // si el archivo existe
            // leemos los datos y los partimos por dada mes usando el reg ex "\n "
            if( FileManager.VerificarExistenciaArchivo(path,nombreArchivo)){
                Herramientas.logpy("Archivo verificado");
                File file = FileManager.crearAbrirArchivo(path, nombreArchivo);
                String datos = FileManager.LeerArchivo(file);
                String[] datosPorMeses;
                datosPorMeses = datos.split("\n ");

                String[] datosMeslist;

                for (String datoMes : datosPorMeses) {
                    // partimos de cada mes en un arreglo para sacar la cantidad y la castiamos a float
                    datosMeslist = datoMes.split(", ");

                    // si no existe el año en la lista años creamos objeto años y los agregamos a listas
                    if (datosMeslist.length < 2) {
                        // saltamos un bug que genera espacio en la data
                    } else if (!yearsList.contains(datosMeslist[2])) {
                        YearClass newyear = new YearClass(datosMeslist[2], datosMeslist);
                        newyear.setEmtyYear(false);
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
            }else {
                // si el archivo txt no ha sido creado crea un año vacio y lo agrega a
                // la lista de clases años
                YearClass newyear = new YearClass("2023");
                yearsClasList.add(newyear);
            }

        }


        // variables para el array
        printarBarras(yearsClasList);

    }
}
