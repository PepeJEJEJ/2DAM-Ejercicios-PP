package Repaso.Ej7;

public class App {
    public static void main(String[] args) {
        HiloTemperatura hilo3=new HiloTemperatura();
        HiloHumedad hilo1=new HiloHumedad();
        HiloPresion hilo2=new HiloPresion();
        hilo3.start();
        hilo1.start();
        hilo2.start();
    }
}
