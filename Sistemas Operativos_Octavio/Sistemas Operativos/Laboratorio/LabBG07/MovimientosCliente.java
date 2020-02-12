import java.io.*;

public class MovimientosCliente {

	public static void main (String[] args) {
		long startTime  = System.currentTimeMillis();
	  	BufferedReader filein;

		String linea, nomCliente, clvCliente,writeString ="";
		int clave1, clave2, numTrans = 0;
		nomCliente = args[1];
		clvCliente = args[0];
		System.out.println("HIJO: " + nomCliente);
		int exitStatus = -4;
		
		try {  
			clave1 = Integer.parseInt(clvCliente);

			filein = new BufferedReader( new FileReader("movimientos.txt") );

			BufferedWriter writer = null;
			

			linea = filein.readLine();
			double monto = 0;
			double valor = 0;
			while ( linea != null ) {  
				if( linea.length() != 0 ) {  
					String[] arr = linea.split(" ");
					if(arr[0].equals(clvCliente)){
						if(writer == null){
							writer = new BufferedWriter(new FileWriter("EdoCuenta"+nomCliente+".txt"));
						}
						valor = Double.parseDouble(arr[2]);
						writer.write("Clave transaccion: " +arr[1]+ " Monto: " + valor + "\n");
						writer.newLine();
						monto += valor;
						numTrans++;
					}
				}
				 
				linea = filein.readLine();
			}

			if(numTrans > 0) {
				writer.write("Clave del cliente: " + clvCliente + "\n");
				writer.newLine();
				writer.write("Nombre del cliente: " + nomCliente + "\n");
				writer.newLine();
				writer.write("Monto total en transacciones: " + monto + "\n");
				writer.newLine();
				writer.write("Tiempo ejecucion: " + (System.currentTimeMillis() - startTime)+" milisegundos \n");
				writer.newLine();
				writer.write("Número de transacciones: " + numTrans + "\n");
				writer.newLine();
				writer.close();
			}
			else{
				exitStatus=4;
			}
			filein.close();

		}
		catch (Exception ex) {   
			System.out.println(ex.toString());
			System.out.println("\nAlgo fallo con algun archivo.\n");
		}
		System.exit(exitStatus);
	}
}