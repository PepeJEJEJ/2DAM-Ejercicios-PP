import java.io.*;

public class Ejemplo1 {
    public static void main(String[] args) {
        try {
            StreamTokenizer st = new StreamTokenizer(new FileReader("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA02\\Ejemplos\\datos.txt"));
            //DECLARAR UN OBJETO STREAM-TOKENIZER QUE LEA UN TXT (en este caso datos.txt)
            st.eolIsSignificant(true);
            int palabras=0;
            int numeros=0;
            while (st.nextToken() != StreamTokenizer.TT_EOF) { // TOKEN QUE INDICA EL FIN DEL DOCUMENTO
                if (st.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println(st.sval); // token de tipo palabra
                    palabras++;
                } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println(st.nval); // token de tipo número
                    numeros++;
                } else if (st.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println("Salto de linea"); // fin de línea
                }
            }
            System.out.println("Hay "+palabras+" palabras y "+numeros+" numeros");
        } catch (IOException e) {
            System.err.println("Error " + e);
        }
    }
}
