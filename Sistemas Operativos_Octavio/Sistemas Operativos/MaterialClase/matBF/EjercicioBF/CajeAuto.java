
public class CajeAuto extends Thread
{
    private Account cuenta;

    public CajeAuto(String str, Account cta)
    {
    	super(str);
        cuenta = cta;
    } // M. C.

    public void run()
    {
    	double saldoI, saldoF;

        libHilos.hacerTiem(1,1000);
        saldoI = cuenta.getBalance();

        libHilos.hacerTiem(1,1000);
        saldoF = cuenta.withdraw(2000.0);

        System.out.println("\n" + this.getName() +
            ";  nomCta: " + cuenta.getName() +
            ";\n             " +
            "  saldoI: " + saldoI +
            ";  saldoF: " + saldoF);

        System.out.println("DONE! " + this.getName());
    } // M. I. run

} // C. CajeAuto