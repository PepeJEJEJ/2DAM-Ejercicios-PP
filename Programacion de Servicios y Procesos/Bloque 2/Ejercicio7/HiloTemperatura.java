package Repaso.Ej7;

import java.util.*;

public class HiloTemperatura extends Thread {
    Random r = new Random();
    int temperatura=20;
    int variacion;
    @Override
    public void run() {
        while (true) {
            int variacion=r.nextInt(3);
            if (variacion%2==0) {
                temperatura+=variacion;
            } else {
                temperatura-=variacion;
            }
            if (variacion < 0 || variacion >40) {
                System.out.println("Error: Fuera de Alcance");
            } else {
                System.out.println("Lectura de temperatura: "+temperatura);
                try {                    
                    Thread.sleep(15000);
                } catch (Exception e) {
                    try {
                        Thread.sleep(15000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("ERROR "+e);
                }
            }
        }
    }
}
