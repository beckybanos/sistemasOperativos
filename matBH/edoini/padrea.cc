/* padrea.cc */
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main()
{
   int  childpid, chldpd, childstts;
   char processes[3][100] = {"./hijofina1.exe", "./hijofina2.exe", "./hijofina3.exe"};
   char names[3][100] = {"plastiloka", "victor", "humbert"};
   printf( "\nPadre: Mi PID=%d\n\n", getpid() );

for(int i=0; i<3; i++) {

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
         execlp(processes[i],processes[i],names[i],(char *) 0);
         exit(2);
      }
   } 
}
for(int j=0;j<3;j++)
{ /* PROCESO PADRE */
         printf( "FUMANDO ESPERO ...Y DESESPERO\n");
	 chldpd = wait( &childstts );

         printf( "Padre: PID de mi hijo=%d, Mi PID=%d\n", 
                childpid, getpid() );
         printf( "Padre: Termino mi hijo=%d\n", chldpd );
         printf( "Padre: Status de mi hijo terminado es=%x\n", 
                (childstts>> 8) );
}
   return 0;
}
