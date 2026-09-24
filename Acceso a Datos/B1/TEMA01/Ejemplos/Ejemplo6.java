package TEMA01;

import java.io.*;

public class Ejemplo6 {

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("./tema1/abecedatio.txt", "r");
            file.seek(5);
            sout(puntero antes de leer + file.getFilePoiter());
            int unbyte=file.read();
            sout(puntero despues de leer + file.getFilePoiter());
            sout(unbyte);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}