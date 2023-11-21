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


    public static Boolean guardarUsuario (User usuario,File path ){
        String datosUsuario = usuario.getNombre()+ ", "+ usuario.getUsuario()  + ", "+ usuario.getContraseña();

        if (FileManager.VerificarExistenciaArchivo(path,"usuario: "+usuario.getUsuario()+".txt")){
            // retorna falso si ya esta registrado ese usuario
            return false;
        }else {
            File fileUser = FileManager.crearAbrirArchivo(path,"usuario: "+usuario.getUsuario()+".txt");
            FileManager.EscrituraArchivo(fileUser, datosUsuario);
            String datosleidos = FileManager.LeerArchivo(fileUser);
            System.out.println(datosleidos);
            // retorna verdadero si ya esta registrado ese usuario
            return true;
        }

        }
    }

