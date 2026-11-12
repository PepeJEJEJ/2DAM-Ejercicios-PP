public class Cliente implements Runnable {
    private final Recursos recursos;
    private final int numero;

    public Cliente(Recursos recursos, int numero) {
        this.recursos = recursos;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000) + 300);
            if (!recursos.ocuparSilla(this)) {
                System.out.println("El cliente " + numero + " se marcha: no hay sillas libres.");
                return;
            }

            recursos.esperarAtencion(this);
            System.out.println("El cliente " + numero + " se marcha atendido.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El cliente " + numero + " ha sido interrumpido.");
        }
    }
}
