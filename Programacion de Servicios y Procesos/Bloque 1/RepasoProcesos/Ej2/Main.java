package Ej2;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Generando la ficha del equipo, espera...");

            Process p = new ProcessBuilder("java", "FichaEquipo").start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            p.waitFor();
            System.out.println("Ficha terminada.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
