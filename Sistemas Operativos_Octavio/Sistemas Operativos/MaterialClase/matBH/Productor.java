

public class Productor extends Thread {

             private Madriguera cubbyhole;
             private int number;

             public Productor(Madriguera c, int number) {
                 cubbyhole = c;
                 this.number = number;
             }

             public void run() {
                 String str1;
                 for (int i = 0; i < 10; i++) {
                     str1="silla-" + (number*1000+i) ;
                     cubbyhole.put(str1);
                     System.out.println("Productor #" +
                         this.number + " put: " + str1);
                     libHilos.hacerTiem(1,100);
                 }
             }
}