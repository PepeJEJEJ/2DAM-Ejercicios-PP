package Hilos;

public class Appv1 {

    public static void main(String[] args) {

        // 1 - Generar el array con enteros aleatorios [0, 100]
        long t0 = System.currentTimeMillis();
        int[] datos = new int[200_000_000]; //Un int ocupa 4bytes, este array ocupa aproximadamente 800MB
        llenarAleatorio(datos);
        long t1 = System.currentTimeMillis();
        System.out.println("Generación de datos en " + (t1 - t0) + " ms");

        // 2 - Suma de todos los valores
        t0 = System.currentTimeMillis();
        long sum = suma(datos);
        t1 = System.currentTimeMillis();
        System.out.println("Suma: " + sum + " en " + (t1 - t0) + " ms)");




    }

    // Rellena el array con aleatorios
    private static void llenarAleatorio(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int)(Math.random()*101);
        }
    }

    // Suma de todo el array
    private static long suma(int[] datos) {
        long s = 0;
        for (int i = 0; i < datos.length; i++) {
            s += datos[i];
        }
        return s;
    }

}
