public class MainVez {
    public static void main(String[] args) {
        Copia hiloSis=new Copia("Sistema", 4, 10);
        Copia hiloDoc=new Copia("Documentos", 6, 5);
        Copia hiloMus=new Copia("Musica", 4, 10);
        try {
            System.out.println("Copia de Todas a la Vez");
            hiloSis.start();
            hiloDoc.start();
            hiloMus.start();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}