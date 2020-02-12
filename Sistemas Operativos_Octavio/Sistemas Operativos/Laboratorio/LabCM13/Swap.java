import java.util.LinkedList;
import java.util.Queue;

public class Swap {

    private Queue<ProcesoG> procesos;
    private int maxSize;

    public Swap(int maxSize) {
        procesos = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void rollIn(ProcesoG proc) {
        if (procesos.size() < maxSize) {
            procesos.add(proc);
        }
    }

    public synchronized ProcesoG checkRollOut() {
        return procesos.peek();
    }

    public synchronized ProcesoG rollOut() {
        if (procesos.size() > 0) {
            return procesos.remove();
        }
        return null;
    }

    public synchronized int getSize() {
        return procesos.size();
    }
}
