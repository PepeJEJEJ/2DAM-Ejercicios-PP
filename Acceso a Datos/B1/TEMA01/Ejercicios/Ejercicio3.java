import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Posicion: ");
            int POS = sc.nextInt();
            System.out.print("Caracter nuevo: ");
            char nuevo = sc.next().charAt(0);

            RandomAccessFile RAF = new RandomAccessFile("texto.txt", "rw");

            if (POS < 0 || POS >= RAF.length()) {
                System.out.println("Posicion NO VALIDA.");
            } else {
                RAF.seek(POS);
                RAF.write(nuevo);
                System.out.println("Modificado BIEN.");
            }
            RAF.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }
}
