
public class Runner extends Thread {

    private int tick = 1;
    private int num;

    public Runner(int num) {
        this.num = num;
    }

    public void run() {
        int pri = this.getPriority();
        while (tick < 400000) {
            tick++;
            if ((tick % 50000) == 0) {
                System.out.println("Thread #" + num +
                    ": tick = " + tick +
                    " : Prioridad= " + pri);
                yield();
            }
        }
    }
}