
public class Primer_Thread{
	
	public static void main (String args[]){
		
		System.out.println("M�todo main");	
		new SimpleThread(args[0]).start();
		new SimpleThread(args[1]).start();
		System.out.println("DONE Main!!!");
	}
}

