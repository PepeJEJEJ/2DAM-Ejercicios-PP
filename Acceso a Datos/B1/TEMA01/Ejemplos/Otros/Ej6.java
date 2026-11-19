package Otros;

import java.io.*;
import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("asientos.txt", "rw");

            Scanner sc = new Scanner(System.in);
            System.out.print("Número de asiento (0-19): ");
            int n = sc.nextInt();

            if (n < 0 || n > 19) {
                System.out.println("Asiento no válido.");
            } else {
                raf.seek(n);
                char estado = (char) raf.read();

                if (estado == 'C') {
                    System.out.println("Asiento ya ocupado.");
                } else {
                    raf.seek(n);
                    raf.write('C');
                    System.out.println("Asiento comprado.");
                }
            }

            raf.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
