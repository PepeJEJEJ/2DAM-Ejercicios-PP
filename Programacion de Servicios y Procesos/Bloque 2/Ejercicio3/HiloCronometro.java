
public class HiloCronometro extends Thread {

    @Override
    public void run() {
        for (int i = 30; i >= 0; i--) {
            System.out.println("Tiempo restante: " + i + " segundos");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}