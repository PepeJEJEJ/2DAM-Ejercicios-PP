package TEMA01;

import java.io.*;

public class Ejemplo6 {

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("./tema1/abecedario.txt", "r");
            file.seek(5);
            long filePointer = file.getFilePointer();
            System.out.println("Puntero ANTES de leer: " + file.getFilePointer());
            int unByte = file.read();
            System.out.println("puntero después de leer " + file.getFilePointer());
            System.out.println((char) unByte);
            file.write('X');
            System.out.println("Puntero DESPUES de escribir: " + file.getFilePointer());
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}