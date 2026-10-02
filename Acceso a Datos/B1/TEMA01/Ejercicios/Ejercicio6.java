import java.io.*;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Número de asiento que quieres comprar (0-19)");

            int asiento = Integer.parseInt(sc.nextLine());

            if (asiento < 0 || asiento > 19) {
                System.out.println("Ese asiento no existe/no está disponible");
            } else {
                try (RandomAccessFile acceso = new RandomAccessFile("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA01\\Ejercicios\\asientos.txt", "rw")) {
                    if (asiento >= acceso.length()) {
                        System.out.println("Ese asiento no existe/no está disponible");
                    } else {
                        acceso.seek(asiento);
                        int estado = acceso.read();
                        if (estado == 'C') {
                            System.out.println("Ese asiento ya está ocupado");
                        } else if (estado == 'L') {
                            acceso.seek(asiento);
                            acceso.write('C');
                            System.out.println("Asiento reservado correctamente");
                        } else {
                            System.out.println("Ese asiento no existe/no está disponible");
                        }
                    }
                }
            }
        } catch (NumberFormatException | IOException e) {
            System.err.println("Error de lectura/escritura: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
