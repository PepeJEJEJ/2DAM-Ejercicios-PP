package TEMA01;

import java.io.*;

public class Ejemplo6 {

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("./tema1/abecedario.txt", "r");
            file.seek(5);
            System.out.println("puntero antes de leer " + file.getFilePointer());
            int unbyte = file.read();
            System.out.println("puntero después de leer " + file.getFilePointer());
            System.out.println(unbyte);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
