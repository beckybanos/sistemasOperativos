import java.io.*;

public class CopiaSumAr
{   
   static BufferedReader filein;
   static PrintWriter fileout;

   public static void main (String[] args)
   {
      String linea, archivo;
      try
      {   System.out.print("Nombre del archivo de entrada: ");
          archivo = LeeTe.tString();
          filein = new BufferedReader( new FileReader(archivo) );

          System.out.print("Nombre del archivo de salida:  ");
          archivo = LeeTe.tString();
          fileout = new PrintWriter( new FileWriter(archivo) );

          while ( ( linea = filein.readLine() ) != null )
          {   
               int s = Integer.parseInt(linea)+ 100;
               fileout.println( s );
          }
          filein.close();
          fileout.close();
      }
      catch (IOException ex) 
      {
          System.out.println("\nEXCEPCION: IOException.");
          System.out.println("getMessage: " + ex.getMessage() );
          ex.printStackTrace();
          System.out.println("\nHasta la vista.\n");
      }
   }
}