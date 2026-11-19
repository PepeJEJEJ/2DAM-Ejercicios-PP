public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("notepad.exe");//EL QUE EJECUTAMOS
            Process p = pb.start();//CREAR EL PROCESO
            Thread.sleep(5000); //CINCO SEGUNDOS
            p.destroy(); //TERMINAR
        } catch (Exception e) {
        }
    }
}
