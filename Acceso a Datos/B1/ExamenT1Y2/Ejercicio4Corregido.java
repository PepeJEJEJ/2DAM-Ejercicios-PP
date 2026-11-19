import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejercicio4Corregido {
    public static void main(String[] args) {
        String fichero = "ticket.txt";
        double totalGeneral = 0;
        try {
            LineNumberReader lector = new LineNumberReader(new FileReader(fichero));
            String linea;
            while ((linea = lector.readLine()) != null) {
                StreamTokenizer st = new StreamTokenizer(new StringReader(linea));
                int productos = 0;
                double totalLinea = 0;
                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                    if (st.ttype == StreamTokenizer.TT_WORD) {
                        productos++;
                    } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                        totalLinea += st.nval;
                    }
                }
                System.out.println(
                        "Linea " + lector.getLineNumber() +": " + productos +" productos, total " + totalLinea);

                totalGeneral += totalLinea;
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error E/S: " + e.toString());
        }
        System.out.println("Total de todo: " + totalGeneral);
    }
}