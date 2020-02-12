
public class ProCon7 {
    public static void main(String[] args) {

        Thread[] arrHilos = new Thread[21];

        Madriguera madSillas = new Madriguera(20);
        Madriguera madMesas = new Madriguera(20);
        Madriguera madSofas = new Madriguera(20);

        Productor prodSillas1 = new Productor(madSillas, 1, 8, "silla");
        Productor prodSillas2 = new Productor(madSillas, 2, 5, "silla");
        Productor prodSillas3 = new Productor(madSillas, 3, 7, "silla");
        Productor prodMesas1 = new Productor(madMesas, 1, 8, "mesa");
        Productor prodMesas2 = new Productor(madMesas, 2, 5, "mesa");
        Productor prodMesas3 = new Productor(madMesas, 3, 7, "mesa");
        Productor prodSofas1 = new Productor(madSofas, 1, 8, "sofa");
        Productor prodSofas2 = new Productor(madSofas, 2, 5, "sofa");
        Productor prodSofas3 = new Productor(madSofas, 3, 7, "sofa");

        Consumidor conSillas1 = new Consumidor(madSillas, 1, 4, "silla");
        Consumidor conSillas2 = new Consumidor(madSillas, 2, 5, "silla");
        Consumidor conSillas3 = new Consumidor(madSillas, 3, 5, "silla");
        Consumidor conSillas4 = new Consumidor(madSillas, 4, 6, "silla");
        Consumidor conMesas1 = new Consumidor(madMesas, 1, 4, "mesa");
        Consumidor conMesas2 = new Consumidor(madMesas, 2, 5, "mesa");
        Consumidor conMesas3 = new Consumidor(madMesas, 3, 5, "mesa");
        Consumidor conMesas4 = new Consumidor(madMesas, 4, 6, "mesa");
        Consumidor conSofas1 = new Consumidor(madSofas, 1, 4, "sofa");
        Consumidor conSofas2 = new Consumidor(madSofas, 2, 5, "sofa");
        Consumidor conSofas3 = new Consumidor(madSofas, 3, 5, "sofa");
        Consumidor conSofas4 = new Consumidor(madSofas, 4, 6, "sofa");

        arrHilos[0] = prodSillas1;
        arrHilos[1] = prodSillas2;
        arrHilos[2] = prodSillas3;
        arrHilos[3] = prodMesas1;
        arrHilos[4] = prodMesas2;
        arrHilos[5] = prodMesas3;
        arrHilos[6] = prodSofas1;
        arrHilos[7] = prodSofas2;
        arrHilos[8] = prodSofas3;
        arrHilos[9] = conSillas1;
        arrHilos[10] = conSillas2;
        arrHilos[11] = conSillas3;
        arrHilos[12] = conSillas4;
        arrHilos[13] = conMesas1;
        arrHilos[14] = conMesas2;
        arrHilos[15] = conMesas3;
        arrHilos[16] = conMesas4;
        arrHilos[17] = conSofas1;
        arrHilos[18] = conSofas2;
        arrHilos[19] = conSofas3;
        arrHilos[20] = conSofas4;

        for (int i = 0; i < arrHilos.length; i++)
            arrHilos[i].start();

        libHilos.espTodos(arrHilos, 20);

        System.out.println("MAIN : ADIOS");
    }
}