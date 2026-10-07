package Ej1;
import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try (LineNumberReader lnr = new LineNumberReader(new FileReader("entrada.txt"))) {
            String linea;
            while ((linea = lnr.readLine()) != null) {
                int palabras = 0;
                int numeros = 0;
                StreamTokenizer st = new StreamTokenizer(new StringReader(linea));
                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                    if (st.ttype == StreamTokenizer.TT_WORD) {
                        palabras++;
                    } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                        numeros++;
                    }
                }
                System.out.println("Línea " + lnr.getLineNumber() + ": " + linea);
                System.out.println("Palabras: " + palabras + ", Números: " + numeros);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}