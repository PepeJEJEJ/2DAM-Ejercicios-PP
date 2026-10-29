// CLASE Main · la copia de seguridad: primero en paralelo, después de una en una, y compara
public class Main {
    public static void main(String[] args) {
        Copia hiloSis=new Copia("Sistema",4,10);
        Copia hiloDoc=new Copia("Documentos",6,5);
        Copia hiloMus=new Copia("Musica",4,10);
        try {
        System.out.println("Copia Una por Una");
        hiloSis.start();
        hiloSis.join();
        hiloDoc.start();
        hiloDoc.join();
        hiloMus.start();
        hiloMus.join();
        hiloDoc.interrupt();
        hiloSis.interrupt();
        hiloMus.interrupt();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}