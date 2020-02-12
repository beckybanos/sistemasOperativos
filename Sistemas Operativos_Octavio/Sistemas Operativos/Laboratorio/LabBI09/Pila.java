
public class Pila
{
   private Object arrPila [];
   private int aptPi=0; // Apunta al primer lugar libre.
   private int taPi=0; //Capacidad de la Pila.

   public Pila(int ta)
   {
      taPi = ta;
      arrPila = new Object[taPi];
   }// m.c.

   public Object push(Object vo)
   {
      Object aux;
      if( aptPi >= taPi)
         aux = null;
      else
      {   arrPila[aptPi] = vo;
          aptPi++;
          aux = vo;
      }
      return aux;
   }// m.i. push

   public boolean lleno()
   {
       return ( aptPi >= taPi );
   }// m.i. lleno

   public Object pop()
   {
      Object aux;
      if( aptPi <= 0)
         aux = null;
      else
      {   aptPi--;
          aux = arrPila[aptPi];
      }
      return aux;
   }// m.i. pop

   public boolean vacio()
   {
       return ( aptPi <= 0 );
   }// m.i. vacio

   public int totPila()
   {
       return ( taPi );
   }// m.i. totPila

}// c. Pila