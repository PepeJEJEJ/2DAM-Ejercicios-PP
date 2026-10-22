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
//Crea una clase encargada de redicibr una pañlabra por parametro e imprimirla 100 veces
//crea 3 hilos con 3 objetos de dicha clase ejecutandose al mismo tiempo (a cada una le asamos una palabra distinta)...
//pero asegurate de que por consola se muestra siempre primero que lances, y cuando acabe, los dos siguentes si sean simultaneos