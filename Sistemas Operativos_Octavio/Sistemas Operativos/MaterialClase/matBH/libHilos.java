
public class libHilos
{
    public static void espTodos(Thread thrAct[], int mFam)
    {
        boolean b = true;
        while(b)
        {  b = false;
           for(int i = 0; i <mFam; i++)
           {  b = b || thrAct[i].isAlive();
           }
        }
    } // m.e. espTodos

    public static void hacerTiem(int itera, int tiempo)
    {
        for (int i = 0; i < itera; i++)
        {
            try
            {
                Thread.sleep((int)(Math.random() * tiempo));
            }
            catch (InterruptedException e)
            {}
        }
    } // m.e. hacerTiem

}// c. libHilos
