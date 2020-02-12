public class Mainprin {
	// Principal.
	
	public static void main(String args[]) {
		// Definiendo y creando objeto arreglo con valores iniciales
		double [] arrd = {-7.0, -8.0};

		// Lanzamiento del Thread Thrprin
		Thrprin pt = new Thrprin (arrd);
		pt.start();
		
		while(pt.isAlive());
		
		System.out.println("\nLos dos valores recibidos son:");
		for(int i = 0; i < 2; i++) {
			System.out.println("    " + arrd[i]);
		}
		System.out.println("\n Mainprin: ADIOS.\n");
		
	}
}