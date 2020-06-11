
public class DatosSis
{
   public static void main(String args[])
   {
      System.out.println("\nDatos sobre este sistema operativo\n");
      System.out.println("Nombre del Sistema Operativo: " +
                         System.getProperty("os.name"));
      System.out.println("Arquitectura del Sistema de Computo: " +
                         System.getProperty("os.arch"));
      System.out.println("Version del Sistema Operativo: " +
                             System.getProperty("os.version"));
   }
}
