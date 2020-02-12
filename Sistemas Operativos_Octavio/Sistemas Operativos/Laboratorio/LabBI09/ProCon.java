
public class ProCon
{// Productor-Consumidor
    public static void main(String[] args)
    {
        System.out.print(" De el maximo de elementos por almacen: ");
        int nMax = LeeTe.tint();  // Lectura de un entero.

        Madriguera c = new Madriguera(nMax);
        Productor p1 = new Productor(c, 1);
        Consumidor c1 = new Consumidor(c, 1);
        Productor p2 = new Productor(c, 2);
        Consumidor c2 = new Consumidor(c, 2);

        p1.start();        c1.start();
        p2.start();        c2.start();

        Thread arrHilos [] = new Thread[4];
        arrHilos[0] = p1;    arrHilos[1] = p2;
        arrHilos[2] = c1;    arrHilos[3] = c2;
        libHilos.espTodos(arrHilos,4);

        System.out.println("MAIN : ADIOS");
    }
}// c. ProCon