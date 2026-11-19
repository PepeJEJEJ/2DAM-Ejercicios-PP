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
            while (true) {
                Clientes cliente = recursos.esperarCliente();
                if (cliente == null) {
                    return;
                }

                int tiempoCorte = random.nextInt(1500) + 800;
                System.out.println("El barbero empieza el corte del Cliente " + cliente.getId()
                        + " (" + tiempoCorte + " ms).");
                Thread.sleep(tiempoCorte);
                recursos.terminarCorte();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El barbero ha sido interrumpido.");
        }
    }
}
