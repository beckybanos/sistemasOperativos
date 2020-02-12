// Crea tres nuevos threads que se ejecutan concurrentemente
public class principal
{
   public static void main(String[] args)
   {
      Refresco uno = new Refresco("Pepsi Cola");
      Refresco dos = new Refresco("Coca Cola");
      Refresco tres = new Refresco("Orange Crush");

      uno.start();
      dos.start();
      tres.start();

      while(uno.isAlive() || dos.isAlive() || tres.isAlive()){

      }

      /*
      try{
        uno.join();
        dos.join();
        tres.join();
  	  }
      catch(Exception e){

      }
      */

      System.out.println("\n+++main++++>>> Adios. ");
      System.out.println("El nombre del thread: "+Thread.currentThread().getName()+ " con prioridad: " + Thread.currentThread().getPriority());

    } // Me. main
} // Cla. principal


// Thread que imprime el nombre de un refresco 7 veces,
class Refresco extends Thread
{
   private String nombre;

   Refresco(String cade)
   {
      nombre = cade;
   } //Me. constructor

   public void run()
   {
      System.out.println("--> " + this.getName() + " con prioridad: " + this.getPriority() );
      for(int i = 1; i <= 7; i++)
      {
        try
        {
        	Thread.sleep(500);
         }
         catch( InterruptedException e)   {   
          
         }
         System.out.println( "  " + this.getName() + "  " + nombre + " # " + i );
      } // for
   } // Me. run
} // Cla. Refresco
