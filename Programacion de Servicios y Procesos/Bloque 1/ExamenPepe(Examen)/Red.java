// CLASE Red · diagnóstico 1: Tengo un problema de red
// ============================================================================
// RECORDATORIO · es el mismo en todos los ficheros del examen
// ============================================================================
//
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.InputStreamReader;
// import java.util.Scanner;
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
import java.io.*;

public class Red {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ipconfig", "ping -n 4 google.es");
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            FileWriter fw = new FileWriter("red.txt", false);
            String linea="";
            while((linea=br.readLine())!=null) {
                fw.br.readLine(linea,"\n");//NO FUNCIONA, PERO SI FUNCIONARA, ESCRIBIRIA EL TXT
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
    }
}