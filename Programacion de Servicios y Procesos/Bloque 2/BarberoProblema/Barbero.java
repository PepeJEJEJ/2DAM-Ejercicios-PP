import java.util.Random;

public class Barbero implements Runnable {
    private final Recursos recursos;
    private final Random random = new Random();

    public Barbero(Recursos recursos) {
        this.recursos = recursos;
    }

    @Override
    public void run() {
        try {
            Cliente cliente;
            while ((cliente = recursos.cogerCliente()) != null) {
                int tiempoCorte = random.nextInt(1500) + 800;
                System.out.println("El barbero corta el pelo al cliente " + cliente.getNumero() + ".");
                Thread.sleep(tiempoCorte);

                recursos.soltarSilla(cliente);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El barbero ha sido interrumpido.");
        }
    }
}
