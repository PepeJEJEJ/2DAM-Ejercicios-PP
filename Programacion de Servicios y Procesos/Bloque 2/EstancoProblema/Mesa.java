import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Mesa {
    private final Semaphore[] semaforos = {
        new Semaphore(0),
        new Semaphore(0),
        new Semaphore(0)
    };

    private final Object lock = new Object();
    private Ingrediente[] ingredientesEnMesa;

    public void dejarIngredientes(Ingrediente[] ingredientes) throws InterruptedException {
        synchronized (lock) {
            while (ingredientesEnMesa != null) {
                lock.wait();
            }
            ingredientesEnMesa = ingredientes;
        }

        for (Ingrediente ingrediente : Ingrediente.values()) {
            if (!contiene(ingredientes, ingrediente)) {
                semaforos[ingrediente.ordinal()].release();
            }
        }
    }

    public Ingrediente[] tomarIngredientes(Ingrediente ingrediente) throws InterruptedException {
        semaforos[ingrediente.ordinal()].acquire();

        synchronized (lock) {
            while (ingredientesEnMesa == null || contiene(ingredientesEnMesa, ingrediente)) {
                lock.wait();
            }

            Ingrediente[] ingredientes = ingredientesEnMesa;
            ingredientesEnMesa = null;
            lock.notifyAll();
            return ingredientes;
        }
    }

    private boolean contiene(Ingrediente[] ingredientes, Ingrediente ingrediente) {
        return Arrays.asList(ingredientes).contains(ingrediente);
    }
}
