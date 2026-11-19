package Hilos;

public class Appv2 {

    private static long sumaTotal = 0L;


    public static void main(String[] args) {

        long t0 = System.currentTimeMillis();
        int[] datos = new int[200_000_000];

        Hilo h1 = new Hilo(datos, 0, 50000000);
        Hilo h2 = new Hilo(datos, 50000001, 100000000);
        Hilo h3 = new Hilo(datos, 100000001, 150000000);
        Hilo h4 = new Hilo(datos, 150000001, 200000000);
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();


        // Esperar a que vayan acabando y obtener sus sumaTramo para calcular la suma total

        try {

            h1.join();
            h2.join();
            h3.join();
            h4.join();

            sumaTotal = h1.getSumaTramo() + h2.getSumaTramo() + h3.getSumaTramo() + h4.getSumaTramo();

        } catch (Exception e) {
            // TODO: handle exception
        }


        // Mostrar resultados por consola
        long t1 = System.currentTimeMillis();

        System.out.println("Suma Total: " + sumaTotal);
        System.out.println("Tiempo que tarda en total: " + (t1-t0) + " ms");

    }
}
