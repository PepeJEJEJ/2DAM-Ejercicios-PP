public class Main {

    public static void main(String[] args) {

        ImprimirPalabra h1 = new ImprimirPalabra("UNO");
        ImprimirPalabra h2 = new ImprimirPalabra("DOS");
        ImprimirPalabra h3 = new ImprimirPalabra("TRES");

        h1.start();

        try {
            h1.join(); // Espera a que termine el primero
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        h2.start();
        h3.start(); // Estos dos se ejecutan simultáneamente
    }
}