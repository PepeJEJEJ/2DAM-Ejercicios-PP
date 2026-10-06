package Ej2;
import java.io.*;

public class FichaEquipo {
    public static void main(String[] args) {
        try {
            Process p = new ProcessBuilder("cmd", "/c", "systeminfo").start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedWriter bw = new BufferedWriter(new FileWriter("equipo.txt"));
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                if (linea.contains("Nombre de host") ||
                    linea.contains("Nombre del sistema operativo") ||
                    linea.contains("Modelo del sistema")) {

                    bw.write(linea);
                    bw.newLine();
                    contador++;
                }
            }

            bw.close();
            System.out.println("[FichaEquipo] " + contador + " datos guardados en equipo.txt");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
