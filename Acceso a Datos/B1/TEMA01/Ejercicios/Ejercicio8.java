import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1Guar");
        System.out.println("2Impr");
        int opcion=Integer.parseInt(sc.nextLine());
        if (opcion==1) {
            System.out.println("Nombre y Apellidos");
            String nombre=sc.nextLine();
            System.out.println("Email");
            String Email=sc.nextLine();
            System.out.println("Fecha de Nacimiento");
            String fecha=sc.nextLine();
            System.out.println("Género (Masculino / Femenino)");
            String genero=sc.nextLine();
            System.out.println("Titulación de Acceso (FP Grado Medio / FP Grado Superior / Bachillerato)");
            String titulo=sc.nextLine();
            System.out.println("Observaciones");
            String observaciones = sc.nextLine();
            String contenido = "----- Formulario de Matriculación -----\r\n" +
                                "Nombre y Apellidos: " + nombre + "\r\n" +
                                "Email: " + Email + "\r\n" +
                                "Fecha de Nacimiento: " + fecha + "\r\n" +
                                "Género: " + genero + "\r\n" +
                                "Titulación de Acceso: " + titulo + "\r\n" +
                                "Observaciones:\r\n" + observaciones + "\r\n" +
                                "---------------------------------------";
            try {
                FileWriter fw=new FileWriter("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA01\\Ejercicios\\Destino\\matricula.txt");
                fw.close();
            } catch (Exception e) {
                System.err.println("Error "+e);
            }
            System.out.println(contenido);
            sc.close();
        } else if (opcion==2) {
            try {
                FileReader fr=new FileReader("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA01\\Ejercicios\\Destino\\matricula.txt");
                int data;
                while ((data=fr.read())!=-1) {
                    System.out.println((char)data);
                }
                fr.close();
            } catch (Exception e) {
                System.err.println("Error "+e);
            }
        }
    }
}
