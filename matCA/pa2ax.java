import java.io.*;

public class pa2ax
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

        System.out.println("Esperando a que termine.");
        int x = pro1.waitFor();
        System.out.println("x= " + x);

        System.out.println("Ya termino");
    }
}