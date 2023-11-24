package com.dario.ecorecicla.modelos;

import java.util.ArrayList;

public class YearClass {

    private String _year;
    private ArrayList<String[]> _datosPorMes = new ArrayList<>();


    public YearClass(String year, String[] datosPorMes ){
        _year = year;
        _datosPorMes.add(datosPorMes);
    }

    public String get_year() {
        return _year;
    }

    public void set_year(String _year) {
        this._year = _year;
    }

    public void setmes(String[] datosMesList){
        _datosPorMes.add(datosMesList);
    }

    public ArrayList getCantidadesPorYear (){

        ArrayList<Float> cantidades= new ArrayList<>(12);

            for (int i = 0; i < 13; i++){
                        cantidades.add(i,0f);
            }

        for (String [] datosMesIterado :_datosPorMes){
                cantidades.set(Integer.parseInt(datosMesIterado[1]), Float.parseFloat(datosMesIterado[3]));
        }

        return cantidades;
    }

    public String getPromedio(){
            int sumaMeses = 0;
            int promedio;
            String unidad ="";
        for (String[] datosmes :_datosPorMes) {
            sumaMeses += Integer.parseInt(datosmes[3]);
            unidad = datosmes[4];
        }

            promedio = sumaMeses/_datosPorMes.size();
            String log = String.valueOf(sumaMeses)+"/"+String.valueOf(_datosPorMes.size());
            Herramientas.logpy(log);
            return String.valueOf(promedio) +" "+ unidad;
        }


}
