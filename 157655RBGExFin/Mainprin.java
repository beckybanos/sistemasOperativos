public class Mainprin {
	// Principal.
	
	public static void main(String args[]) {
		// Definiendo y creando objeto arreglo con valores iniciales
		double [] arrd = {-7.0, -8.0};

		// Lanzamiento del Thread Thrprin
		Thrprin pt = new Thrprin (arrd);
		pt.start();
		
		// Esperando a que termine Thrprin
		libHilos.hacerTiem(1,3000);
		
		System.out.println("\nLos dos valores recibidos son:");
		for(int i = 0; i < 2; i++) {
//			System.out.println("    " + arrd[i]);
			System.out.println(" "+pt.getName());
		}
		System.out.println("\n Mainprin: ADIOS.\n");
		
	}
}
