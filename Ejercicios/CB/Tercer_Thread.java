public class Tercer_Thread {

    private final static int NUMRUNNERS = 4;

    public static void main(String[] args) {
    
        System.out.println("MIN_PRIORITY="+Thread.MIN_PRIORITY);
        System.out.println("NORM_PRIORITY="+Thread.NORM_PRIORITY);
        System.out.println("MAX_PRIORITY="+Thread.MAX_PRIORITY);

        Runner[] runners = new Runner[NUMRUNNERS];

        for (int i = 0; i < NUMRUNNERS; i++) {
            runners[i] = new Runner(i);
            runners[i].setPriority(i+1);
        }
        for (int i = 0; i < NUMRUNNERS; i++)
            runners[i].start();
        System.out.println("main: Adios.");
    }
}
