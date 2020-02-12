import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 *Piping entre procesos padre - hijos
 */
public class pipesJvm {
  public static void main(String[] args) throws Exception{
    int st;
	Runtime r = Runtime.getRuntime();

    System.out.println("\n -- PING --");
	String[] nargs1 = { "ping", "-n", "27", "yahoo.com" };
    Process p1 = r.exec(nargs1);
    BufferedReader p1In = new BufferedReader(new InputStreamReader(p1.getInputStream()));

    String line1;
    while ((line1 = p1In.readLine()) != null)
        System.out.println(line1);
    st = p1.waitFor();
    p1In.close();

    System.out.println("\n -- IPCONFIG --");
    String[] nargs2 = { "ipconfig", "/all"};
    Process p2 = r.exec(nargs2);
    BufferedReader p2In = new BufferedReader(new InputStreamReader(p2.getInputStream()));

    String line2;
    while ((line2 = p2In.readLine()) != null)
        System.out.println(line2);
    st = p2.waitFor();
    p2In.close();
  }
}
