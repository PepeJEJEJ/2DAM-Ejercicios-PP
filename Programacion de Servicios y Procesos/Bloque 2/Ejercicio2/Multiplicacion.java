package Ejercicio2;

public class Multiplicacion extends Thread {

    private int n1, n2;

    public Multiplicacion(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void run() {
        System.out.println("Multiplicacion = " + (n1 * n2));
    }
}