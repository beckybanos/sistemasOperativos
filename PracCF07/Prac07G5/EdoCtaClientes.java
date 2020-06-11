import java.io.*;

public class EdoCtaClientes
{
    public static void main (String args[])
    	throws IOException
    {
	long startTime = System.nanoTime();
        BufferedReader filein = null; //para entrada
        String cmdargs [] = new String [4];
        MovimientosCliente threads[] = new MovimientosCliente[20];
	String[] clientes = new String[20];
        int i,totProc;
        String linea, nomCliente, clvCliente; String[] datos = new String[2];
	
	clvCliente = null;
	
        // Arranque de todos los procesos, uno por uno
        i = 0;
        try
        {   filein = new BufferedReader( new FileReader("clientes.txt") );
            linea = filein.readLine();
            while ( linea != null )
            {   
	        datos = linea.split(" ");
	        clvCliente = datos[0];
	        nomCliente = datos[1];
		threads[i] = new MovimientosCliente(nomCliente, clvCliente);
		threads[i].start();
		clientes[i] = nomCliente + " con clave " + clvCliente;
		i++;
                linea = filein.readLine();
	    }
        } catch(Exception e)
        {
            System.out.println("Algo fallo: " + e.getMessage());
            filein.close();
            System.exit(2);
        }
        filein.close();
        totProc = i;

        // A esperar por todos los procesos hijos
        int y;
	boolean notdone = true;
	int[] stts = new int[totProc];
        while( notdone )
        {
	    notdone=false;
            for(i=0; i<totProc; i++)
            {
                notdone |= threads[i].isAlive();
		i++;
            }
        }
	try{Thread.sleep((int)Math.random()*1000);}catch(InterruptedException e){}
	for( i=0; i<totProc; i++ ) {
	    if( threads[i].getStts() == -1 ) 
		System.out.println("El estado de cuenta del cliente " + 
			clientes[i] + " no se pudo generar porque no tiene movimientos.");
	}
	System.out.println("Tiempo: " + (System.nanoTime() - startTime)/1000000 + "ms");

    }
}