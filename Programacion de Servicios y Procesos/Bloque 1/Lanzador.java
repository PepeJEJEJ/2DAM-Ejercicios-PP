import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;

public class Lanzador {
    public static void main(String[] args) {
        try {
            System.out.println("Soy la clase principal.");

            String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";

            String cp = System.getProperty("java.class.path");

            ProcessBuilder pb = new ProcessBuilder(java, "-cp", cp, "Saludo");
            pb.redirectErrorStream(true);

            Process hijo = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("La otra clase dice: " + linea);
            }

            hijo.waitFor();
            reader.close();

            System.out.println("El hijo ha terminado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
