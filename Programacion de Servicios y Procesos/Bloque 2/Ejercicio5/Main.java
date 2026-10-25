package Ejercicio5;

public class Main {

    public static void main(String[] args) {

        Jugador j1 = new Jugador("Elver Galarga");
        Jugador j2 = new Jugador("Alberto Orcido");
        Jugador j3 = new Jugador("Larry Kapija");
        Jugador j4 = new Jugador("Rosa Melano");
        Jugador j5 = new Jugador("Elpi Tote");

        j1.start();
        j2.start();
        j3.start();
        j4.start();
        j5.start();
    }
}
// Crea una clase llamada Jugador que tome un nombre por parámetro y realice un bucle del 1 al 10.
// Imprimiendo en cada iteración la frase: "El jugador *nombre* va por el número i".
// Entre una y otra iteración, se debe esperar un tiempo aleatorio entre 1 y 3 segundos.
// En el main, crea 5 jugadores y lánzalos al mismo tiempo.
// Comprueba quién "gana la carrera", es decir, quién imprime primero su número 10.
