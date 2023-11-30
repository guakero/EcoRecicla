package com.dario.ecorecicla.modelos;

import android.view.Gravity;
import android.widget.Switch;
import android.widget.Toast;

import com.dario.ecorecicla.RegistroDeReciclaje;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Materiales {

    private String material;
    private String unidad;
    private String nombre;
    private int mes;
    private int year;
    private int cantidad;


    public Materiales (String material, int mes, int year, int cantidad, String unidad, String nombre){
        this.material = material;
        this.mes = mes;
        this.year = year;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public static String guardarDatos(File file, Materiales materiales){
        int materialesObtenidos = materiales.getCantidad();
        String material = materiales.getMaterial();
        int mes = materiales.getMes();
        int year = materiales.getYear();
        String nombre = materiales.getNombre();
        String unidad = materiales.getUnidad();
        File fileInput;

        String data = material + ", " + mes + ", " + year + ", "+materialesObtenidos+ ", "+unidad;
        String mesYear = mes + ", " + year;
        String saveStatus = "";
        String datosLeidos = "";
        // construimos nombre archivo
        String nombreArchivo = "/"+ material +"_"+nombre+".txt";
                // abrimos archivo
                fileInput = FileManager.crearAbrirArchivo(file,nombreArchivo);
                // leemos datos
                datosLeidos = FileManager.LeerArchivo(fileInput);
                // validación fecha
                if (validacionFecha(datosLeidos, mesYear)){
                    // validar existencia de archivo
                    if(!FileManager.VerificarExistenciaArchivo(file,nombreArchivo) ){
                        FileManager.EscrituraArchivo(fileInput,data);
                    }else {
                        FileManager.modificarArchivo(fileInput,data);
                    }
                    saveStatus = "Guardado con exito";

                }else {
                    saveStatus = "El mes ya esta registrado";
                }


        return saveStatus;
    }

    public static String sobrescribirDatos(File file,Materiales materiales){
        int materialesObtenidos = materiales.getCantidad();
        String material = materiales.getMaterial();
        String unidad = materiales.getUnidad();
        int mes = materiales.getMes();
        int year = materiales.getYear();
        File fileInput;
        String datosLeidos = "";
        String newdata;
        String saveStatus = "";
        String nombre = materiales.getNombre();
        String data = material + ", " + mes + ", " + year + ", "+materialesObtenidos+", "+unidad;
        String materialMesYear = material+ ", "+mes + ", " + year;

        // construimos el nombre del archivo
        String nombreArchivo = "/"+"_"+nombre+".txt";
        // abrimos el archivo
        fileInput = FileManager.crearAbrirArchivo(file,nombreArchivo);
        // mandamos a sobre escribir


        datosLeidos = FileManager.LeerArchivo(fileInput);
        // hacemos un nuevo estring en sobreescribir archivo para volver a escribirlo en el datospapel
        newdata = FileManager.SobreEscribirArchivo(fileInput,data,datosLeidos,materialMesYear);
        FileManager.EscrituraArchivo(fileInput,newdata);
        saveStatus = "Guardado con exito";


        return saveStatus;


    }


    private static boolean validacionFecha(String datosLeidos, String mesYear) {

        if (datosLeidos.contains(mesYear)){
            System.out.println("ya esta el mes");
            return false;
        }else{
            System.out.println("no existe mes");
            return true;

        }


    }

}
