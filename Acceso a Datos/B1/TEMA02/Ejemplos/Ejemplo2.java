import java.io.*;

public class Ejemplo2 {
    public static void main(String[] args) throws Exception {
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA02\\Ejemplos\\datos.txt"));
            String line = lineNumberReader.readLine();
            while(line != null) {
                System.out.println("Contenido de la linea numero:"+ lineNumberReader.getLineNumber());
                System.out.println(line);
                line = lineNumberReader.readLine();
            }
                lineNumberReader.close();
            } catch (IOException e) {
            e.printStackTrace();
            }
    }
}