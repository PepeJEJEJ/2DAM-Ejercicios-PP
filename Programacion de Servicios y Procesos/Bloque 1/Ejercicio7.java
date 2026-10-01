import java.io.*;

public class Ejercicio7 {
    public static void main(String[] args) {
        try {
            File procesos = new File("procesos.txt");
            ProcessBuilder pb = new ProcessBuilder("powershell.exe","-Command","Get-Process | Out-File -FilePath procesos.txt");
            pb.redirectErrorStream(true);
            Process p = pb.start();
            p.waitFor(); // Esperar a que PowerShell termine
        } catch (Exception e) {
            System.err.println("Nel");
        }
    }
}
