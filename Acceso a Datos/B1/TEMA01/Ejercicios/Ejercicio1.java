import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("texto.txt");
            FileWriter fw = new FileWriter("copia.txt");
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
