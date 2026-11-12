public class Main {
    public static void main(String[] args) {
        Recursos recursos = new Recursos(3);
        Thread barbero = new Thread(new Barbero(recursos), "Barbero");
        barbero.start();

        Thread[] clientes = new Thread[8];
        for (int i = 1; i <= 8; i++) {
            clientes[i - 1] = new Thread(new Cliente(recursos, i), "Cliente-" + i);
            clientes[i - 1].start();
        }

        for (Thread cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("La ejecución principal ha sido interrumpida.");
                recursos.cerrar();
                return;
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
