import java.io.*;

public class Ejercicio7 {
    public static void main(String[] args) {
        try {
            File procesos = new File("procesos.txt");//CREAR EL ARCHIVO
            ProcessBuilder pb = new ProcessBuilder("powershell.exe","-Command","Get-Process | Out-File -FilePath procesos.txt");
            //-----------------------------------El Programa a ejecutar, Tipo de Orden, Comando Y ESCRIBIR EN ARCHIVO DE FUERA, EN LA RUTA, EN ARCHIVO PROCESOS.TXT
            pb.redirectErrorStream(true);
            //Redirigir los Errores tambien
            Process p = pb.start();  //Iniciar el Proceso
            p.waitFor(); // Esperar a que PowerShell termine
        } catch (Exception e) {
            System.err.println("Nel");
        }
    }
}
