import java.io.*;

public class MovimientosCliente
{

   public static void main (String[] args)
   {
      long startTime = System.nanoTime();
      BufferedReader filein; //para entrada
      PrintWriter fileout;  // para salida
      String linea, nomCliente, clvCliente;
      int clave1, clave2; String[] datos = new String[4];
      int lineas = 0;
      int stts = -4;
      try
      {   clvCliente = args[0];
      	  nomCliente = args[1];
	  String s = "";
		  clave1 = Integer.parseInt(clvCliente);

          filein = new BufferedReader( new FileReader("movimientos.txt") );

	  // Transacciones
          linea = filein.readLine();
          while ( linea != null )
          {  if( linea.length() != 0 )
	     {  
		datos = linea.split(" ");
		clave2 = Integer.parseInt(datos[0]);
		if( clave1 == clave2 ) s+=""+linea+"\n";
             }

             linea = filein.readLine();
          }
	  if(!s.equals(""))
	  {
	    s += "Tiempo: " + (System.nanoTime() - startTime)/1000000 + "ms";
	    fileout = new PrintWriter( new FileWriter("EdoCta"+nomCliente+".txt") );
	    fileout.append(s);
            fileout.close();
	  }else stts = 0;
          filein.close();
      }
      catch (Exception ex)
      {   System.out.println(ex.toString());
          System.out.println("\nAlgo fallo con algun archivo.\n");
      }
      
      System.exit(stts);
   }
}