package Ejercicio1;
public class App {
    public static void main(String[] args) {
        try {
            Hilo hilo1 = new Hilo();
            Hilo hilo2 = new Hilo();
            Hilo hilo3 = new Hilo();
            Hilo hilo4 = new Hilo();
            hilo1.start();
            hilo1.join();
            hilo2.start();
            hilo3.start();
            hilo4.start();
        } catch (Exception e) {
            System.out.println("ERROR "+e);
        }
    }
}