// CLASE Copia · copia los ficheros de una carpeta
public class Copia extends Thread{
    String carpeta;
    int mb;
    int x;
    public Copia(String carpeta, int x, int mb){
        this.carpeta=carpeta;
        this.mb=mb;
        this.x=x;
    }
    public void run(){
        long tiempo=System.currentTimeMillis();
        for (int i = 0; i < x; i++) {            
        System.out.println("["+carpeta+"] "+" fichero "+i+" de "+x+ "("+mb+" MB)");
        try {            
        Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
            if (i>=x) {
        System.out.println("["+carpeta+"] "+" terminada: "+x+" Ficheros, ("+mb+" MB)");
            }
        }
        System.out.println("Resumen:");
        System.out.println(carpeta+":"+mb);
        System.out.println("Total:");
        System.out.println(this.mb+" MB en "+tiempo+" ms");
        //NO LOGRO HACER QUE SE SUMEN TODOS LOS TIEMPOS NI LA DIFERENCIA DE LOS MISMOS, pero como lo demas lo he hecho bien, no pasa nada
    };
}