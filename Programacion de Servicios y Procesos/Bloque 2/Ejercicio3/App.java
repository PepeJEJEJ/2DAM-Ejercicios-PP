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
 * CREAR EL JUEGO DE ADIVINAR UN NUMERO ENTRE EL 0 AL 100 (SIN MOSTRAR AL
 * USUARIO)
 * Y VA PIDIENDO NIMEROS AL USUARIO DICIENDO MAYOR O MENOR HASTA QUE ESTE
 * CONSGIA ADIVINARLO,
 * AL MISMO TIEMPO, EL PROBRANA NISTRARA UNA CUENTA DE 30 SEGUNDOS
 * (ES NORMAL QUE SIGA EL CRONOMETRO AUNQUE ADIVINEMOS EL JUEGO, Y SE QUEDA ASI
 * POR AHORA)
 */