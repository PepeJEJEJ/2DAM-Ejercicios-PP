import java.io.*;

public class Ejercicio2B {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("Imagen.png");
            FileWriter fw = new FileWriter("copia.png");
            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c);
            }
            fr.close();
            fw.close();
            System.out.println("TODO FUE BIEN");
        } catch (Exception e) {
            System.out.println("error "+e);
        }
    }
}