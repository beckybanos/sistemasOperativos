/* Lista de los contenidos de las propiedades o
   variables de la maquina virtual de java.
*/

import java.util.Properties;

public class convarso
{
   public static void main(String args[])
   {
      Properties xx = System.getProperties();
      xx.list(System.out);
   }
}
