public class Dos extends Thread {
	// Producto
	private double [] arrd;
	
    public Dos (double [] vecd) {
		arrd = vecd;
	}
	
	public void run() {
		double mult = 1;
		for(int i = 0; i < 6; i++){
			mult = mult * arrd[i];
		}
		arrd[6] = mult;
	    System.out.println("\n Dos: ADIOS.");
	}
	

}