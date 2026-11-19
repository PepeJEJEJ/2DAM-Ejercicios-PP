import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Estanquero implements Runnable {
    private final Mesa mesa;
    private final Random random = new Random();

    public Estanquero(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Ingrediente[] ingredientes = generarPar();
                System.out.println("El estanquero deja en la mesa: " + ingredientes[0] + " y " + ingredientes[1]);
                mesa.dejarIngredientes(ingredientes);
                Thread.sleep(random.nextInt(1200) + 400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("El estanquero ha sido interrumpido.");
                return;
            }
        }
    }

    private Ingrediente[] generarPar() {
        List<Ingrediente> ingredientes = new ArrayList<>(List.of(Ingrediente.values()));
        Collections.shuffle(ingredientes);
        return new Ingrediente[] { ingredientes.get(0), ingredientes.get(1) };
    }
}
