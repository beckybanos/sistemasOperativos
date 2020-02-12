
public class cajerosPrin
{
    public static void main (String args[])
    {
        Account myAccount = new Account("J. & J. Zorro", 10000.0);
        int mFam = 7;

        myAccount.print();
	    myAccount.deposit(1000.00);
	    myAccount.print();

        CajeAuto cajerosAtm [] = new CajeAuto[mFam];

        for (int i = 0; i <mFam; i++)
            cajerosAtm[i] = new CajeAuto("CajeroATM-" + i, myAccount);

        for (int i = 0; i <mFam; i++){
            cajerosAtm[i].start();
        }

        libHilos.espTodos(cajerosAtm, mFam);

        System.out.println("\n MAIN Saldo final: " + myAccount.getBalance());
        System.out.println("\n MAIN ADIOS");
    } // M. E. main

} // C. cajerosPrin