// Crea tres nuevos threads que se ejecutan concurrentemente
public class principal
{
   public static void main(String[] args)
   {
      Refresco [] proLige = new Refresco[3];
      boolean b = true, ax;

      proLige[0] = new Refresco ("Pepsi Cola");
      proLige[1] = new Refresco ("Coca Cola");
      proLige[2] = new Refresco ("Orange Crush");
       
      proLige[0].start();
      proLige[1].start();
      proLige[2].start();

      //Refresco uno = new Refresco("Pepsi Cola");
      //Refresco dos = new Refresco("Coca Cola");
      //Refresco tres = new Refresco("Orange Crush");

      //uno.start();
      //dos.start();
      //tres.start();

      //Thread mnThr = Thread.currentThread();
      //System.out.println("Thread del main(): "+mnThr.getName());
      //System.out.println("Prioridad de main: "+mnThr.getPriority());

      while(b){
	 b = false;
 	 for(int i = 0; i <=2; i++){
	    ax = proLige[i].isAlive();
	    if(ax == false)
		System.out.println("TERMINO: "+proLige[i].getName());
	    else
		System.out.println("CONTINUA: "+proLige[i].getName());
	    b = b || ax;
	 }
      }

      System.out.println("\n+++main++++>>> Adios. ");
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
      System.out.println("--> " + this.getName() );
      System.out.println("Prioridad de main: "+this.getPriority());
      for(int i = 1; i <= 7; i++)
      {
         try
         {
            Thread.sleep(500);
         }
         catch( InterruptedException e)   {   }
         System.out.println( "  " + this.getName() + "  " + nombre + " # " + i );
      } // for
   } // Me. run
} // Cla. Refresco
