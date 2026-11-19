// CLASE Main · el asistente de soporte
// ============================================================================
// RECORDATORIO · es el mismo en todos los ficheros del examen
// ============================================================================
//
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.InputStreamReader;
//
// Crear un proceso para un programa (el programa y, detrás, lo que haya que darle):
//     ProcessBuilder pb = new ProcessBuilder("programa", "argumento");
//
// Crear un proceso para un comando del CMD o de PowerShell:
//     ProcessBuilder pb = new ProcessBuilder("cmd", "/c", comando);
//     ProcessBuilder pb = new ProcessBuilder("powershell.exe", "/c", comando);
//
// Crear un proceso para otra clase de Java:
//     String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
//     String cp = System.getProperty("java.class.path");
//     ProcessBuilder pb = new ProcessBuilder(java, "-cp", cp, "NombreDeLaClase");
//
// Crear un lector para lo que escribe un proceso:
//     BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
//
// Crear un fichero de texto para escribir (false = se sobrescribe; true = se añade al final):
//     FileWriter writer = new FileWriter("fichero.txt", false);
//
// ============================================================================
// PROGRAMAS DE WINDOWS (se abren con su nombre, salvo Edge)
// ============================================================================
//     notepad       Bloc de notas
//     mspaint       Paint
//     calc          Calculadora
//     explorer      Explorador de archivos (detrás, la carpeta que se quiere abrir)
//     control       Panel de control
//     charmap       Mapa de caracteres
//     magnify       Lupa
//     osk           Teclado en pantalla
//     mstsc         Conexión a Escritorio remoto
//     C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe     Microsoft Edge
//
// ============================================================================
// COMANDOS DEL SISTEMA
// ============================================================================
//     ipconfig                  Configuración de red del equipo
//     ping -n 4 dirección       Comprueba si se llega a una dirección (4 intentos)
//     tasklist                  Lista de procesos en ejecución
//     taskkill /F /IM nombre    Cierra un proceso por el nombre de su ejecutable
//     dir carpeta               Contenido de una carpeta (sin barra al final: dir C:)
//     systeminfo                Datos del equipo y del sistema operativo
//     hostname                  Nombre del equipo
//     whoami                    Usuario con el que se ha iniciado sesión
//     Get-Process               Lista de procesos (PowerShell)
//     Get-LocalUser | Where-Object Enabled | Select-Object -ExpandProperty Name
//                               Usuarios activos del equipo, uno por línea (PowerShell)
//
// ============================================================================
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion=sc.nextLine();
        while(!opcion.equals("5")) {
            System.out.println("Que problema tienes");
            System.out.println("1. Problema de Red");
            System.out.println("2. Mi pc va lento");
            System.out.println("3. No se cuantos usuarios hay en mi equipo");
            System.out.println("4. Me quedo sin espacio en el disco");
            System.out.println("5. salir");
            switch(opcion) {
                case "1":
                String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
                String cp = System.getProperty("java.class.path");
                ProcessBuilder pb = new ProcessBuilder(java, "-cp", cp, "Red");
                break;
                case "2":
                String java1 = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
                String cp1 = System.getProperty("java.class.path");
                ProcessBuilder pb1 = new ProcessBuilder(java1, "-cp", cp1, "Lento");
                break;
                case "3":
                String java2 = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
                String cp2 = System.getProperty("java.class.path");
                ProcessBuilder pb2 = new ProcessBuilder(java2, "-cp", cp2, "Usuarios");
                break;
                case "4":
                String java3 = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
                String cp3 = System.getProperty("java.class.path");
                ProcessBuilder pb3 = new ProcessBuilder(java3, "-cp", cp3, "Disco");
                break;
                case "5":
                System.out.println("chau");
                break;
                default:
                System.out.println("nel");
                break;
            }
        }
    }
}