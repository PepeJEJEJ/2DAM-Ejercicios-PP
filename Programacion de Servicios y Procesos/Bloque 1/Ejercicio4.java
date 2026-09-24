import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        try {
            System.out.println("Con que quieres abrir medac: Chrome o Edge");
            Scanner sc = new Scanner(System.in);
            String opcion = sc.nextLine();
            String url = "https://medac.es/";
            switch (opcion) {
                case "Chrome":
                    String rutaChrome = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
                    ProcessBuilder chrome = new ProcessBuilder(rutaChrome, url);
                    chrome.start();
                    break;
                case "Edge":
                    String rutaEdge = "\"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe\"";
                    ProcessBuilder edge = new ProcessBuilder(rutaEdge, url);
                    edge.start();
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
            sc.close();
        } catch (IOException e) {
            System.err.println("Nel");
        }
    }
}
