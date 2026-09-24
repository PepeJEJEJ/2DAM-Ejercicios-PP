package TEMA01;

import java.io.*;

public class Ejemplo4 {
    public static void main(String[] args) {
        try {
            FileReader lector = new FileReader("./TEMA01/prueba.txt");// CREAR UN LECTOR Y LA RUTA DEL ARCHIVO A LEER
            FileWriter escritor = new FileWriter("./TEMA01/escritura.txt");
            int data;// CREAR SIEMPRE
            while ((data = lector.read()) != -1) {// LEE MIENTRAS DATA NO DEVUELVA "-1" O FIN DE DOCUMENTO
                escritor.write(data);// TEXTO QUE DEBE ESCRIBIR EL ESCRITOR
                System.out.print((char) data);// MOSTRAR TRADUCIDO Data (ASCII)
            }
            lector.close();
            escritor.close();
        } catch (Exception e) {
            System.err.println(" Error al leer el archivo: " + e.getMessage());// ERROR
        }
        try {
            FileWriter escritor1 = new FileWriter("./TEMA01/prueba.txt");// CREAR UN ESCRITOR Y LA RUTA DEL ARCHIVO A
                                                                         // ESCRIBIR
            escritor1.write("Esto es un ejemplo de escritura");// TEXTO QUE DEBE ESCRIBIR EL ESCRITOR
            escritor1.close();// TEXTO QUE DEBE ESCRIBIR EL ESCRITOR
            System.out.println(" Fichero escrito correctamente.");// EXITO
        } catch (Exception e) {
            System.err.println(" Error al escribir en el archivo: " + e.getMessage());// ERROR
        }
    }
}
