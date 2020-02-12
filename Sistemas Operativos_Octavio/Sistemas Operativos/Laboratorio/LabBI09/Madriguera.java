
public class Madriguera
{
    private Pila almacen;

    public Madriguera(int taMax)
    {
        almacen = new Pila(taMax);
    }// m.c.

    public synchronized String get()
    {
        String bien;
        while (almacen.vacio() == true)
        {
            try
            {
                // wait a que el Productor ponga un bien
                wait();
            } catch (InterruptedException e)
            {}
        }
        bien = (String)almacen.pop();
        System.out.println("    --> get : " +
            (Thread.currentThread()).getName() +
            " < " + bien);
        // notify al Productor que un bien ha sido tomado
        notifyAll();
        return (bien);
    }// m.i. get

    public synchronized void put(String bien)
    {
        while (almacen.lleno() == true)
        {
            try
            {
                // wait a que el Consumidor tome el bien
                wait();
            } catch (InterruptedException e)
            {}
        }
        almacen.push(bien);
        System.out.println("--> put : " +
            (Thread.currentThread()).getName() +
            " > " + bien);
        // notify al Consumidor del bien producido
        notifyAll();
    }// m.i. put
}// c. Madriguera