

import java.io.*;

public class EjercicioA {

    public static void main(String[] args) {
//Copiar y pegar UN ARCHIVO
        File ficheroO = new File("TEMA01\\Ejercicios\\Nwordland.jpg");//ORIGEN ARCHIVO
        File ficheroD = new File("TEMA01\\Ejercicios\\Destino\\Nwordland.jpg");//DESTINO ARCHIVO
        try {
            if (ficheroO.renameTo(ficheroD)) {//renameTo tambien sirve para mover archivos, y se pone el archivo origen y se debe ir a la ruta de destino
                System.out.println("El archivo se movio bien");
                long bytes = ficheroD.length(); // length() devuelve el tamaño en bytes
                System.out.println("El fichero tiene " + bytes + " bytes");//PODREMOS VER ACA LOS BYTES
            } else {
                System.out.println("No se pudo");//SI no sale bien
            }
        } catch (Exception e) {
            System.err.println("Fallo " + e);
        }
    }
}