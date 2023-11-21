package com.dario.ecorecicla.modelos;

import java.io.File;

public class User {

    private String nombre;
    private String usuario;
    private String contraseña;

    public User (String nombre, String usuario, String contraseña){
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    public static void guardarUsuario (User usuario, File file){
        String datosUsuario = usuario.getNombre()+ ", "+ usuario.getUsuario()  + ", "+ usuario.getContraseña();
        File fileUser = FileManager.crearAbrirArchivo(file,"usuario: "+usuario.getNombre());
        FileManager.EscrituraArchivo(fileUser, datosUsuario);
        String datosleidos = FileManager.LeerArchivo(fileUser);
        if(!datosleidos.equals("") ){

        }
    }
}
