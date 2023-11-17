package com.dario.ecorecicla.modelos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public  class FileManager {



    public static File crearAbrirArchivo(File archivo,String nombreArchivo ){
        File file = new File(archivo+nombreArchivo);
        if(file.exists() ){

            System.out.println("el archivo fue creado");
        }else {
            System.out.println("el archivo ya existe");
        }

        return file;
    }

    public static void  EscrituraArchivo (File archivo, String texto){

        try {
            FileWriter fileWirter = new FileWriter(archivo);
            fileWirter.write(texto);
            fileWirter.close();
            System.out.println("el archivo fue escrito");

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static String LeerArchivo (File archivo){
        String lineReturn = "";
        try {
            FileReader reader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuilder contenido =  new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine())!= null) {
                contenido.append(line).append("\n ");

            }
            bufferedReader.close();
            reader.close();
            String archivoContenido = contenido.toString();
            System.out.println(archivoContenido);
            lineReturn = archivoContenido;
        }catch (IOException ex){
            ex.printStackTrace();

        }
        return lineReturn;

    }

    public static void modificarArchivo (File path, String texto){

        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write("\n"+texto);
            writer.close();
            System.out.println("archivo modificado");


        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public static boolean VerificarExistenciaArchivo (File archivo,String nombreArchivo){

            File file = new File(archivo+nombreArchivo);
            if(file.exists() ){
                System.out.println("el archivo existe");
                return true;
            }else {
                System.out.println("el archivo no existe");
                return false;
            }



    }
    public static String SobreEscribirArchivo (File archivo, String datoNuevo, String datosViejos){
        String lineReturn = "";

        return lineReturn;

    }

    }



