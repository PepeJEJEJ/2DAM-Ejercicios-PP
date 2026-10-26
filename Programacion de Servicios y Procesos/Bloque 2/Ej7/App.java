package Ej7;

public class App {
    public static void main(String[] args) {
        HiloTemperatura temperatura = new HiloTemperatura();
        HiloHumedad humedad=new HiloHumedad();
        HiloPresion presion=new HiloPresion();
        temperatura.start();
        humedad.start();
        presion.start();
    }
}
