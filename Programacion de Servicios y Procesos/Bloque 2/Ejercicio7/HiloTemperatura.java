package Ej7;

import java.util.*;

public class HiloTemperatura extends Thread {
    int temperatura = 20;
    int variacion;
    Random r = new Random();
    
    @Override
    public void run() {
        while (true) {
            int variacion = r.nextInt(4);
            if (r.nextBoolean()) {
                temperatura += variacion;
            } else {
                temperatura -= variacion;
            }
            if (temperatura<0 || temperatura>40) {
                System.out.println("ERROR: Fuera de Rango");
            } else {
                System.out.println("Temperatura: "+ temperatura + " grados");
            }
            try {
                Thread.sleep(15000);
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