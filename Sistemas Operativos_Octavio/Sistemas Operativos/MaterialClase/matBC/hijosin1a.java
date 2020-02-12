// Proceso hijo que se sincroniza con el padre para ayudarlo a sumar
import java.util.Scanner;

public class hijosin1a {
    private static Scanner Teclado = new Scanner(System.in);


  public static void main(String[] args) throws Exception {
  	int acum = 0;
  	for(int i=0; i<args.length; i++) {
  		acum = acum + Integer.parseInt(args[i]);
  	}
  	System.out.println(acum); // Enviando al padre

  	int aux;
 	aux = Teclado.nextInt(); // esperando y tomando a que el padre envie el siguiente valor
  	acum = acum + aux;
  	System.out.println(acum); // Enviando el total al padre

 	aux = Teclado.nextInt(); // esperando y tomando a que el padre envia el ultimo valor
  	acum = acum + aux;
  	System.out.println(acum); // Enviando el total al padre

  	System.out.println("Ya acabe apa.");
  	System.exit(3);

  }
}
