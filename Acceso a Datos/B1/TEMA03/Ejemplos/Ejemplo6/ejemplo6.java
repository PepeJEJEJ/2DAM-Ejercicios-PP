package Ejemplos.Ejemplo6;

public class ejemplo6 {
    public static void main(String[] args) {
        try {
            String texto=null;
            int longitud=texto.length();
            System.out.println(longitud);
        } catch (NullPointerException e) {
            System.out.println("Excepcion controlada "+e.getMessage());
            e.printStackTrace();
        }
    }
}
