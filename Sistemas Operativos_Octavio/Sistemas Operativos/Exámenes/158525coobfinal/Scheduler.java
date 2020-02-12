import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {

    private Queue<ProcesoG> ready;
    private Queue<ProcesoG> waiting;
    private MemoriaCentral memCen;
    private Swap swap;
    private int succ = 0, count = 0;
    private boolean cpu = false;
    private long quantum;

    public Scheduler() {
        ready = new LinkedList<>();
        waiting = new LinkedList<>();
        memCen = new MemoriaCentral(30);
        swap = new Swap(50);
        quantum = (long) (Math.random() * 1000);
    }

    public synchronized MemoriaCentral getMemCen() {
        return memCen;
    }

    public synchronized Swap getSwap() {
        return swap;
    }

    public void incCount() {
        count++;
    }

    public void incSucc() {
        succ++;
    }

    public int getSucc() {
        return succ;
    }

    public int getCount() {
        return count;
    }

    public long getQuantum(){
    	return quantum;
    }

    public synchronized boolean getCpu() {
        return cpu;
    }

    public synchronized void setCpu(boolean flag) {
        cpu = flag;
    }

    public synchronized ProcesoG getReady() {
        ProcesoG pro;
        while (ready.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        pro = ready.remove();
        notifyAll();
        return pro;
    }

    public synchronized ProcesoG getWaiting() {
        ProcesoG pro;
        while (waiting.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        pro = waiting.remove();
        notifyAll();
        return pro;
    }

    public synchronized void putReady(ProcesoG proc) {
        while (ready.size() == 5) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        ready.add(proc);
        notifyAll();
    }

    public synchronized void putWaiting(ProcesoG proc) {
        while (waiting.size() == 5) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        waiting.add(proc);
        notifyAll();
    }

    public synchronized void escribeBitacoraEstado(String texto) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("bitacora.txt", true));
            writer.write(texto);
            writer.newLine();
            writer.write("-------------");
            writer.newLine();
            writer.close();
        } catch (Exception ex) {

        }
    }

    public synchronized void escribeBitacoraFin(String tex1, String tex2, String tex3, String tex4, String tex5) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("bitacora.txt", true));
            writer.write("#############");
            writer.newLine();
            writer.write(tex1);
            writer.newLine();
            writer.write(tex2);
            writer.newLine();
            writer.write(tex3);
            writer.newLine();
            writer.write(tex4);
            writer.newLine();
            writer.write(tex5);
            writer.newLine();
            writer.write("#############");
            writer.newLine();
            writer.close();
        } catch (Exception ex) {

        }
    }

    public static void main(String args[]) {
        Scheduler boy = new Scheduler();
        BufferedReader filein;
        File bitacora = new File("bitacora.txt");
        if (bitacora.exists()) {
            bitacora.delete();
        }
        try {
            filein = new BufferedReader(new FileReader("cmdbatch.txt"));
            String linea = filein.readLine();
            System.out.println("--Power on--");
            while (linea != null) {
                String arr[] = linea.split(" ");
                TNew hiloNew = new TNew(boy, arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
                hiloNew.start();
                linea = filein.readLine();
            }
            filein.close();
            while (boy.getCount() < boy.getSucc()) {
                System.out.print("");
            }
            System.out.println("--Shutdown--");
        } catch (Exception e) {
            System.out.println("ERROR EN MAIN");
        }
    }
}

class TNew extends Thread {

    Scheduler calendarizador;
    String nombre;
    int bursts, paginas;

    public TNew(Scheduler sche, String nombre, int bursts, int paginas) {
        calendarizador = sche;
        this.nombre = nombre;
        this.bursts = bursts;
        this.paginas = paginas;
    }

    @Override
    public void run() {
        calendarizador.incSucc();
        ProcesoG proceso = new ProcesoG(nombre, bursts, paginas);
        if (calendarizador.getMemCen().checkPages(paginas)) {
            proceso.setPageTable(calendarizador.getMemCen().setPages(paginas, nombre));
            calendarizador.putReady(proceso);
            System.out.println("NEW --> READY: " + proceso.getNombre());
            calendarizador.escribeBitacoraEstado("NEW --> READY: " + proceso.getNombre());
            String[] pageTable = proceso.getPageTable();
            for (String s : pageTable) {
                System.out.println("Proceso " + proceso.getNombre() + ": " + s);
            }
        } else {
            System.out.println("NEW --> READY-SWAP: " + proceso.getNombre());
            calendarizador.escribeBitacoraEstado("NEW --> READY-SWAP: " + proceso.getNombre());
            calendarizador.getSwap().rollIn(proceso);
        }
        TReady listo = new TReady(calendarizador);
        listo.start();
    }
}

class TReady extends Thread {
    
    Scheduler calendarizador;
    
    public TReady(Scheduler sche){
        calendarizador = sche;
    }
    
    @Override
    public void run(){
    	long t1 = System.currentTimeMillis();
        ProcesoG procesoActual = calendarizador.getSwap().checkRollOut();
        if (procesoActual != null && calendarizador.getMemCen().checkPages(procesoActual.getPaginas())) {
            procesoActual = calendarizador.getSwap().rollOut();
            procesoActual.setPageTable(calendarizador.getMemCen().setPages(procesoActual.getPaginas(), procesoActual.getNombre()));
            System.out.println("READY-SWAP --> RUNNING: " + procesoActual.getNombre() + " BURSTS: " + procesoActual.getBursts());
            calendarizador.escribeBitacoraEstado("READY-SWAP --> RUNNING: " + procesoActual.getNombre() + " BURSTS: " + procesoActual.getBursts());
            String[] pageTable = procesoActual.getPageTable();
            for (String s : pageTable) {
                System.out.println("Proceso " + procesoActual.getNombre() + ": " + s);
            }
        } else {
            procesoActual = calendarizador.getReady();
            System.out.println("READY --> RUNNING: " + procesoActual.getNombre() + " BURSTS: " + procesoActual.getBursts());
            calendarizador.escribeBitacoraEstado("READY --> RUNNING: " + procesoActual.getNombre() + " BURSTS: " + procesoActual.getBursts());
        }
        long t2 = System.currentTimeMillis();
        procesoActual.setTiempoReady(t2 - t1);
        TRunning racer = new TRunning(calendarizador, procesoActual);
        racer.start();
    }
    
}

class TRunning extends Thread {

    Scheduler calendarizador;
    ProcesoG procesoActual;
    long rebanada;

    public TRunning(Scheduler sche, ProcesoG act) {
        calendarizador = sche;
        procesoActual = act;
        rebanada = sche.getQuantum();
    }

    @Override
    public void run() {
        while (calendarizador.getCpu() == true);
        calendarizador.setCpu(true);
        long tiempo = (long) (Math.random() * 1000);
        if (procesoActual.getBursts() > 0) {
        	int i;
	        if (tiempo >= rebanada){
	        	try {
	            	Thread.sleep(rebanada);
	        	}
	        	catch (InterruptedException e) {

	        	}
	        	procesoActual.setTiempoServicio(rebanada);
	            calendarizador.putReady(procesoActual);
	            System.out.println("RUNNING --> READY: " + procesoActual.getNombre());
	            calendarizador.escribeBitacoraEstado("RUNNING --> READY: " + procesoActual.getNombre());
	            TReady listo = new TReady(calendarizador);
	            listo.start();
	        }
	        else {
	        	try {
	        	    Thread.sleep(tiempo);
	        	}
	        	catch (InterruptedException e) {

	        	}
	        	procesoActual.decBursts();
	        	procesoActual.setTiempoServicio(tiempo);
	        	calendarizador.putWaiting(procesoActual);
	        	System.out.println("RUNNING --> WAITING: " + procesoActual.getNombre());
	        	calendarizador.escribeBitacoraEstado("RUNNING --> WAITING: " + procesoActual.getNombre());
	        	TWaiting mesero = new TWaiting(calendarizador);
	        	mesero.start();
	        }
	        calendarizador.setCpu(false);
    	}
    	else {
            calendarizador.setCpu(false);
            Terminator t800 = new Terminator(calendarizador, procesoActual);
            t800.start();
        } 
    }
}

class TWaiting extends Thread {

    Scheduler calendarizador;

    public TWaiting(Scheduler sche) {
        calendarizador = sche;
    }

    @Override
    public void run() {
        ProcesoG procesoActual = calendarizador.getWaiting();
        long tiempo = (long) (Math.random() * 1000);
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {

        }
        procesoActual.setTiempoEspera(tiempo);
        calendarizador.putReady(procesoActual);
        System.out.println("WAITING --> READY: " + procesoActual.getNombre());
        calendarizador.escribeBitacoraEstado("WAITING --> READY: " + procesoActual.getNombre());
        TReady listo = new TReady(calendarizador);
        listo.start();
    }
}

class Terminator extends Thread {

    ProcesoG kyle;
    Scheduler calendarizador;

    public Terminator(Scheduler sche, ProcesoG reese) {
        calendarizador = sche;
        kyle = reese;
    }

    @Override
    public void run() {
        calendarizador.getMemCen().freePages(kyle.getNombre());
        System.out.println("RUNNING --> TERMINATED: " + kyle.getNombre());
        calendarizador.escribeBitacoraEstado("RUNNING --> TERMINATED: " + kyle.getNombre());
        String s1, s2, s3, s4, s5;
        s1 = "Nombre del proceso: " + kyle.getNombre();
        s2 = "Tiempo total de servicio: " + kyle.getTiempoServicio() + " milisegundos";
        s3 = "Tiempo total de espera: " + kyle.getTiempoEspera() + " milisegundos";
        s4 = "Tiempo total de listo: " + kyle.getTiempoReady() + " milisegundos";
        s5 = "Tiempo TurnAround: " + kyle.getTurnAround() + " milisegundos";
        calendarizador.escribeBitacoraFin(s1, s2, s3, s4, s5);
        calendarizador.incCount();
    }
}
