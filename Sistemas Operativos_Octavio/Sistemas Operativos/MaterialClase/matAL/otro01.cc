/* otro01.cc */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
   printf( "\n%s: Mi PID=%d, PID de mi padre=%d\n", argv[0], getpid(), getppid());
   if( argc > 1 )  printf( "%s: recibiendo= %s \n", argv[0], argv[1] );
   printf( "%s: comando  ps -l\n",argv[0]);
   system( "ps -l" );
   printf( "%s: Adios\n\n",argv[0] );
   exit(3);
}
