package Ejercicio6.Parte_B;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int[] numeros = new int[200000000];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 101);
        }

        long inicio = System.currentTimeMillis();

        int tam = numeros.length / 4;

        HiloSuma h1 = new HiloSuma(numeros, 0, tam);
        HiloSuma h2 = new HiloSuma(numeros, tam, tam * 2);
        HiloSuma h3 = new HiloSuma(numeros, tam * 2, tam * 3);
        HiloSuma h4 = new HiloSuma(numeros, tam * 3, numeros.length);

        h1.start();
        h2.start();
        h3.start();
        h4.start();

        h1.join();
        h2.join();
        h3.join();
        h4.join();

        long sumaTotal = h1.getSuma()
                        + h2.getSuma()
                        + h3.getSuma()
                        + h4.getSuma();

        long fin = System.currentTimeMillis();

        System.out.println("Suma = " + sumaTotal);
        System.out.println("Tiempo = " + (fin - inicio) + " ms");
    }
}