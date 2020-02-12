/* subs.cc */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[] )
{
    printf( "\n%s: Mi PID=%d, PID del padre=%d\n", argv[0], getpid(), getppid() );
    printf("%s: comando ps -l.\n", argv[0] );
    system( "ps -l" );
    printf("\n%s: reemplazandose . . .\n", argv[0] );
    execlp( "otro01.exe", "otro01.exe", "viajarX", (char *) 0 );

    return 0;
}
