public class Thrprin extends Thread{
	// Principal Thread
	private double [] arrdd;
	
	public Thrprin(double [] vecd) {
		arrdd = vecd;
	}
	
	public void run() {
		// Un arreglo para pasarle datods a cada thread hijo
		double [] arrd1 = new double [6];
		double [] arrd2 = new double [6];
	
    	// Valores iniciales para cada arreglo de enteros
		for(int i = 0; i < 6; i++) {
			arrd1[i] = Math.random() * 10;
			arrd2[i] = Math.random() * 10;
		}
		
		// Creación y lanzamiento del primer thread hijo
		Uno one = new Uno (arrd1);
		one.start();
		
		// Espera por el primer thread hijo
		libHilos.hacerTiem(1,1000);
		
		// Creación y lanzamiento del segundo thread hijo
		Dos two = new Dos (arrd2);
		two.start();

		// Espera por el segundo thread hijo
		libHilos.hacerTiem(1,1000);

		
		// Valores de prueba de regreso, faltan los reales.
		arrdd[0] = -11;    arrdd[1] = -12;
		//arrdd[0] =one.getDouble();	//arrdd[1]=two.getName();	
		System.out.println("\n Thrprin: ADIOS.\n");
		
	}
}
