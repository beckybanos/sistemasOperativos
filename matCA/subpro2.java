import java.io.*;
import java.util.*;

public class subpro2
{
    static PrintWriter fileout;

    public static void main( String args[] ) throws IOException
    {
        fileout = new PrintWriter( new FileWriter("resul.txt") );
        String fecha1 = (new Date()).toString() ;
        fileout.println( "Hola que tal." + fecha1 );
        System.out.println( "Hola que tal." + fecha1 );

        for( int d = 0; d < 99990000; d++)
        {  for( int f = 0; f < 99990000; f++);
        }

        String fecha2 = (new Date()).toString() ;
        fileout.println( "Hasta luego."  + fecha2 );
        fileout.close();
        System.out.println( "Hasta luego."  + fecha2 );

        System.exit(-8);
    }
}
