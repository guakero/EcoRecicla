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
        File fileInput;


        String data = material + ", " + mes + ", " + year + ", "+materialesObtenidos;
        String mesYear = mes + ", " + year;
        String saveStatus = "";
        String datosLeidos = "";

        switch(material){

            case "Papel":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosPapel.txt");
                datosLeidos = FileManager.LeerArchivo(fileInput);

                if (validacionFecha(datosLeidos, mesYear)){
                    if(!FileManager.VerificarExistenciaArchivo(file,"DatosPapel.txt") ){
                        FileManager.EscrituraArchivo(fileInput,data);
                        saveStatus = "Guardado con exito";
                    }else {
                        FileManager.modificarArchivo(fileInput,data);
                    }

                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Plasticos":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosPlastico.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Electronicos":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosElectronicos.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Aceite":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosAceite.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Vidrio":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosVidrio.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Organicos":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosOrganicos.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Baterias":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosBaterias.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;
            case "Textiles":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosTextiles.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

        }

        return saveStatus;
    }

    public static String sobrescribirDatos(File file,Materiales materiales){
        int materialesObtenidos = materiales.getCantidad();
        String material = materiales.getMaterial();
        int mes = materiales.getMes();
        int year = materiales.getYear();
        File fileInput;


        String data = material + ", " + mes + ", " + year + ", "+materialesObtenidos;
        String mesYear = mes + ", " + year;
        String saveStatus = "";
        String datosLeidos = "";

        switch(material){

            case "Papel":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosPapel.txt");
                datosLeidos = FileManager.LeerArchivo(fileInput);
                        FileManager.SobreEscribirArchivo(fileInput,data,datosLeidos);
                        saveStatus = "Guardado con exito";

                break;

            case "Plasticos":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosPlastico.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Electronicos":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosElectronicos.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Aceite":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosAceite.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Vidrio":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosVidrio.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Organicos":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosOrganicos.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

            case "Baterias":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosBaterias.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;
            case "Textiles":

                fileInput = FileManager.crearAbrirArchivo(file,"DatosTextiles.txt");

                if (validacionFecha(datosLeidos, mesYear)){
                    FileManager.EscrituraArchivo(fileInput,data);
                    saveStatus = "Guardado con exito";
                }else {
                    saveStatus = "El mes ya esta registrado";
                }

                break;

        }

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
