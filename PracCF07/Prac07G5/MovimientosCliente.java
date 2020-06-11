import java.io.*;

public class MovimientosCliente extends Thread
{
   private String nomCliente;
   private String clvCliente;
   private int stts;

   public MovimientosCliente(String nombre, String clave)
   {
      nomCliente = nombre;
      clvCliente = clave;
      stts = 10;
   }
   
   public int getStts()
   {
      return stts;
   }

   public void run ()
   {
      long startTime = System.nanoTime();
      BufferedReader filein; //para entrada
      PrintWriter fileout;  // para salida
      String linea;
      int clave1, clave2; String[] datos = new String[4];
      int lineas = 0;
      try
      {
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
          filein.close();
	  if(s.equals("")) stts=-1;
	  else
	  {
	    s += "Tiempo: " + (System.nanoTime() - startTime)/1000000 + "ms";
	    fileout = new PrintWriter( new FileWriter("EdoCta"+nomCliente+".txt") );
	    fileout.append(s);
            fileout.close();
	  }
      }
      catch (Exception ex)
      {   System.out.println(ex.toString());
          System.out.println("\nAlgo fallo con algun archivo.\n");
      }
   }
}