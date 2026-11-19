import java.io.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA01\\Ejercicios\\Imagen.png");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA01\\Ejercicios\\Imagen_Copia.png");
            int data;
            int contador=0;
            long inicio1=System.currentTimeMillis();
            while ((data=fis.read())!=-1) {
                fos.write(data);
                contador++;
            }
            System.out.println("Se han copiado "+contador+" bytes");
            long final1=System.currentTimeMillis();
            System.out.println("FileInputStream ha tardado "+(final1-inicio1)+" ms");
            fis.close();
            fos.close();
        } catch (Exception e) {
            System.err.println("Error "+e);
        }
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA01\\Ejercicios\\Imagen.png"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA01\\Ejercicios\\Imagen_Copia_Buffered.png"));
            //COGES UN BLOQUE         LEES 5 BYTES DEL BLOQUE
            byte[] buffered = new byte[5];
            int bytesLeidos;
            int contador=0;
            long ms = System.currentTimeMillis();
            while ((bytesLeidos=bis.read(buffered))!=-1) {
                bos.write(buffered,0,bytesLeidos);
                contador++;
            }
            long msdespues=System.currentTimeMillis();
            System.out.println("Se han copiado "+contador+" bytes");
            System.out.println("Ha pasado "+(msdespues-ms)+" ms");
            bis.close();
            bos.close();
        } catch (Exception e) {
            System.err.println("Error "+e);
        }
    }
}
