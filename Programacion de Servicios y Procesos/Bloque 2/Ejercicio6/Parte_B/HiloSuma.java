package Ejercicio6.Parte_B;

public class HiloSuma extends Thread {

    private int[] numeros;
    private int inicio;
    private int fin;
    private long suma;

    public HiloSuma(int[] numeros, int inicio, int fin) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fin; i++) {
            suma += numeros[i];
        }
    }

    public long getSuma() {
        return suma;
    }
}
