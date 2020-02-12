import java.io.*;

public class EdoCtaClientesC
{
    public static void main (String args[])
        throws IOException
    {
        long tiempo = System.currentTimeMillis();
        BufferedReader filein = null;
        MovimientosClienteC proc[] = new MovimientosClienteC[10];
        String[] clientes = new String[20];
        int i, totProc, totHijos;
        String linea, nomCliente, clvCliente;
        boolean[] succs = new boolean[10];

        i = 0;

        try {   
        	filein = new BufferedReader( new FileReader("clientes.txt") );
            linea = filein.readLine();
            String [] datos;
            while ( linea != null ) {
                datos = linea.split(" ");
                clvCliente = datos[0];
                nomCliente = datos[1];
                clientes[i] = nomCliente;
                proc[i] = new MovimientosClienteC(nomCliente, clvCliente);
                proc[i].start();
                i++;
                linea = filein.readLine();
            }
        } catch(Exception e)
        {   System.out.println("Algo fallo: " + e.getMessage());
            filein.close();
            System.exit(2);
        }
        filein.close();
        totProc = i;

        for (i = 0; i < totProc; i++) {
        	while (proc[i].isAlive()) {
        		//wait
        	}
        	System.out.println("Ya termino " + i);
        	succs[i] = proc[i].getSucc();
        }
        for(int j = 0; j < succs.length; j++){
            if(!succs[j])
                System.out.println("No se pudo crear el estado de cuenta de "+ clientes[j]);
        }
        System.out.println("Tiempo de ejecucion del padre: "+ (System.currentTimeMillis()-tiempo) +" milisegundos.");

    }
}

class MovimientosClienteC extends Thread {
	String nomCliente, claveCliente;
	boolean succ;

	public MovimientosClienteC(String nomCliente, String claveCliente) {
		super();
		this.nomCliente = nomCliente;
		this.claveCliente = claveCliente;
		succ = false;
	}

	public boolean getSucc() {
		return succ;
	}

	@Override
	public void run() {
		long tiempo = System.currentTimeMillis();
		int numTrans = 0, exitStatus = 0;
		BufferedReader filein;
		BufferedWriter fileout = null;
		String linea;
		double monto = 0, val;

		try {
			   filein = new BufferedReader( new FileReader("movimientos.txt") );
			   
			   linea = filein.readLine();
			   while (linea != null) {  
			   if(linea.length() != 0) {  
			     String[] datos = linea.split(" ");
			     if(datos[0].equals(claveCliente)){
			     	if(fileout == null){
			     		fileout = new BufferedWriter(new FileWriter("EdoCuenta"+nomCliente+".txt"));
			     	}
			       val = Double.parseDouble(datos[2]);
			       fileout.write("Transacción    clave: " + datos[1] + " Monto: " + val);
			       fileout.newLine();
			       monto += val;
			       numTrans++;
			     }
			    }
			    linea = filein.readLine();
			   }
			   if(numTrans > 0){
			   	 succ = true;
			     fileout.newLine();
			     fileout.write("Cliente: " + nomCliente + " Clave: " + claveCliente);
			     fileout.newLine();
			     fileout.write("Monto total: " + monto);
			     fileout.newLine();
			     fileout.write("Tiempo de ejecución: " + (System.currentTimeMillis() - tiempo)+" milisegundos.");
			     fileout.newLine();
			     fileout.write("Número de transacciones: " + numTrans);
			     fileout.newLine();
			     fileout.close();
			   }
			   filein.close();
			 }
			 catch (Exception ex) {   
			 	System.out.println(ex.toString());
			   	System.out.println("\nAlgo fallo con algun archivo.\n");
			 }
	}

}