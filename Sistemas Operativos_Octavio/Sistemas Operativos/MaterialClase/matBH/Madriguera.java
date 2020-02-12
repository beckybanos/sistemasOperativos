
public class Madriguera
{
    private String almacen;
    private boolean available = false;

    public synchronized String get()
    {
        while (available == false)
        {
            try
            {
                // wait a que el Productor ponga un bien
                wait();
            } catch (InterruptedException e)
            {}
        }
        available = false;
        // notify al Productor que un bien ha sido tomado
        notifyAll();
        return almacen;
    }// m.i. get

    public synchronized void put(String bien)
    {
        while (available == true)
        {
            try
            {
                // wait a que el Consumidor tome el bien
                wait();
            } catch (InterruptedException e)
            {}
        }
        almacen = bien;
        available = true;
        // notify al Consumidor del bien producido
        notifyAll();
    }// m.i. put
}// c. Madriguera