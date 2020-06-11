/* Obtiene el nombre y direccion IP del host(nodo) local. */

import java.net.*;

public class NomCom
{
   public static void main(String [] args)
   {  InetAddress CompLocal;
      String NomCom;
      try
      {  CompLocal = InetAddress.getLocalHost();
         NomCom = CompLocal.getHostName();
         System.out.println( "\n  Nombre de esta computadora: " + 
                    NomCom + "\n  Direccion del Host: " + CompLocal + "\n" );
      }
      catch (UnknownHostException ex)
      {  System.out.println("Error: " + ex.getMessage() + "\n");
      }
   }
}
