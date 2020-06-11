
public class DatosUsu
{
   public static void main(String args[])
   {
      System.out.println("NOMBRE DE USUARIO: " +
                         System.getProperty("user.name"));
      System.out.println("HOME DIRECTORY: " +
                         System.getProperty("user.home"));
      System.out.println("DIRECTORIO DE TRABAJO: " +
                         System.getProperty("user.dir"));
   }
}
