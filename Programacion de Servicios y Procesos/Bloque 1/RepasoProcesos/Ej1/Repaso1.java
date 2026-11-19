package Ej1;
import java.util.Scanner;

public class Repaso1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            boolean sigue = true;

        while (sigue) {
            System.out.println("=== PANEL DE ESTUDIO ===");
            System.out.println("1. Abrir el campus virtual");
            System.out.println("2. Tomar apuntes");
            System.out.println("3. Ver mis descargas");
            System.out.println("4. Terminar de tomar apuntes");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            int op = sc.nextInt();

            switch (op) {
                case 1:
                    new ProcessBuilder("cmd", "/c", "start msedge https://davante.es").start();
                    break;

                case 2:
                    new ProcessBuilder("cmd", "/c", "start notepad apuntes.txt").start();
                    break;

                case 3:
                    new ProcessBuilder("cmd", "/c", "start explorer %USERPROFILE%\\Downloads").start();
                    break;

                case 4:
                    new ProcessBuilder("cmd", "/c", "taskkill /IM notepad.exe /F").start();
                    break;

                case 5:
                    sigue = false;
                    break;

                default:
                    System.out.println("Opción no válida");
            }
            sc.close();
        }
        } catch (Exception e) {
            System.err.println("ERROR "+e);
        }
    }
}
