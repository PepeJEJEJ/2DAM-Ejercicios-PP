/*
 * ACCESO A DATOS - EXAMEN BLOQUE 1
 * EJERCICIO 3 - 3 puntos
 *
 * ENUNCIADO
 * En un mini buscaminas hay 10 posiciones, numeradas del 0 al 9. El fichero de
 * texto "minas.txt" ya existe y tiene un caracter por posicion: '-' si no hay
 * nada y '*' en la posicion donde esta la mina. Por ejemplo, este es su
 * contenido ahora (la mina esta en la posicion 6):
 *      ------*---
 *
 * Completa el programa para que pregunte al jugador por una posicion, una y otra
 * vez, hasta que encuentre la mina:
 *   1. Pide el numero de posicion (0-9).
 *   2. Si esta fuera de ese rango, avisa de que esa posicion no existe y vuelve
 *      a preguntar.
 *   3. Si la posicion existe, lee su contenido en el fichero:
 *        - si NO hay mina, muestra "Aqui no hay mina." y vuelve a preguntar;
 *        - si hay mina ('*'), la cambia por '$' en el fichero, muestra que el
 *          jugador ha acertado y termina de preguntar.
 *   4. Cierra el fichero.
 *   5. Trata la excepcion si se produce un error de lectura o escritura.
 *
 * REQUISITOS
 *  - Repite la pregunta con un bucle while.
 *  - Accede a cada posicion usando su lugar en el fichero, sin recorrer las anteriores.
 *  - Modifica solo la posicion de la mina: el resto del fichero no debe cambiar.
 *  - Para volver a probar el programa, pon otra vez el '*' en minas.txt
 *    (ya que si no hay ninguna mina en el fichero, el programa no termina nunca).
 *
 * EJEMPLO
 *  Con minas.txt = ------*---
 *      Posicion (0-9): 12
 *      Esa posicion no existe.
 *      Posicion (0-9): 2
 *      Aqui no hay mina.
 *      Posicion (0-9): 6
 *      Has acertado: la mina estaba en la posicion 6.
 *  y el fichero queda ------$---
 *
 * AYUDA
 *   Leer un numero por teclado:   int n = sc.nextInt();
 *   Abrir para leer y escribir:   new RandomAccessFile(ruta, "rw")
 *   Ir a una posicion:            fichero.seek(posicion);
 *   Leer un caracter:             int c = fichero.read();
 *   Escribir un caracter:         fichero.write('$');
 *   Cerrar el fichero:            fichero.close();
 */
/*
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        String ruta = "minas.txt";
        boolean encontrado = false;
        Scanner sc = new Scanner(System.in);
        

        try {
            RandomAccessFile raf = new RandomAccessFile(ruta, "rw");
            //No lo hice por falta de tiempo
            
        } catch (Exception e) {
            System.out.println("Error E/S: " + e.toString());
        }
        

    }

}*/