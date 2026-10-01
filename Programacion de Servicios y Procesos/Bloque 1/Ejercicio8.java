import java.io.*;

public class Ejercicio8 {

    public static Boolean comprobarProceso(String nombreProceso) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "powershell.exe",
                    "-Command",
                    "Get-Process"
            );

            Process p = pb.start();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream())
            );

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(nombreProceso)) {
                    br.close();
                    return true;
                }
            }

            br.close();
            return false;

        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(comprobarProceso("chrome"));
    }
}
