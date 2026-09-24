package TEMA01;

import java.io.*;

public class Ejemplo3 {

    public static void main(String[] args) {
        
        String nombreCarpeta = "NuevaCarpeta"; //Nombre de la carpeta
        File carpeta = new File(".\\TEMA01\\Ejemplos", nombreCarpeta);//CREAR UN ARCHIVO PADRE (con ruta) E HIJO (con nombre)

        if (carpeta.exists())
            System.out.println("La carpeta " + carpeta.getName() + " ya existe");
        else {
            carpeta.mkdirs();
            System.out.println("La carpeta " + carpeta.getName() + " se ha creado"); //MUESTRA EL NOMBRE DE LA CARPETA
            System.out.println("Ruta absoluta " + carpeta.getAbsolutePath()); //Muestra La ruta absoluta (TODA LA RUTA, o sea, Secuencial)
            System.out.println("Ruta relativa " + carpeta.getPath()); //Muestra la ruta telativa (Dentro de su "Arbol", o sea, Directo)
            System.out.println("Carpeta padre " + carpeta.getParent()); //Muestra como se llama la carpeta padre/principal
        }
    }
}