import java.util.*;

public class FechaG
{
   public static Calendar calendar;

   public static void main( String args[] )
   {
      long t1 = System.currentTimeMillis();
      calendar = new GregorianCalendar();
      System.out.println("HOY= " + (new Date()).toString() );
      aux();

      System.out.println("---------------------------");
      try {  
        Thread.sleep(4000); 
      }
      catch (InterruptedException e) { 
      } 
      System.out.println("---------------------------");

      calendar = new GregorianCalendar();
      System.out.println("HOY= " + (new Date()).toString() );
      aux();
      long t2 = System.currentTimeMillis();
      t2 = t2-t1;

      System.out.println("La diferencia es de "+t2+" milisegundos.");

   } // main

   public static void aux()
   {
      System.out.print("DATE: " + calendar.get(Calendar.DATE) +
                       "        ");
      System.out.print("MONTH: " + (calendar.get(Calendar.MONTH)+1) +
                       "        ");
      System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
      System.out.print("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR) +
                       "        ");
      System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
      System.out.print("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH) +
                       "        ");
      System.out.print("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR) +
                       "        ");
      System.out.println("DAY_OF_WEEK: " +calendar.get(Calendar.DAY_OF_WEEK));
      System.out.print("HOUR: " + calendar.get(Calendar.HOUR) +
                       "        ");
      System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
      System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
      System.out.print("MINUTE: " + calendar.get(Calendar.MINUTE) +
                       "        ");
      System.out.print("SECOND: " + calendar.get(Calendar.SECOND) +
                       "        ");
      System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
   }// aux
} // FechaG

