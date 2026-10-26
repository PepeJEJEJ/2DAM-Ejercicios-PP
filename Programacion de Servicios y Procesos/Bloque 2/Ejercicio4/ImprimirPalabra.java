class ImprimirPalabra extends Thread {

    private String palabra;

    public ImprimirPalabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(palabra);
        }
    }
}
// Crea una clase encargada de recibir una palabra por parámetro e imprimirla 100 veces.
// Crea 3 hilos con 3 objetos de dicha clase ejecutándose al mismo tiempo (a cada uno le asignamos una palabra distinta).
// Pero asegúrate de que, por consola, se muestre siempre primero el que lances y, cuando acabe, los dos siguientes sí sean simultáneos.
