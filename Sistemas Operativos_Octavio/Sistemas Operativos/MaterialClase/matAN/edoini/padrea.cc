/* padrea.cc */
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
   int  childpid, chldpd, childstts;

   printf( "\nPadre: Mi PID=%d\n\n", getpid() );

   childpid=fork();

   if(childpid < 0)
   {  perror("Error en fork, fallo la bifurcacion.");
      exit(-1);
   }
   else
   {
      if (childpid == 0)
      { /* PROCESO HIJO */
         printf( "ClonHijo: Mi PID=%d, PID del padre=%d\n", getpid(), getppid() );
         printf( "ClonHijo: comando  ps -l\n\n" );
         system( "ps -l" );
         printf( "\nClonHijo: Adios\n\n" );
         execlp("hijofina1.exe","hijofina1.exe","SaLuDoSa1",(char *) 0);
         exit(2);
      }else
      { /* PROCESO PADRE */
         printf( "FUMANDO ESPERO ...Y DESESPERO\n");
         chldpd = wait( &childstts );

         printf( "Padre: PID de mi hijo=%d, Mi PID=%d\n", 
                childpid, getpid() );
         printf( "Padre: Termino mi hijo=%d\n", chldpd );
         printf( "Padre: Status de mi hijo terminado es=%x\n", 
                (childstts>> 8) );
      }
   } 
   return 0;
}
