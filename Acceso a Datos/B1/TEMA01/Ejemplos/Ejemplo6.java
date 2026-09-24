package TEMA01;

import java.io.*;

public class Ejemplo6 {

    public static void main(String[] args) {
        RandomAccessFile file = new RandomAccessFile("./tema1/abecedatio.txt", null);
        file.seek(5);
        
    }
}