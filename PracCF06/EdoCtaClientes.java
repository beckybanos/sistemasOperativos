import java.io.*;

public class EdoCtaClientes
{
    public static void main (String args[])
    	throws IOException
    {
	long startTime = System.nanoTime();
        BufferedReader filein = null; //para entrada
        String cmdargs [] = new String [4];
        Process proc[] = new Process[20];
	String[] clientes = new String[20];
        int i,totProc;
        String linea, nomCliente, clvCliente; String[] datos = new String[2];

	Runtime rt = Runtime.getRuntime();
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
		cmdargs[0] = "java";
		cmdargs[1] = "MovimientosCliente";
		cmdargs[2] = clvCliente;
		cmdargs[3] = nomCliente;
		proc[i] = rt.exec(cmdargs);
		clientes[i] = nomCliente + " con clave " + clvCliente;
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

        // A esperar por todos los procesos hijos
        int y;
	boolean todosTerminaron = false;
	int[] stts = new int[totProc];
        while( !todosTerminaron )
        {   
	    todosTerminaron = true;
            i = 0;
            while( i < totProc )
            {   System.out.println("Ya termino");
                try
                {   y = proc[i].exitValue();
                    System.out.println("--YA TERMINO--: " + i);
                    System.out.println("y= " + y);
		    stts[i] = y;
                }
                catch(IllegalThreadStateException e)
                {   System.out.println("Falta algun proceso por terminar: "+i);
		    System.out.println("A preguntarle al siguiente proceso...");todosTerminaron=false;
                }
		i++;
            }
        }
	for( i=0; i<totProc; i++ ) 
	    if( stts[i] == 0 ) 
		System.out.println("El estado de cuenta del cliente " + clientes[i] + " no se pudo generar porque no tiene movimientos.");
	System.out.println("Tiempo: " + (System.nanoTime() - startTime)/1000000 + "ms");

    }
}