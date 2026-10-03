import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;

public class Lanzador {
    public static void main(String[] args) {
        try {
            System.out.println("Soy la clase principal.");

            String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            //Tambien puede usarse String java = ProcessHandle.current().info().command().orElse("Java");
            //Que es lo mismo que el system.getProperty pero mas simple
            String cp = System.getProperty("java.class.path");
            //ESTO ES UNA RUTA...
            ProcessBuilder pb = new ProcessBuilder(java, "-cp", cp, "Saludo");
            //Aqui hacemos el constructor de un proceso, usando las rutas de antes, seguidas de:
            //-UN COMANDO
            //-LA CLASE "SALUDO"
            pb.redirectErrorStream(true);
            //AQUI REDIRIGIMOS EXCEPCIONES
            Process hijo = pb.start();
            //AQUI HACEMOS EL PROCESO HIJO (INICIA EL PROCESS BUILDER)
            BufferedReader reader = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
            //EL LECTOR DEl PROCESO Hijo
            String linea;
            //LINEA
            while ((linea = reader.readLine()) != null) {
                System.out.println("La otra clase dice: " + linea);
            }
            //BUCLE QUE LEE HASTA QUE NO QUEDE CONTENIDO
            hijo.waitFor();
            //EL HIJO ESPERA HASTA TERMINAR EL PROCESO
            reader.close();
            //EL LECTOR TERMINA
            System.out.println("El hijo ha terminado.");
            //HECHO
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
