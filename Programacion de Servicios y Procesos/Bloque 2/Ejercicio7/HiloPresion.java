package Repaso.Ej7;

import java.util.*;

public class HiloPresion extends Thread {
    Random r = new Random();
    int presion = 5;
    int variacion;

    @Override
    public void run() {
        while (true) {
            int variacion = r.nextInt(3);
            if (variacion % 2 == 0) {
                presion += variacion;
            } else {
                presion -= variacion;
            }
            if (variacion < 0 || variacion > 5) {
                System.out.println("Error: Fuera de Alcance");
            } else {
                System.out.println("Lectura de presión atmosférica: "+presion);
                try {
                    Thread.sleep(18000);
                } catch (Exception e) {
                    try {
                        Thread.sleep(18000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("ERROR " + e);
                }
            }
        }
    }
}