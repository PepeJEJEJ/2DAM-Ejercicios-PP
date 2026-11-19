package Ejercicio2;

public class Division extends Thread {

    private int n1, n2;

    public Division(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void run() {
        if (n2 != 0) {
            System.out.println("Division = " + ((double) n1 / n2));
        } else {
            System.out.println("No se puede dividir entre 0");
        }
    }
}