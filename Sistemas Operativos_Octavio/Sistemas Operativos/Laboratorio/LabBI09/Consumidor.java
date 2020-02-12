
public class Consumidor extends Thread {
             private Madriguera cubbyhole;
             private int number, unidades;
             String producto;

             public Consumidor(Madriguera c, int number, int unidades, String producto) {
                 cubbyhole = c;
                 this.number = number;
                 this.setName("Consumidor " + producto + " #" + this.number);
                 this.unidades = unidades;
                 this.producto = producto;
             }

             public void run() {
                 String val;
                 for (int i = 0; i < unidades; i++) {
                     val = cubbyhole.get();
                     libHilos.hacerTiem(1,1000);
                 }
                 System.out.println(this.getName() + " ha terminado.");
             }
}