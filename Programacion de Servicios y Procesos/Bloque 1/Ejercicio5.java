import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        try {
            System.out.println("Con que quieres abrir: Chrome o Edge");
            Scanner sc = new Scanner(System.in);
            String opcion = sc.nextLine().trim().toLowerCase();//<==< SOLO ESTO HA SIDO CON IA
            Process p = null;
            switch (opcion) {
                case "Chrome":
                    ProcessBuilder pb = new ProcessBuilder("chrome.exe");
                    p = pb.start();
                    Thread.sleep(5000);
                    System.out.println("¿Quieres Cerrarlo?");
                    String condition = sc.nextLine();
                    if (condition.equals("S")) {
                        p.destroy();
                    } else {
                        return;
                    }
                    break;
                case "Edge":
                    ProcessBuilder pb1 = new ProcessBuilder("msedge.exe");
                    p = pb1.start();
                    Thread.sleep(5000);
                    System.out.println("¿Quieres Cerrarlo?");
                    String condition1 = sc.nextLine();
                    if (condition1.equals("S")) {
                        p.destroy();
                    } else {
                        return;
                    }
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
            sc.close();

        } catch (IOException | InterruptedException e) {
            System.err.println("Nel");
        }
    }
}