import java.io.*;

public class Ejercicio2A {
    public static void main(String[] args) {
        try {
            FileInputStream IS = new FileInputStream("Imagen.png");
            FileOutputStream OS = new FileOutputStream("Copia.png");
            int c;
            int Cuenta = 0;
            while ((c = IS.read()) != -1) {
                OS.write(c);
                Cuenta++;
            }
            IS.close();
            OS.close();
            System.out.println("TODO FUE BIEN");
            System.out.println("Bytes Leidos: "+Cuenta);
        } catch (Exception e) {
            System.out.println("error "+e);
        }
    }
}