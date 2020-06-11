public class Dos extends Thread {
	// Multiplicacion
	private double [] arrd;
	
    public Dos (double [] vecd) {
		arrd = vecd;
	}
	
	public void run() {
		double mult = 0;
		for(int i = 0; i < 6; i++)
           {  mult = mult*arrd[i];
           }
	    System.out.println("\n Dos: ADIOS.");
	}
	

}
