public class argumentos
{   public static void main(String[] argv)
    {   
        System.out.println("#argumentos= "+ argv.length);
        for(int i=0; i<argv.length; i++)
            System.out.println("argv["+i+"]="+
                argv[i] + "(" + argv[i].length() + ") ");
        System.out.println();
    }
}

/* java argumentos arg0 arg1 arg2 ...
   imprime los valores: arg0 arg1 arg2 ...
   que recibe el metodo main de la clase argumentos */
