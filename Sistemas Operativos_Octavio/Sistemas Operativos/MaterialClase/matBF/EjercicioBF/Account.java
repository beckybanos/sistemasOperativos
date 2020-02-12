/*
* El amount es el ente comun 
* Y las secciones criticas son los metodos
*/
public class Account
{
	private String accountName;
	private double amount;

	public Account ()
    {
    } // M. C.

	public Account (String name, double money)
    {
    	accountName = name;
		amount = money;
	} // M. C.

	public synchronized double deposit(double money)
    {   double bal = -11.0;
        if (money > 0.0)
        {
            libHilos.hacerTiem(1,1000);
			amount += money;
            libHilos.hacerTiem(1,1000);
			bal = amount;
		} else
        {   bal = -1.0;
		}
      return bal;
	} // M. I. deposit

	public synchronized double withdraw(double money)
    {   double bal = -12.0;
      	if (money > 0.0)
        {	if (amount >= money)
            {	libHilos.hacerTiem(1,1000);
				amount -= money;
                libHilos.hacerTiem(1,1000);
				bal = amount;
			} else
                bal = -1.0;
		} else
            bal = -1.0;
      return bal;
	} // M. I. withdraw

	public synchronized double getBalance()
    {
    	libHilos.hacerTiem(1,1000);
		return amount;
	} // M. I. getBalance

	public synchronized String getName()
    {
    	return accountName;
	} // M. I. getName

	public synchronized void print()
    {
    	System.out.println("Account " + getName() +
            " has $"+ getBalance() + " balance.");
	} // M. I. print()

} // C. Account
