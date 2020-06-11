//
//  Metodos para lectura de valores desde el Teclado.
//  Jose Ramon Rios Sanchez.
//  Copyright jrrs, 20042015

import java.util.Scanner;

public class LeeTe
{
    private static Scanner Teclado;
    private static boolean antNoStr;
    static {
        Teclado = new Scanner(System.in);
        antNoStr = false;
    }
    
    //  INTEGRAL

    /* Lectura de un valor entero byte desde el Teclado(stdin). */
    public static byte tbyte() 
    { 
        byte vl=0;
        try {
           if( Teclado.hasNextByte() )
              vl = Teclado.nextByte();    // Conversion a entero byte.
           else
              System.out.println("Error: no es un entero byte valido.");      
        }
        catch( Exception ex )
        {  System.out.println("\nError: " + ex.getMessage() );
           ex.printStackTrace();
        }
        antNoStr = true;
        return vl;
    }

    /* Lectura de un valor entero short desde el Teclado(stdin). */
    public static short tshort()
    { 
        short vl=0;
        try {
           if( Teclado.hasNextShort() )
              vl = Teclado.nextShort();    // Conversion a entero short.
           else
              System.out.println("Error: no es un entero short valido.");      
        }
        catch( Exception ex )
        {  System.out.println("\nError: " + ex.getMessage() );
           ex.printStackTrace();
        }
        antNoStr = true;
        return vl;
    }

    /* Lectura de un valor entero int desde el Teclado(stdin). */
    public static int tint()
    { 
        int vl=0;
        try {
           if( Teclado.hasNextInt() )
             vl = Teclado.nextInt();    // Conversion a entero int.
           else
           	 System.out.println("Error: no es un entero int valido.");      
        }
        catch( Exception ex )
        {  System.out.println("\nError: " + ex.getMessage() );
           ex.printStackTrace();
        }
        antNoStr = true;
        return vl;
    }

    /* Lectura de un valor entero long desde el Teclado(stdin). */
    public static long tlong()
    { 
        long vl=0;
        try {
           if( Teclado.hasNextLong() )
              vl = Teclado.nextLong();    // Conversion a entero long.
           else
              System.out.println("Error: no es un entero long valido.");      
        }
        catch( Exception ex )
        {  System.out.println("\nError: " + ex.getMessage() );
           ex.printStackTrace();
        }
        antNoStr = true;
        return vl;
    }


    // FLOATING POINT

    /* Lectura de un valor real float desde el Teclado(stdin). */
    public static float tfloat()
    { 
        float vl=0.0f;
        try {
           if( Teclado.hasNextFloat() )
              vl = Teclado.nextFloat();    // Conversion a real float.
           else
              System.out.println("Error: no es un real float valido.");      
        }
        catch( Exception ex )
        {  System.out.println("\nError: " + ex.getMessage() );
           ex.printStackTrace();
        }
        antNoStr = true;
        return vl;
    }


    /* Lectura de un valor real double desde el Teclado(stdin). */
    public static double tdouble()
    { 
        double vl=0.0;
        try {
           if( Teclado.hasNextDouble() )
              vl = Teclado.nextDouble();    // Conversion a real double.
           else
              System.out.println("Error: no es un real double valido.");      
        }
        catch( Exception ex )
        {  System.out.println("\nError: " + ex.getMessage() );
           ex.printStackTrace();
        }
        antNoStr = true;
        return vl;
    }


    // LOGICAL

    /* Lectura de un valor boolean desde el Teclado(stdin). */
    public static boolean tboolean()
    { 
        boolean vl=false;
        try {
           if( Teclado.hasNextBoolean() )
              vl = Teclado.nextBoolean();    // Conversion a boolean.
           else
              System.out.println("Error: no es un boolean valido.");      
        }
        catch( Exception ex )
        {  System.out.println("\nError: " + ex.getMessage() );
           ex.printStackTrace();
        }
        antNoStr = true;
        return vl;
    }


    // TEXTUAL

    /* Lectura de un valor char desde el Teclado(stdin). */
    public static char tchar()
    { 
        char vl='0';
        try {
           if( Teclado.hasNext() )
              vl = (Teclado.next()).charAt(0);    // Conversion a char.
           else
              System.out.println("Error: no se encontro el char.");      
        }
        catch( Exception ex )
        {  System.out.println("\nError: " + ex.getMessage() );
           ex.printStackTrace();
        }
        antNoStr = true;
        return vl;
    }

    /* Lectura de un valor String desde el Teclado(stdin). */
    public static String tString()
    { 
        String vl="0";
        try {
           if( Teclado.hasNext() )
              vl = Teclado.next();    // Conversion a String.
           else
              System.out.println("Error: no se encontro el String.");      
        }
        catch( Exception ex )
        {  System.out.println("\nError: " + ex.getMessage() );
           ex.printStackTrace();
        }
        antNoStr = true;
        return vl;
    }

    /* Lectura de un valor String, con espacios, desde el Teclado(stdin). */
    public static String tStringln()
    { 
        String vl="0";
        try {
           if( Teclado.hasNext() ) {
              if( antNoStr ) vl = Teclado.nextLine();
              vl = vl + Teclado.nextLine();    // Conversion a String.
           } else {
              System.out.println("Error: no se encontro el String.");
           }
        }
        catch( Exception ex )
        {  System.out.println("\nError: " + ex.getMessage() );
           ex.printStackTrace();
        }
        antNoStr = false;
        return vl;
    }
}
