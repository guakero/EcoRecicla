package com.dario.ecorecicla.modelos;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// Android-added: Info about UTF-8 usage in filenames.

/**
 * File manager crea lee y validad datos de archivo
 */
public  class FileManager {


    /**
     *recive el paht con getFilesDir() en el parametro File archivo y el String nombre del archivo
     * texto
     */
    public static File crearAbrirArchivo(File archivo,String nombreArchivo ){
        File file = new File(archivo+nombreArchivo);
        if(file.exists() ){

            System.out.println("el archivo"+archivo+ nombreArchivo +" ya existe");
        }else {
            System.out.println("el archivo "+archivo + nombreArchivo +" fue creado");
        }

        return file;
    }


    /**
     *recive file generado por crearAbrirArchivos en el parametro File archivo y el texto a escribir en el parametro
     * texto
     */
    public static void  EscrituraArchivo (File archivo, String texto){

        try {
            FileWriter fileWirter = new FileWriter(archivo);
            fileWirter.write(texto);
            fileWirter.close();


        }catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println("Escribi "+texto);

    }

    /**
     *recive el objeto file generado por la funcion crearAbrirArchivo
     * texto y retorna string con contenido
     */
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
            System.out.println("archivo"+path+" modificado con "+ texto);


        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
    public static boolean VerificarExistenciaArchivo (File archivo,String nombreArchivo){

            File file = new File(archivo+nombreArchivo);
            if(file.exists() ){
                System.out.println("EX VAL: el archivo existe");
                return true;
            }else {
                System.out.println("EX VAL:el archivo no existe");
                return false;
            }

    }
    public static String SobreEscribirArchivo (File archivo, String datoNuevo, String datosViejos, String materialMesYear){

        // Construye el regex para hacer el remplazo
        String regex = materialMesYear +", ..?.?, ......?";
        // genera el nuevo string y lo detorna
        String nuevoString = datosViejos.replaceAll(regex, datoNuevo);

        return nuevoString;

    }

    public static void logPy(String mensaje) {
        Log.i("Puki", mensaje);
    }

    /**
     *recive el paht con getFilesDir() en el parametro File archivo, el nombre del archivo en el parametro
     * texto, y el dato a validar en el parametro dato a validar.
     * retorna un booleano con la validadcion
     */
    public static boolean ValidarExistenciadeDato (File path,String nombreArchivo, String datoAValidar){
        File archivo = crearAbrirArchivo(path,nombreArchivo);
        String data = LeerArchivo(archivo);
        // cortamos los datos pero el psw queda con \n asi que hay que cortarlo
        String[] datos = data.split(", ");
        // sacamos el ultimo index
        int lastIndex = datos[2].length();
        // cortamos
        String datoPsw = datos[2].substring(0,lastIndex-2);

        if (datoPsw.equals(datoAValidar)){
            return true;
        }
        return false;

    }

    }




