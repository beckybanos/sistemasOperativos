public class Thrprin extends Thread{
	// Principal Thread
	private double [] arrdd;
	
	public Thrprin(double [] vecd) {
		arrdd = vecd;
	}
	
	public void run() {
		// Un arreglo para pasarle datods a cada thread hijo
		double [] arrd1 = new double [7];
		double [] arrd2 = new double [7];
		double suma = 0;
		double mult = 0;
	
    	// Valores iniciales para cada arreglo de enteros
		for(int i = 0; i < 6; i++) {
			arrd1[i] = Math.random() * 10;
			arrd2[i] = Math.random() * 10;
		}
		arrd1[6] = -1; arrd2[6] = -1;
		
		// Creación y lanzamiento del primer thread hijo
		Uno one = new Uno (arrd1);
		one.start();
		// Espera por el primer thread hijo
		while(one.isAlive());
		suma = arrd1[6];

		Dos dos = new Dos (arrd2);
		dos.start();
		// Espera por el segundo thread hijo
		while(dos.isAlive());
		mult = arrd2[6];
				
		// Valores de prueba de regreso, faltan los reales.
		arrdd[0] = suma;    arrdd[1] = mult;
		System.out.println("\n Thrprin: ADIOS.\n");
		
	}
}