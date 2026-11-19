package ProblemaFilosofos;

public class Main {

    public static void main(String[] args) {

        Mesa mesa = new Mesa();

        for (int i = 0; i < 5; i++) {
            new Filosofo(i, mesa).start();
        }
    }
}