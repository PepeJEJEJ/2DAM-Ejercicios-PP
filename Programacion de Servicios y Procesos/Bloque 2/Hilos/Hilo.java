import java.util.Random;

public class Hilo extends Thread{
    int[] array;
    int minIndex, maxIndex;
    public long sumaTramo;
    private final Random rnd = new Random();

    public Hilo(int[] a, int minIndex, int maxIndex){
        this.array = a;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
        this.sumaTramo = 0;
    }

    @Override
    public void run() {
        llenarAleatorio();
        suma();
    }

    // Rellena el array con aleatorios
    private void llenarAleatorio() {
        for (int i = this.minIndex; i < this.maxIndex; i++) {
            
            // Usamos java.util.Random en lugar de Math.random() porque cada hilo tiene su propio generador, evitando que todos los hilos compitan por el mismo recurso y se frene la ejecución.
            this.array[i] = rnd.nextInt(101);
        
        }
    }

    // Suma de todo el array
    private void suma() {
        for (int i = this.minIndex; i < this.maxIndex; i++) {
            this.sumaTramo += array[i];
        }
    }

    public long getSumaTramo(){
        return this.sumaTramo;
    }
}
