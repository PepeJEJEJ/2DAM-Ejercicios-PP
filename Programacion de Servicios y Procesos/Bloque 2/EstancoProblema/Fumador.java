import java.util.Random;

public class Fumador implements Runnable {
    private final Mesa mesa;
    private final Ingrediente ingredienteFaltante;
    private final Random random = new Random();

    public Fumador(Mesa mesa, Ingrediente ingredienteFaltante) {
        this.mesa = mesa;
        this.ingredienteFaltante = ingredienteFaltante;
    }

    @Override
    public void run() {
        while (true) {
            try {
                mesa.tomarIngredientes(ingredienteFaltante);
                System.out.println("El fumador de " + ingredienteFaltante + " está fumando.");
                Thread.sleep(random.nextInt(900) + 300);
                System.out.println("El fumador de " + ingredienteFaltante + " ha terminado de fumar.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("El fumador de " + ingredienteFaltante + " ha sido interrumpido.");
                return;
            }
        }
    }
}
