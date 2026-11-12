import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Recursos recursos = new Recursos(3);
        Thread barbero = new Thread(new Barbero(recursos), "Barbero");
        barbero.start();

        List<Thread> clientes = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            Thread cliente = new Thread(new Clientes(recursos, i), "Cliente-" + i);
            clientes.add(cliente);
            cliente.start();
        }

        for (Thread cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("La ejecución principal ha sido interrumpida.");
            }
        }

        recursos.cerrar();

        try {
            barbero.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El barbero ha sido interrumpido.");
        }
    }
}
