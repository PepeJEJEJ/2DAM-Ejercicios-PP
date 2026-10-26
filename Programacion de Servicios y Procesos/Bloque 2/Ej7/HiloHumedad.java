package Ej7;
import java.util.*;

public class HiloHumedad extends Thread{
    int humedad = 50;
    int variacion;
    Random r = new Random();
    
    @Override
    public void run() {
        while (true) {
            int variacion = r.nextInt(11);
            if (r.nextBoolean()) {
                humedad += variacion;
            } else {
                humedad -= variacion;
            }
            if (humedad<0 || humedad>100) {
                System.out.println("ERROR: Fuera de Rango");
            } else {
                System.out.println("humedad: "+ humedad + " %");
            }
            try {
                Thread.sleep(22000);
            } catch (Exception e) {
                System.out.println("ERROR: "+e);
            }
        }
    }
}
/*
 * Mientras (true)
 * Generar variación aleatoria
 * Sumar/restar al valor actual
 * Comprobar rango
 * Mostrar resultado
 * Dormir X segundos
 */