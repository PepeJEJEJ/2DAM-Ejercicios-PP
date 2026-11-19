import java.util.ArrayDeque;
import java.util.Deque;

public class Recursos {
    private final int sillasEspera;
    private final Deque<Clientes> salaEspera = new ArrayDeque<>();
    private boolean abierto = true;
    private Clientes clienteActual;

    public Recursos(int sillasEspera) {
        if (sillasEspera < 0) {
            throw new IllegalArgumentException("El número de sillas no puede ser negativo.");
        }
        this.sillasEspera = sillasEspera;
    }

    public synchronized boolean entrar(Clientes cliente) {
        if (salaEspera.size() >= sillasEspera) {
            return false;
        }

        salaEspera.addLast(cliente);
        System.out.println("Cliente " + cliente.getId() + " se sienta en la sala de espera ("
                + salaEspera.size() + "/" + sillasEspera + ").");
        notifyAll();
        return true;
    }

    public synchronized Clientes esperarCliente() throws InterruptedException {
        while (salaEspera.isEmpty() && abierto) {
            System.out.println("El barbero duerme: no hay clientes.");
            wait();
        }

        if (salaEspera.isEmpty()) {
            return null;
        }

        clienteActual = salaEspera.removeFirst();
        System.out.println("El barbero atiende al Cliente " + clienteActual.getId() + ".");
        return clienteActual;
    }

    public synchronized void terminarCorte() {
        if (clienteActual != null) {
            System.out.println("El barbero termina con el Cliente " + clienteActual.getId() + ".");
            clienteActual.terminarAtencion();
            clienteActual = null;
        }
    }

    public synchronized void cerrar() {
        abierto = false;
        notifyAll();
    }
}