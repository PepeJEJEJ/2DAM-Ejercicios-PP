package Ej2;

import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Indica qué línea quieres leer: ");
        int ln = sc.nextInt();
        try (LineNumberReader lnr = new LineNumberReader(new FileReader("Ej2\\entrada.txt"))) {
            String linea;
            boolean encontrada = false;
            while ((linea = lnr.readLine()) != null) {
                if (lnr.getLineNumber() == ln) {
                    System.out.println("\nContenido de la línea número " + ln + ":");
                    System.out.println(linea);
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                System.out.println("La línea " + ln + " no existe en el archivo.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}