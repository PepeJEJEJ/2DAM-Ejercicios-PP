import java.util.*;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int secreto = r.nextInt(101); // ES DE 0-100 POR LA LOGICA DE QUE JAVA EMPIEZA DESDE EL 0
        int numero;

        HiloCronometro cronometro = new HiloCronometro();
        cronometro.start();

        do {
            System.out.print("Introduce un número: ");
            numero = sc.nextInt();

            if (numero < secreto) {
                System.out.println("MAYOR");
            } else if (numero > secreto) {
                System.out.println("MENOR");
            }

        } while (numero != secreto);

        System.out.println("¡¡HAS ACERTADO!! El número era " + secreto);
    }
}
/*
 * Crear el juego de adivinar un número entre el 0 y el 100 (sin mostrarlo al
 * usuario).
 * Va pidiendo números al usuario, indicando si el número es mayor o menor,
 * hasta que consiga adivinarlo.
 * Al mismo tiempo, el programa mostrará una cuenta atrás de 30 segundos.
 * (Es normal que siga el cronómetro aunque adivinemos el número, y se queda así
 * por ahora).
 */
