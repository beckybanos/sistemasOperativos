import java.io.*;

public class EdoCtaClientes {
    public static void main (String args[]) throws IOException {
		long timeInit = System.currentTimeMillis();
        BufferedReader filein = null;
        String cmdargs [] = new String [4];
        Process proc[] = new Process[10];
		String[] nomClientes = new String[20];
        int i,totProc;
        String linea, nomCliente, clvCliente;
		Runtime rt = Runtime.getRuntime();

		clvCliente = "";
		cmdargs[0] = "java";
		cmdargs[1] = "MovimientosCliente";

        i = 0;
        try {   
        	filein = new BufferedReader(new FileReader("clientes.txt"));
            linea = filein.readLine();
			String [] arr;
            while ( linea != null ) {
				arr = linea.split(" ");
				clvCliente = arr[0];
				nomCliente = arr[1];
				cmdargs[2] = clvCliente;
				cmdargs[3] = nomCliente;
				nomClientes[i] = nomCliente;
				proc[i] = rt.exec(cmdargs);
				i++;
                linea = filein.readLine();
			}
        } 
        catch(Exception e) {   
        	System.out.println("Algo fallo: " + e.getMessage());
            filein.close();
            System.exit(2);
        }
        filein.close();
        totProc = i;

        int y;
		int contHijos = 0;
		int[] exitCodes = new int[20];
        while( contHijos < totProc ) { 
            i = 0;
			contHijos = 0;
            while( i < totProc ) {   
            	System.out.println("Ya termino");
                try {   
					int val = proc[i].exitValue();
					exitCodes[i] = val;
					contHijos++;
                    System.out.println("--YA TERMINO--: " + i);
                    System.out.println("Cuantos hijos = " + contHijos);
                }
                catch(IllegalThreadStateException e) {   
                	System.out.println("Falta algun proceso por terminar.");
				i++;
            }
        }
		for(int j = 0; j < exitCodes.length; j++) {
			if( exitCodes[j] > 0){
				System.out.println("No se creo el reporte del usuario " + nomClientes[j]);
			}
		}
		System.out.println("Tiempo total de ejecucion del Padre " + (System.currentTimeMillis()-timeInit) + " milisegundos");
    }
}