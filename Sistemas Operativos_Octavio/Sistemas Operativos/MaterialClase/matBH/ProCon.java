
public class ProCon
{// Productor-Consumidor
    public static void main(String[] args)
    {
        Madriguera c = new Madriguera();

        Productor p1 = new Productor(c, 1);
        Consumidor c1 = new Consumidor(c, 1);

        p1.start();
        c1.start();

        Thread arrHilos [] = new Thread[2];
        arrHilos[0] = p1;
        arrHilos[1] = c1;
        libHilos.espTodos(arrHilos,2);

        System.out.println("MAIN : ADIOS");
    }
}// c. ProCon