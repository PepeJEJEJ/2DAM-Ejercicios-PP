package Ejercicio8;

public class Almacen {
    private String[] almacen;
    private int contador;

    public Almacen(int capacidad) {
        this.almacen = new String[capacidad];
        this.contador = 0;
    }

    public void insertarProducto(String productoID) {
        if (this.contador <= 9 && this.contador < this.almacen.length) {
            this.almacen[this.contador] = productoID;
            this.contador++;
            System.out.println("Se ha añadido: " + productoID);
        } else {
            System.out.println("Almacén lleno. No se pudo añadir: " + productoID);
        }
    }

    public void quitarProducto(String productoID) {
        int posicion = -1;
        for (int i = 0; i < this.contador; i++) {
            if (this.almacen[i] != null && this.almacen[i].equals(productoID)) {
                posicion = i;
                break;
            }
        }
        if (posicion == -1) {
            System.out.println("Producto no encontrado: " + productoID);
            return;
        }
        for (int i = posicion; i < this.contador - 1; i++) {
            this.almacen[i] = this.almacen[i + 1];
        }
        this.almacen[this.contador - 1] = null;
        this.contador--;
        System.out.println("Se ha quitado: " + productoID);
    }
}