
public class libHilos
{
	// Espera a que todos los Threads referenciados en el
	// arreglo thrAct hayan terminado.
    public static void espTodos(Thread thrAct[], int mFam)
    {
        boolean b = true;
        while(b)
        {  b = false;
           for(int i = 0; i <mFam; i++)
           {  b = b || thrAct[i].isAlive();
           }
        }
    } // M. E. espTodos

	// Duerme durante un tiempo que es multiplicado por
	// un numero aleatorio.
    public static void hacerTiem(int itera, int tiempo)
    {
        for (int i = 0; i < itera; i++)
        {
            try
            {
                Thread.sleep((int)(Math.random() * tiempo));
            }
            catch (InterruptedException e)
            {   }
        }
    } // M. E. hacerTiem

} // C. libHilos
