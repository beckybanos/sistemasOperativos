import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintStream;

/*
 */
public class padresin1 {
  public static void main(String[] args) throws Exception{
    Runtime rt = Runtime.getRuntime();

    String[] cmdArgsHijo1 = { "java", "hijosin1a", "15", "80", "-100" };
    Process h1 = rt.exec(cmdArgsHijo1); // Creacion y arranque del proceso hijo
    
    // Piping el stdout del proceso hijo
    BufferedReader bfh1In = new BufferedReader(new InputStreamReader(h1.getInputStream()));
    String line1;
    if ((line1 = bfh1In.readLine()) != null) // espera y lee lo enviado por el hijo
      System.out.println("El parcial de la 1ra suma es: " + line1);

    // Piping el stdin del hijo
    PrintStream bfhi1Out = new PrintStream( h1.getOutputStream());
    bfhi1Out.println("300"); // pasando al hijo otro sumando
    bfhi1Out.flush();
    
    // Piping del hijo 
    if ((line1 = bfh1In.readLine()) != null) // espera y toma lo enviado por el hijo
        System.out.println("El parcial de la 2da suma es: " + line1);
    
    // Piping al hijo
    bfhi1Out.println("500"); // pasando al hijo otro sumando
    bfhi1Out.flush();
    
    // Piping del hijo 
    if ((line1 = bfh1In.readLine()) != null) // espera y toma lo enviado por el hijo
        System.out.println("El parcial de la 3ra suma es: " + line1);

    // Piping al hijo 
    while(!bfh1In.ready());  // Espera a que el buffer no este vacio, solo si es necesario.
    if ((line1 = bfh1In.readLine()) != null) // espera y toma lo enviado por el hijo
        System.out.println("\nAl final: " + line1);

    // Espera a que el hijo termin
    System.out.println("Exit del hijo: " + h1.waitFor()); // Tambien puede usar exitValue() con catch.
	bfh1In.close();
	bfhi1Out.close();
 }
}
