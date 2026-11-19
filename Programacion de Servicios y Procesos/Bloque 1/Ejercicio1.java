import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "ipconfig");//LOS COMANDOS
            Process p = pb.start(); //EL PROCESO SE INICIA
            BufferedReader br = new BufferedReader(//EL BUFFERED READER INICIALIZADO
            new InputStreamReader(p.getInputStream()));

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("IPv4")) {
                    System.out.println(linea.trim());
                }
            }
            p.destroy();
        } catch (Exception e) {
            System.err.println("Nel");
        }
    }
}
