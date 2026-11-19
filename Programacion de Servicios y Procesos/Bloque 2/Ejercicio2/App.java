package Ejercicio2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el primer numero: ");
        int n1 = sc.nextInt();
        System.out.print("Introduce el segundo numero: ");
        int n2 = sc.nextInt();
        Suma suma = new Suma(n1, n2);
        Resta resta = new Resta(n1, n2);
        Multiplicacion multiplicacion = new Multiplicacion(n1, n2);
        Division division = new Division(n1, n2);
        suma.start();
        resta.start();
        multiplicacion.start();
        division.start();
    }
}
//CREA 3 CLASES, UNA RECIBE 2 NUMEROS POR PARAMETRO Y SUMARLOS, OTRA DE RECIVIR 2 NUMEROS Y RESTARLOS, Y LO MISMO
//PARA LA MULTIPLICACION Y DIVISION
//EN TU MAIN, PIDE AL USUARIO 2 NUMEROS Y HAZ 4 HILOS CORRESPONDIENTES
//A CADA UNA DE LAS CLASES ANTERIORES PASANDOLE LOS NUMEROS DEL USUARIO DE FORMA QUE LAS 4 CUENTAS SE HAGAN
//<<SIMULTANEAMENTE>>