package TEMA01;

import java.io.*;

public class Ejemplo5 {

    public static void main(String[] args) {

        String path = "./TEMA01/Ejemplos/texto.txt";
        String pathEscritura = "./TEMA01/Ejemplos/textow.txt";

        try {
            FileInputStream entrada = new FileInputStream(path);
            int data;
            while ((data = entrada.read()) != -1) {
                System.out.print((char) data);
            }
            entrada.close();
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        try {
            String cadena = "Esto es una prueba de escriturá";
            byte[] arrayBytes = cadena.getBytes();

            FileOutputStream output = new FileOutputStream(pathEscritura);
            output.write(arrayBytes);
            output.close();
            System.out.println("\nFichero escrito");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}