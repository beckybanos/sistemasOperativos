
public class UsoPila
{
   public static void main(String args[])
   {
      Pila p = new Pila(10);
      int i,j;
      Object o1,o2;   Integer I1,I2;
      i=3;   o1=new Integer(i);
      I1 = (Integer)p.push(o1);
      System.out.println(I1.intValue());
   }
}