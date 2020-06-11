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

        System.out.println("Ya termino o todavía falta");
        int y = pro1.exitValue();
        System.out.println("y= " + y);

        //IllegalThreadStateException
    }
}