package Repaso.Ej7;

import java.util.*;

public class HiloHumedad extends Thread {
    Random r = new Random();
    int humedad=10;
    int variacion;
    @Override
    public void run() {
        while (true) {
            int variacion=r.nextInt(3);
            if (variacion%2==0) {
                humedad+=variacion;
            } else {
                humedad-=variacion;
            }
            if (variacion < 0 || variacion >100) {
                System.out.println("Error: Fuera de Alcance");
            } else {
                System.out.println("Lectura de humedad relativa: "+humedad);
                try {                    
                    Thread.sleep(22000);
                } catch (Exception e) {
                    try {
                        Thread.sleep(22000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("ERROR "+e);
                }
            }
        }
    }
}