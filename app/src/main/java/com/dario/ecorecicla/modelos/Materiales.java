package com.dario.ecorecicla.modelos;

import android.widget.Switch;

import java.io.File;

public class Materiales {

    private String material;
    private String mes;
    private float cantidad;


    public Materiales (String material, String mes, float cantidad){
        this.material = material;
        this.mes = mes;
        this.cantidad = cantidad;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public static String guardarDatos(File file,Materiales materiales){
        float materialesObtinidos = materiales.getCantidad();
        String material = materiales.getMaterial();
        String mes = materiales.getMes();

        switch(material){
            case "Papel":

                FileManager.crearArchivo(file,"DatosPapel.txt");
                FileManager.EscrituraArchivo("",file);
                break;


        }




        return null;
    }

}
