public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();

        Thread estanquero = new Thread(new Estanquero(mesa), "Estanquero");
        Thread fumadorTabaco = new Thread(new Fumador(mesa, Ingrediente.TABACO), "FumadorTabaco");
        Thread fumadorPapel = new Thread(new Fumador(mesa, Ingrediente.PAPEL), "FumadorPapel");
        Thread fumadorCerillas = new Thread(new Fumador(mesa, Ingrediente.CERILLAS), "FumadorCerillas");

        fumadorTabaco.start();
        fumadorPapel.start();
        fumadorCerillas.start();
        estanquero.start();
    }
}
