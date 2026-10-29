package Ejercicio8;

public class Cliente extends Thread {
    private int n = 1;
    private String nombreCliente;
    private Almacen a;

    public Cliente(String nombre, Almacen al) {
        this.nombreCliente = nombre;
        this.a = al;
    }

    @Override
    public void run() {
        while (true) {
            String prodId = "prod" + n + "de" + nombreCliente;
            this.a.insertarProducto(prodId);
            n++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}