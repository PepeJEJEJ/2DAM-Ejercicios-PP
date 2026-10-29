package Ejercicio8;

public class App {
    public static void main(String[] args) {
        Almacen a = new Almacen(33);

        Cliente cliente1 = new Cliente("Juan",  a);
        Cliente cliente2 = new Cliente("María", a);
        Cliente cliente3 = new Cliente("Diego", a);

        Trabajador trabajador1 = new Trabajador(a);
        Trabajador trabajador2 = new Trabajador(a);

        cliente1.start();
        cliente2.start();
        cliente3.start();
        trabajador1.start();
        trabajador2.start();
    }
}