package com.dario.ecorecicla.modelos;

import android.widget.Switch;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Materiales {

    private String material;
    private int mes;
    private int year;
    private int cantidad;


    public Materiales (String material, int mes, int year, int cantidad){
        this.material = material;
        this.mes = mes;
        this.year = year;
        this.cantidad = cantidad;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static String guardarDatos(File file,Materiales materiales){
        int materialesObtenidos = materiales.getCantidad();
        String material = materiales.getMaterial();
        int mes = materiales.getMes();
        int year = materiales.getYear();
        File fileImput;

        String data = material + ", " + mes + ", " + year + ", "+materialesObtenidos;


        switch(material){

            case "Papel":

                fileImput = FileManager.crearArchivo(file,"DatosPapel.txt");

                String DatosLeidos = FileManager.LeerArchivo(fileImput);
                validacionFecha(DatosLeidos, data);
                FileManager.EscrituraArchivo(fileImput,data);
                break;


        }




        return null;
    }

    private static boolean validacionFecha(String datosLeidos, String datosIngredados) {

        Pattern patron = Pattern.compile("^Papel, 1, ([0-9]+), ([0-9]+)$");
        Matcher coincidencia = patron.matcher(datosLeidos);

    }

}
