package CasosPracticos;
import java.io.*;

public class CasPrac1 {
    public static void main(String[] args) {
        try {
            File fi = new File("gestor/documento.txt");
            if (fi.createNewFile()) {
                System.out.println(fi.getPath());
            }
            File carpDe=new File("gestor/archivados");
            carpDe.mkdirs();
            if (fi.renameTo(carpDe)) {
                System.out.println("DESTINO: "+fi.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Error "+e.toString());
        }
    }
}
/*
 * Crear ficheros → createNewFile()
 * Consultar la fecha de modificación → lastModified()
 * Mover ficheros entre directorios → renameTo()
 */