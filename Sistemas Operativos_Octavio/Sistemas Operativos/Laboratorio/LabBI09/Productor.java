
public class Productor extends Thread {

             private Madriguera cubbyhole;
             private int number, unidades;
             private String producto;

             public Productor(Madriguera c, int number, int unidades, String producto) {
                 cubbyhole = c;
                 this.number = number;
                 this.setName("Productor " + producto + " #" + this.number);
                 this.unidades = unidades;
                 this.producto = producto;
             }

             public void run() {
                 String str1;
                 for (int i = 0; i < unidades; i++) {
                     str1 = producto + (number*1000+i) ;
                     cubbyhole.put(str1);
                     libHilos.hacerTiem(1,1000);
                 }
                 System.out.println(this.getName() + " ha terminado.");
             }
}