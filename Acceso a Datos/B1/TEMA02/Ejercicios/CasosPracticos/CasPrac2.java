package CasosPracticos;
import java.io.*;

public class CasPrac2 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("origen.txt");
            FileWriter fw = new FileWriter("baseGeneral.txt",true);
            int datos;
            while ((datos=fr.read())!=-1) {
                fw.write(datos);
            }
            fw.close();
            fr.close();
            System.out.println("Copia terminada.");
        } catch (Exception e) {
            System.out.println("ERROR "+e.toString());
        }
    }
}
