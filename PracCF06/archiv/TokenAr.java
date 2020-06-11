import java.io.*;

public class TokenAr
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
             if( linea.length() != 0 ) 
             {
                String [] st = linea.split("[ \t\f\n\r]");
                int lenst = st.length;
                System.out.println("Tokens/esta linea: " + lenst );
                for(int i=0; i < lenst; i++)
                    fileout.println( st[i] );
             }
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