package Ej7;
import java.util.*;

public class HiloPresion extends Thread{
    double presion = 0.2;
    double variacion;
    Random r = new Random();
    
    @Override
    public void run() {
        while (true) {
            double variacion = r.nextDouble(0.5);
            if (r.nextBoolean()) {
                presion += variacion;
            } else {
                presion -= variacion;
            }
            if (presion<0 || presion>100) {
                System.out.println("ERROR: Fuera de Rango");
            } else {
                System.out.println("presion: "+ presion + " atm");
            }
            try {
                Thread.sleep(18000);
            } catch (Exception e) {
                System.out.println("ERROR: "+e);
            }
        }
    }
}