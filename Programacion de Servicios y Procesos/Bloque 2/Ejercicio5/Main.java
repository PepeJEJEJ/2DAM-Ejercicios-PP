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
//CREA UNA CLASE LLAMADA JUGADOR QUE TOME UN NOMBRE POR PARAMETRO  Y REALICE UN BUCLE DEL 1 AL 10
//IMPRIMIENDO EN CADA ITERACION LA FRASE "EL JUGADOR *NOMBRE* VA POR EL NUMERO I"
//ENTRE UNA A OTRA ITERACION, SE DEBE ESPERAR UN TIEMPO ALEATORIO ENTRE 1 Y 3 SEGS.
//EN EL MAIN, CREA 5 JUGADORES Y LANZALOS AL MISMO TIEMPO, COMPRUEBA QUIEN "GANA LA CARRERA", O SEA, QUIEN IMPPRIME 1º SU NUMERO 10