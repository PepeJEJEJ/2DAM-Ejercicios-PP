import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Cuanto rango?");
            int inicio = Integer.parseInt(sc.nextLine());
            System.out.println("Cauntos asientos");
            int cantidad = Integer.parseInt(sc.nextLine());

            RandomAccessFile asientos = new RandomAccessFile("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA01\\Ejercicios\\asientos.txt", "rw");
            asientos.seek(inicio);

            byte[] array = new byte[cantidad];
            int leidos = asientos.read(array, 0, cantidad);

            for (int i = 0; i < leidos; i++) {
                char estado = (char) array[i];
                System.out.println("asiento " + (inicio + i) + ": " + estado);
            }
            sc.close();
            asientos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}