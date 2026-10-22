package Ejercicio6.Parte_A;

public class Main {

    public static void main(String[] args) {

        long inicio = System.currentTimeMillis();

        int[] numeros = new int[200000000];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 101);
        }

        long suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        long fin = System.currentTimeMillis();

        System.out.println("Tiempo = " + (fin - inicio) + " ms");
        System.out.println("Suma = " + suma);
    }
}