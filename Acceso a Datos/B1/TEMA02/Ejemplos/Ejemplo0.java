import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejemplo0 {
    public static void main(String[] args) {
        StreamTokenizer streamTokenizer = new StreamTokenizer(
                new StringReader("Hola mi edad es 45"));
        try {
            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println(streamTokenizer.sval); // token de tipo palabra
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println(streamTokenizer.nval); // token de tipo número
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println(); // fin de línea
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}