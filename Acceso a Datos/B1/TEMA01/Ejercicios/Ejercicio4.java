import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        try {
            BufferedInputStream BIS = new BufferedInputStream(new FileInputStream("Imagen.png"));
            BufferedOutputStream BOS = new BufferedOutputStream(new FileOutputStream("Buffer_Imagen.png"));
            int c;
            byte[] buffer = new byte[1024];
            int bytesLeidos;
            int bloque = 1;

            while ((bytesLeidos = BIS.read(buffer)) != -1) {
                BOS.write(buffer, 0, bytesLeidos);
                System.out.println("Fin copia bloque " + bloque);
                bloque++;
            }
            BIS.close();
            BOS.close();
            System.out.println("TODO FUE BIEN");
            System.out.println("Bytes Leidos: " + bloque);
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }
}