package Ejemplos.ejemplo4;

import java.io.*;

public class ejemplo4A {
    public static void main(String[] args) {
        try {
            FileReader fr= new FileReader("null");
            int data;
            while ((data=fr.read())!=-1) {
                System.out.println((char)data);
            }fr.close();
        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
