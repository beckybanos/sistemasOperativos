public class Uno extends Thread {
	// Suma
	private double [] arrd;
	
    public Uno (double [] vecd) {
		arrd = vecd;
	}
	
	public void run() {
		double suma = 0;
		for(int i = 0; i < 6 ; i++){
			suma = suma + arrd[i];
		}
		arrd[6] = suma;
	    System.out.println("\n Uno: ADIOS.");
	}
	

}