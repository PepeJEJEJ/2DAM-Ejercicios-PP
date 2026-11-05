package ProblemaFilosofos;

public class Mesa {

    private final boolean[] tenedores = new boolean[5];

    public synchronized void cogerTenedores(int id) throws InterruptedException {

        int izquierda = id;
        int derecha = (id == 0) ? 4 : id - 1;

        while (tenedores[izquierda] || tenedores[derecha]) {
            wait();
        }

        tenedores[izquierda] = true;
        tenedores[derecha] = true;

        System.out.println("Filósofo " + id + " coge tenedores " +
                izquierda + " y " + derecha);
    }

    public synchronized void soltarTenedores(int id) {

        int izquierda = id;
        int derecha = (id == 0) ? 4 : id - 1;

        tenedores[izquierda] = false;
        tenedores[derecha] = false;

        System.out.println("Filósofo " + id + " suelta tenedores " +
                izquierda + " y " + derecha);

        notifyAll();
    }
}