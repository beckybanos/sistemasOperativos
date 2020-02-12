/* padrea.cc */
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
   int  childpid1, childpid2, childpid3, chldpd, childstts;

   printf( "\nPadre: Mi PID=%d\n\n", getpid() );

   childpid1=fork();

   if(childpid1 < 0)
   {  perror("Error en fork, fallo la bifurcacion.");
      exit(-1);
   }
   else
   {
      if (childpid1 == 0)
      { /* PROCESO HIJO */
         printf( "ClonHijo: Mi PID=%d, PID del padre=%d\n", getpid(), getppid() );
         printf( "ClonHijo: comando  ps -l\n\n" );
         system( "ps -l" );
         printf( "\nClonHijo: Adios\n\n" );
         execlp("./hijofina1.exe","hijofina1.exe","SaLuDoSa1",(char *) 0);
         exit(2);
      }else
      { /* PROCESO PADRE */
		childpid2=fork();
			if(childpid2 < 0)
	   {  perror("Error en fork, fallo la bifurcacion.");
	      exit(-1);
	   }
	   else
	   {
	      if (childpid2 == 0)
	      { /* PROCESO HIJO */
	         printf( "ClonHijo: Mi PID=%d, PID del padre=%d\n", getpid(), getppid() );
	         printf( "ClonHijo: comando  ps -l\n\n" );
	         system( "ps -l" );
	         printf( "\nClonHijo: Adios\n\n" );
	         execlp("./hijofina2.exe","hijofina2.exe","SaLuDoSa2",(char *) 0);
	         exit(2);
	      }else
	      	childpid3 = fork();
	      	if(childpid3 < 0)
	   {  perror("Error en fork, fallo la bifurcacion.");
	      exit(-1);
	   }
	   else
	   {
	      if (childpid3 == 0)
	      { /* PROCESO HIJO */
	         printf( "ClonHijo: Mi PID=%d, PID del padre=%d\n", getpid(), getppid() );
	         printf( "ClonHijo: comando  ps -l\n\n" );
	         system( "ps -l" );
	         printf( "\nClonHijo: Adios\n\n" );
	         execlp("./hijofina3.exe","hijofina3.exe","SaLuDoSa3",(char *) 0);
	         exit(2);
	      }else
	         printf( "FUMANDO ESPERO ...Y DESESPERO\n");
	         chldpd = wait( &childstts );

	         printf( "Padre: PID de mi hijo=%d, Mi PID=%d\n", 
	                chldpd, getpid() );
	         printf( "Padre: Termino mi hijo=%d\n", chldpd );
	         printf( "Padre: Status de mi hijo terminado es=%x\n", 
	                (childstts>> 8) );
	         chldpd = wait( &childstts );

	         printf( "Padre: PID de mi hijo=%d, Mi PID=%d\n", 
	                chldpd, getpid() );
	         printf( "Padre: Termino mi hijo=%d\n", chldpd );
	         printf( "Padre: Status de mi hijo terminado es=%x\n", 
	                (childstts>> 8) );
	         chldpd = wait( &childstts );

	         printf( "Padre: PID de mi hijo=%d, Mi PID=%d\n", 
	                chldpd, getpid() );
	         printf( "Padre: Termino mi hijo=%d\n", chldpd );
	         printf( "Padre: Status de mi hijo terminado es=%x\n", 
	                (childstts>> 8) );
	      }
	   } 
   return 0;
}
}
}
