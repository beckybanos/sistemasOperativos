
public class Consumidor extends Thread {
             private Madriguera cubbyhole;
             private int number;

             public Consumidor(Madriguera c, int number) {
                 cubbyhole = c;
                 this.number = number;
             }

             public void run() {
                 String val;
                 for (int i = 0; i < 10; i++) {
                     val = cubbyhole.get();
                     System.out.println("    Consumidor #" +
                         this.number + " got: " + val);
                     libHilos.hacerTiem(1,100);
                 }
             }
}