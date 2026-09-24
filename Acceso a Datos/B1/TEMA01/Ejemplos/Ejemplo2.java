package TEMA01;

import java.io.*;

public class Ejemplo2 {

    public static void main(String[] args) {

        File ficheroOrigen = new File(".\\TEMA01\\Ejemplos\\crearFichero.txt"); // La ruta del archivo de origen
        String nombreCarpeta = "Backup"; // VARIABLE QUE LE DA NOMBRE A UNA CARPETA
        File carpeta = new File(".\\TEMA01\\Ejemplos", nombreCarpeta); // Ruta padre (parent -> Carpeta Base | Lo otro es
                                                                      // la carpeta a crear dentro de la Carpeta Base)
        carpeta.mkdirs();// Hacer que el archivo carpeta sea un Directorio

        File ficheroDestino = new File(".\\TEMA01\\Ejemplos\\Backup\\fichero_movido.txt");//La ruta de destino del archivo
        if (ficheroOrigen.renameTo(ficheroDestino))
            System.out.println("El fichero se movió correctamente");
        else
            System.out.println("El fichero no pudo moverse");
    }
}