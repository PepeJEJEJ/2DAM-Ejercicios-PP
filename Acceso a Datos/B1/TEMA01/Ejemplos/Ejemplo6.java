package TEMA01;

import java.io.*;

public class Ejemplo6 {

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("./tema1/abecedatio.txt", "r");
            file.seek(5);
            long puntero = file.getFilePointer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}