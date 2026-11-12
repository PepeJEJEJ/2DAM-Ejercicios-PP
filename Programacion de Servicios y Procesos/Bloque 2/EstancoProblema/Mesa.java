import java.util.Arrays;

public class Mesa {
    private final Object lock = new Object();
    private Ingrediente[] ingredientesEnMesa;

    public void dejarIngredientes(Ingrediente[] ingredientes) throws InterruptedException {
        synchronized (lock) {
            while (ingredientesEnMesa != null) {
                lock.wait();
            }

            ingredientesEnMesa = ingredientes;
            lock.notifyAll();
        }
    }

    public Ingrediente[] tomarIngredientes(Ingrediente ingrediente) throws InterruptedException {
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
