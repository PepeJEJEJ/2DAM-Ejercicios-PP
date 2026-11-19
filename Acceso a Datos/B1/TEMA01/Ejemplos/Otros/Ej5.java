package Otros;

import java.io.*;

public class Ej5 {
    public static void main(String[] args) {
        try {
            long inicio1 = System.currentTimeMillis();

            FileInputStream in1 = new FileInputStream("video.mp4");
            FileOutputStream out1 = new FileOutputStream("video_copia1.mp4");

            int b;
            while ((b = in1.read()) != -1) {
                out1.write(b);
            }

            in1.close();
            out1.close();

            long fin1 = System.currentTimeMillis();
            System.out.println("Tiempo sin buffer: " + (fin1 - inicio1) + " ms");

            long inicio2 = System.currentTimeMillis();

            BufferedInputStream in2 =
                new BufferedInputStream(new FileInputStream("video.mp4"));
            BufferedOutputStream out2 =
                new BufferedOutputStream(new FileOutputStream("video_copia2.mp4"));

            byte[] buffer = new byte[4096];
            int leidos;

            while ((leidos = in2.read(buffer)) != -1) {
                out2.write(buffer, 0, leidos);
            }

            in2.close();
            out2.close();

            long fin2 = System.currentTimeMillis();
            System.out.println("Tiempo con buffer: " + (fin2 - inicio2) + " ms");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
