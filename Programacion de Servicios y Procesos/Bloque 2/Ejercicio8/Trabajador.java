package Ejercicio8;

import java.util.Random;

public class Trabajador extends Thread {
    private Almacen almacen;
    private Random random = new Random();

    public Trabajador(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Espera aleatoria entre 1 y 5 segundos
                int espera = 1000 + random.nextInt(4001); // 1000 a 5000 ms
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.almacen.quitarProducto();
        }
    }
}