import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
	Queue<ProcesoG> ready;
	Queue<ProcesoG> waiting;
	int succ = 0, count = 0;
	boolean cpu = false;

	public Scheduler() {
		ready = new LinkedList<>();
		waiting = new LinkedList<>();
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
            } 
            catch (InterruptedException e) {

            }
        }
        ready.add(proc);
        notifyAll();
    }

    public synchronized void putWaiting(ProcesoG proc) {
        while (waiting.size() == 5) {
            try {
                wait();
            } 
            catch (InterruptedException e) {

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
		}
		catch (Exception ex) {

		}
    }

    public synchronized void escribeBitacoraFin(String tex1, String tex2, String tex3) {
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
			writer.write("#############");
			writer.newLine();
			writer.close();
		}
		catch (Exception ex) {

		}
    }

	public static void main(String args[]) {
		Scheduler boy = new Scheduler();
		BufferedReader filein;
		File bitacora = new File("bitacora.txt");
		if (bitacora.exists())
			bitacora.delete();		
		try {
			filein = new BufferedReader(new FileReader("cmdbatch.txt"));
			String linea = filein.readLine();
			System.out.println("--Power on--");
			while (linea != null) {
				linea = filein.readLine();
				String arr[] = linea.split(" ");
				TNew hiloNew = new TNew(boy, arr[1], Integer.parseInt(arr[2]));
				hiloNew.start();
			}
		} catch(Exception e) {

		}
		while (boy.getCount() < boy.getSucc()){
			System.out.println(boy.getCount()+" vs. "+boy.getSucc());
		}
		System.out.println("--Shutdown--");
	}
}

class TNew extends Thread {

	Scheduler calendarizador;
	String nombre;
	int bursts;

	public TNew (Scheduler sche, String nombre, int bursts){
		calendarizador = sche;
		this.nombre = nombre;
		this.bursts = bursts;
	}

	@Override
	public void run() {
		calendarizador.incSucc();
		ProcesoG proceso = new ProcesoG(nombre, bursts);
		calendarizador.putReady(proceso);
		System.out.println("NEW --> READY: " + proceso.getNombre());
		calendarizador.escribeBitacoraEstado("NEW --> READY: " + proceso.getNombre());
		TRunning racer = new TRunning(calendarizador);
		racer.start();
	}
}

class TRunning extends Thread {

	Scheduler calendarizador;

	public TRunning (Scheduler sche){
		calendarizador = sche;
	}

	@Override
	public void run() {
		while (calendarizador.getCpu() == true);
		calendarizador.setCpu(true);
		ProcesoG procesoActual = calendarizador.getReady();
		System.out.println("READY --> RUNNING: " + procesoActual.getNombre() + " BURSTS: " + procesoActual.getBursts());
		calendarizador.escribeBitacoraEstado("READY --> RUNNING: " + procesoActual.getNombre() + " BURSTS: " + procesoActual.getBursts());
		if (procesoActual.getBursts() > 0){
			long tiempo = (long) (Math.random()*1000);
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
			calendarizador.setCpu(false);
	        TWaiting mesero = new TWaiting(calendarizador);
	        mesero.start();
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

	public TWaiting (Scheduler sche){
		calendarizador = sche;
	}

	@Override
	public void run() {
		ProcesoG procesoActual = calendarizador.getWaiting();
		long tiempo = (long) (Math.random()*1000);
		try {
		    Thread.sleep(tiempo);
		}
		catch (InterruptedException e) {

		}
		procesoActual.setTiempoEspera(tiempo);
		calendarizador.putReady(procesoActual);
		System.out.println("WAITING --> READY: " + procesoActual.getNombre());
		calendarizador.escribeBitacoraEstado("WAITING --> READY: " + procesoActual.getNombre());
		TRunning racer = new TRunning(calendarizador);
		racer.start();
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
		System.out.println("RUNNING --> TERMINATED: " + kyle.getNombre());
		calendarizador.escribeBitacoraEstado("RUNNING --> TERMINATED: " + kyle.getNombre());
		String s1, s2, s3;
		s1 = "Nombre del proceso: " + kyle.getNombre();
		s2 = "Tiempo total de servicio: " + kyle.getTiempoServicio() + " milisegundos";
		s3 = "Tiempo total de espera: " + kyle.getTiempoEspera() + " milisegundos";
		calendarizador.escribeBitacoraFin(s1, s2, s3);
		calendarizador.incCount();
	}
}