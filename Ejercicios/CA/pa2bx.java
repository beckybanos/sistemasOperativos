import java.io.*;

public class pa2bx
{
    public static void main (String args[])
        throws InterruptedException, IOException
    {
        Runtime rt = Runtime.getRuntime();
        String cmdargs [] = new String [2];
        cmdargs[0] = "java";
        cmdargs[1] = "subpro2";
        Process pro1 = rt.exec(cmdargs);
        System.out.println("Comando emitido: "+
                            cmdargs[0]+" "+cmdargs[1]);

        System.out.println("Ya termino o todavia falta");

	//boolean b = false;
	int y = -20;
	while(/*!b*/ y==-20)
	{
	  System.out.println("Ya termino?");
	  try
	  {
	    y = pro1.exitValue();
	    System.out.println("Ya.");
	    //b = true;
	  }
	  catch(IllegalThreadStateException i)
	  {
	    System.out.println("No.");
	  }
	}
	
        
        System.out.println("y= " + y);

        //IllegalThreadStateException
    }
}