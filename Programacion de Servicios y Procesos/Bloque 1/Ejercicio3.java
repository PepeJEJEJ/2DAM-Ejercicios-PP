import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            String url = "https://medac.es/";
            String rutaChrome = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            String rutaEdge = "\"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe\"";
            ProcessBuilder chrome = new ProcessBuilder(rutaChrome,url);
            chrome.start();
            ProcessBuilder edge = new ProcessBuilder(rutaEdge,url);
            edge.start();
        } catch (IOException e) {
            System.err.println("Nel");
        }
    }
}
