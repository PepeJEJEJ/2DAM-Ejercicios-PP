package Ejemplos.ejemplo5;

public class Ejemplo5 {
    public static void main(String[] args) {
        try {
            int [] numbers={1,2,3};
            System.out.println(numbers[5]);
            System.out.println("Ocurrio una excepcion: Indice fuera de rango");
        } catch (Exception e) {
            System.out.println("excepcion controlada "+e.toString());
        }
    }
}
