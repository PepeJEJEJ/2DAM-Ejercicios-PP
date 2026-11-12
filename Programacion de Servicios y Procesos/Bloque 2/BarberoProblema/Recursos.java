import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Recursos {
    private final int numeroSillas;
    private final Deque<Cliente> salaEspera;
    private final Set<Cliente> clientesAtendidos;
    private boolean abierta;

    public Recursos(int numeroSillas) {
        this.numeroSillas = numeroSillas;
        this.salaEspera = new ArrayDeque<>();
        this.clientesAtendidos = new HashSet<>();
        this.abierta = true;
    }

    public synchronized boolean ocuparSilla(Cliente cliente) {
        if (!abierta || salaEspera.size() >= numeroSillas) {
            return false;
        }

        salaEspera.addLast(cliente);
        System.out.println("Cliente " + cliente.getNumero() + " ocupa una silla de espera.");
        notifyAll();
        return true;
    }

    public synchronized Cliente cogerCliente() throws InterruptedException {
        while (salaEspera.isEmpty() && abierta) {
            System.out.println("El barbero duerme: no hay clientes.");
            wait();
        }

        if (salaEspera.isEmpty()) {
            return null;
        }

        Cliente cliente = salaEspera.removeFirst();
        System.out.println("El barbero atiende al cliente " + cliente.getNumero() + ".");
        notifyAll();
        return cliente;
    }

    public synchronized void esperarAtencion(Cliente cliente) throws InterruptedException {
        while (!clientesAtendidos.contains(cliente) && abierta) {
            wait();
        }
        clientesAtendidos.remove(cliente);
    }

    public synchronized void soltarSilla(Cliente cliente) {
        clientesAtendidos.add(cliente);
        System.out.println("El cliente " + cliente.getNumero() + " termina el corte y deja la silla.");
        notifyAll();
    }

    public synchronized void cerrar() {
        abierta = false;
        notifyAll();
    }
}