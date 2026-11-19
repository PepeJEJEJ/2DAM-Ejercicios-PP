/*
 * ACCESO A DATOS - EXAMEN BLOQUE 1
 * EJERCICIO 4 - 3 puntos
 *
 * ENUNCIADO
 * El fichero de texto "ticket.txt" contiene varios tickets de compra, uno por
 * linea. En cada linea hay uno o varios productos, cada uno seguido de su precio:
 *      pan 3 leche 2.5 cocacola 1
 *      agua 1 pan 1.5
 *      huevos 4.5
 *
 * Completa el programa para que recorra el fichero linea a linea con el
 * LineNumberReader y, dentro de cada linea, recorra sus palabras y numeros con
 * un StreamTokenizer. Para cada linea:
 *   1. Cuenta los productos (las palabras).
 *   2. Suma los precios (los numeros).
 *   3. Muestra la linea con el formato "Linea 1: 3 productos, total 6.5".
 *   4. Suma el total de la linea a la variable "totalGeneral".
 * Al terminar, cierra el fichero. El programa ya muestra el total de todo el fichero.
 *
 * REQUISITOS
 *  - Usa un bucle while para las lineas y, dentro de el, otro bucle while para
 *    los elementos de cada linea.
 *  - Crea un StreamTokenizer nuevo para cada linea, a partir del texto de la linea:
 *        new StreamTokenizer(new StringReader(linea))
 *
 * EJEMPLO
 *  La salida del programa es:
 *      Linea 1: 3 productos, total 6.5
 *      Linea 2: 2 productos, total 2.5
 *      Linea 3: 1 productos, total 4.5
 *      Total de todo: 13.5
 *
 * AYUDA
 *   Leer una linea:                   String linea = lector.readLine();   // null al final
 *   Numero de la ultima linea leida:  lector.getLineNumber()
 *   Siguiente palabra o numero:       int tipo = st.nextToken();
 *   Fin de la linea:                  StreamTokenizer.TT_EOF
 *   Tipo del elemento actual:         st.ttype  (StreamTokenizer.TT_WORD o StreamTokenizer.TT_NUMBER)
 *   Valor de un numero:               st.nval   (de tipo double)
 *   Cerrar:                           lector.close();
 */
 
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejercicio4 {

    public static void main(String[] args) {
        String fichero = "ticket.txt";
        double totalGeneral = 0;

        try {
            LineNumberReader lector = new LineNumberReader(new FileReader(fichero));

            String linea;
            while ((linea = lector.readLine())!=null){
                StreamTokenizer st = new StreamTokenizer(new StringReader(linea));
                int productos = 0;
                double procu=st.nval;
                System.out.println("Linea: "+lector.getLineNumber()+" productos, total: "+procu);
                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                    if (st.nval == StreamTokenizer.TT_NUMBER) {
                        procu=st.nextToken();
                    } else if (st.ttype == StreamTokenizer.TT_WORD) {
                        productos++;                        
                    }
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error E/S: " + e.toString());
        }
        System.out.println("Total de todo: " + totalGeneral);
    }

}