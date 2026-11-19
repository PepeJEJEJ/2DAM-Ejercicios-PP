package Ejercicio5;

public class Jugador extends Thread {

    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("El jugador " + nombre + " va por el numero " + i);
            try {
                int tiempo = (int) (Math.random() * 2001) + 1000;
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(">>> " + nombre + " HA TERMINADO LA CARRERA");
    }
}