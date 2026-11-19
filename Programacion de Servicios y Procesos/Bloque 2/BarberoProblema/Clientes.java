import java.util.Random;

public class Clientes implements Runnable {
    private final Recursos recursos;
    private final int id;
    private final Random random = new Random();
    private boolean atendido;

    public Clientes(Recursos recursos, int id) {
        this.recursos = recursos;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(1000) + 300);
            if (!recursos.entrar(this)) {
                System.out.println("Cliente " + id + " no encuentra una silla libre y se marcha.");
                return;
            }

            esperarFinCorte();
            System.out.println("Cliente " + id + " sale de la barbería.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Cliente " + id + " ha sido interrumpido.");
        }
    }

    private synchronized void esperarFinCorte() throws InterruptedException {
        while (!atendido) {
            wait();
        }
    }

    synchronized void terminarAtencion() {
        atendido = true;
        notifyAll();
    }
}
