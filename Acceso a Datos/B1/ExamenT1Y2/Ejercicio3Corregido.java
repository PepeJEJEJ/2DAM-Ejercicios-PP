import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3Corregido {
    public static void main(String[] args) {
        String ruta = "minas.txt";
        boolean encontrado = false;
        Scanner sc = new Scanner(System.in);
        try {
            RandomAccessFile raf = new RandomAccessFile(ruta, "rw");
            while (!encontrado) {
                System.out.print("Posicion (0-9): ");
                int pos = sc.nextInt();
                if (pos < 0 || pos > 9) {
                    System.out.println("Esa posicion no existe.");
                } else {
                    raf.seek(pos);
                    int c = raf.read();
                    if (c == '*') {
                        raf.seek(pos);
                        raf.write('$');
                        System.out.println("Has acertado: la mina estaba en la posicion "+ pos + ".");
                        encontrado = true;
                    } else {
                        System.out.println("Aqui no hay mina.");
                    }
                }
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error E/S: " + e.toString());
        }
        sc.close();
    }
}