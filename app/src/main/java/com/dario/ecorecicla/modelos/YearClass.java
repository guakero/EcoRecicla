package com.dario.ecorecicla.modelos;

import java.util.ArrayList;

public class YearClass {

    private String _year;
    private ArrayList<String[]> _datosPorMes = new ArrayList<>();
    private boolean emtyYear = false;

    public YearClass(String year, String[] datosPorMes ){
        _year = year;
        _datosPorMes.add(datosPorMes);
    }
    public YearClass(String year){
        _year = year;
    }

    public String get_year() {
        return _year;
    }

    public boolean isEmtyYear() {
        return emtyYear;
    }

    public void setEmtyYear(boolean emtyYear) {
        this.emtyYear = emtyYear;
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

        if (_datosPorMes.isEmpty()){
                promedio = 0;
            }else {
            promedio = sumaMeses / _datosPorMes.size();
            }
            return String.valueOf(promedio) +" "+ unidad;
        }


}
