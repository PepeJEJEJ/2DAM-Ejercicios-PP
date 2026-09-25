import java.io.RandomAccessFile;

public class Ejemplo7 {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile(
                    "C:\\Users\\PC128\\Documents\\JIJA\\2 dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA01\\Ejemplos\\abecedario.txt",
                    "r");
            file.seek(5);
            byte[] arrayBites = new byte[3];
            file.read(arrayBites, 0, 3);
            System.out.println("Bytes leidos: " + arrayBites.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
