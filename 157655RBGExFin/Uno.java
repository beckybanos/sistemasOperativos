public class Uno extends Thread {
	// Sumatoria.
	private double [] arrd;
	
    public Uno (double [] vecd) {
		arrd = vecd;
	}
	
	public void run() {
		double suma = 0;
		for(int i = 0; i < 6; i++)
           {  suma += arrd[i];
           }
	    System.out.println("\n Uno: ADIOS.");
	}
	

}
