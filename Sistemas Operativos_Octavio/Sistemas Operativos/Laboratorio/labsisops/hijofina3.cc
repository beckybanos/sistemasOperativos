/* hijofina3.cc */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
   char buffer[50];
   printf( "\n%s: Mi PID=%d, PID de mi padre=%d\n", argv[0], 
          getpid(), getppid());
   if( argc > 1 )  printf( "%s: recibiendo= %s \n", argv[0], argv[1] );
   printf( "%s: comando  ps -l\n",argv[0]);
   sprintf(buffer,"echo %s > hijofina3.txt",argv[1]);
   system(buffer);
   system( "ps -l >> hijofina3.txt" );
   int i, r;
   r = rand();
   for(i = 0; i <= r; i++) {
       //vacio
   }
   printf( "\n%s: Adios\n\n",argv[0] );
   exit(9);
}
