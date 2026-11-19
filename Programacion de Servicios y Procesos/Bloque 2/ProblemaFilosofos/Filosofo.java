package ProblemaFilosofos;

public class Filosofo extends Thread {

    private final int id;
    private final Mesa mesa;

    public Filosofo(int id, Mesa mesa) {
        this.id = id;
        this.mesa = mesa;
    }

    @Override
    public void run() {

        try {

            while (true) {

                System.out.println("Filósofo " + id + " pensando");
                Thread.sleep((int) (Math.random() * 3000) + 3000);

                mesa.cogerTenedores(id);

                System.out.println("Filósofo " + id + " comiendo");
                Thread.sleep((int) (Math.random() * 3000) + 3000);

                mesa.soltarTenedores(id);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}