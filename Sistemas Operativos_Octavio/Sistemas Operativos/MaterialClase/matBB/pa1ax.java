import java.io.*;

public class pa1ax
{
    public static void main (String args[])
        throws InterruptedException, IOException
    {
        Runtime rt = Runtime.getRuntime();
        String cmdargs [] = new String [1];
        cmdargs[0] = "C:/Program Files (x86)/Microsoft Office/Office16/EXCEL.EXE";
        Process pro1 = rt.exec(cmdargs);
        System.out.println("Comando emitido: "+cmdargs[0]);
        int x = pro1.waitFor();
        System.out.println("x= " + x);
    }
}