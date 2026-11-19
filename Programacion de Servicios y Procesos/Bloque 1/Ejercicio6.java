import java.io.*;

public class Ejercicio6 {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("calc.exe");
            Process p = pb.start(); //EL PROCESO SE INICIA
            Thread.sleep(5000);
            new ProcessBuilder("cmd.exe", "/c", "taskkill /F /IM calc.exe").start();
        } catch (Exception e) {
            System.err.println("Nel");
        }
    }
}
