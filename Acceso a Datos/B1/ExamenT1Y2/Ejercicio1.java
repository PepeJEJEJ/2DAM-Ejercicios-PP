/*
 * ACCESO A DATOS - EXAMEN BLOQUE 1
 * EJERCICIO 1 - 2 puntos
 *
 * ENUNCIADO
 * Copia el contenido del fichero de texto "texto.txt" en un nuevo fichero de
 * texto llamado "texto_backup.txt", y muestra por pantalla cuantos caracteres
 * se han copiado.
 * 
 * REQUISITOS
 *  Los dos ficheros deben quedar cerrados al terminar el programa.
 *
 * EJEMPLO
 *  Si texto.txt contiene:
 *      Hola mundo, esto es una prueba de copia
 *  la salida del programa es:
 *      Hola Mundo, esto es una prueba de copia
        Se han copiado 39 caracteres
 *  y texto_backup.txt queda con el mismo texto que el fichero original.
 *
 * AYUDA
 *   Leer caracteres:              new FileReader(ruta)
 *   Escribir caracteres:          new FileWriter(ruta)
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
        FileReader fr = new FileReader("texto.txt");
        FileWriter fw = new FileWriter("texto_backup.txt");
        int dato;
        int caracteres=0;
        while((dato=fr.read())!=-1){
            fw.write(dato);
            caracteres++;
        }
        System.out.println("Se han copiado " +caracteres+ " caracteres");
        fr.close();
        fw.close();
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}