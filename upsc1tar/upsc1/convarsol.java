/* Lista los nombres de las propiedades o variables
   de la maquina virtual de java.
*/

import java.util.*;

public class convarsol
{
   public static void main(String args[])
   {
      Properties xx = System.getProperties();
      Enumeration yy = xx.propertyNames();
      int c=0;
      while( yy.hasMoreElements() )
      {
         System.out.println( yy.nextElement() );
         c++;
      }
      System.out.println( "\nTotalizing: " + c + " key properties.");
   }
}
