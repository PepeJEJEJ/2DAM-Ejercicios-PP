import java.io.RandomAccessFile;

public class Ejemplo7 {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile(
                    "C:\\Users\\PC128\\Documents\\JIJA\\2 dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA01\\Ejemplos\\abecedario.txt",
                    "r");
            file.seek(5);
            byte[] arrayBytes = new byte[3];
            file.read(arrayBytes, 0, 3);
            System.out.println("Bytes leidos: " + arrayBytes.length);
            for (int i = 0; i < arrayBytes.length; i++) {
                System.out.println("  arrayBytes[" + i + "] = " + arrayBytes[i] + " -> '" + (char) arrayBytes[i] + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
