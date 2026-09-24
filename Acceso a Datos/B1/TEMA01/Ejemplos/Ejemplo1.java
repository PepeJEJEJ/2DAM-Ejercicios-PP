package TEMA01;

import java.io.*;

public class Ejemplo1 {

    public static void main(String[] args) {
        try {
            File fichero = new File(".\\TEMA01\\Ejemplos\\crearFichero.txt");
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado: " + fichero.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}