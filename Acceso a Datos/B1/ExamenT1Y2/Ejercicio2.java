/*
 * ACCESO A DATOS - EXAMEN BLOQUE 1
 * EJERCICIO 2 - 2 puntos
 * 
 * ENUNCIADO
 * Copia el fichero que contiene gran cantidad de texto "textogrande.txt" 
 * en un nuevo fichero llamado "textogrande_copia.txt", leyendola
 * por bloques con streams con buffer. Despues de copiar cada bloque, muestra el
 * numero de bloque y los bytes copiados hasta ese momento. Al terminar, muestra
 * cuantos bloques se han leido y cuantos bytes se han copiado en total.
 * 
 * REQUISITOS
 *  - Los bloques son de 32 KB (la variable tamBloque ya esta definida).
 *  - Los dos ficheros deben quedar cerrados al terminar el programa.
 *  - Al escribir cada bloque, escribe solo los bytes que se han leido.
 *
 * EJEMPLO
 *  Si textogrande.txt ocupa 193499 bytes, la salida del programa es:
 *      1 - Copiado: 32768 bytes
 *      2 - Copiado: 65536 bytes
 *      3 - Copiado: 98304 bytes
 *      4 - Copiado: 131072 bytes
 *      5 - Copiado: 163840 bytes
 *      6 - Copiado: 193499 bytes
 *      Bloques leidos totales: 6
 *      Bytes copiados totales: 193499
 *  y textogrande_copia.txt se debería ver igual que textogrande.txt
 *
 * AYUDA
 *   Leer bytes con buffer:        new BufferedInputStream(new FileInputStream(ruta))
 *   Escribir bytes con buffer:    new BufferedOutputStream(new FileOutputStream(ruta))
 *   Leer un bloque:               int leidos = entrada.read(array);
 *                                 (devuelve los bytes leidos, o -1 si no queda nada)
 *   Escribir un bloque:           salida.write(array, desde, cuantos);
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        String origen = "textogrande.txt";
        String destino = "textogrande_copia.txt";
        int tamBloque = 32*1024; //32KB
        byte[] Byte=new byte[tamBloque];
        int BlocLeidos=0;
        int cuenta=0;
        int BloqTotales=0;
        int leidos;
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("textogrande.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("textogrande_copia.txt"));
            while((leidos=bis.read(Byte))!=-1){
            cuenta++;
            bos.write(Byte,0,tamBloque);
            BlocLeidos++;
            BloqTotales++;
            System.out.println(cuenta+" - Copiado: "+BlocLeidos+" Bytes Leidos");
            System.out.println("Bloques Totales Leidos: "+BloqTotales);
            }
        } catch (IOException e) {
            System.out.println("Error E/S: " + e.getMessage().toString());
        }
    }
}
