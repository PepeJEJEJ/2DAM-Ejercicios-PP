package Ejercicio8;

public class AlmacenCorrecto {
        private String[] almacen;
    private int contador;

    public AlmacenCorrecto(int capacidad) {
        this.almacen = new String[capacidad];
        this.contador = 0;
    }
        public synchronized void insertarProducto(String productoID){
        while (contador >= almacen.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        almacen[contador++] = productoID;
        notifyAll();
    }

    public synchronized String quitarProducto() {
        while (contador == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        String producto = almacen[--contador];
        almacen[contador] = null;
        notifyAll();
        return producto;
    }
}
