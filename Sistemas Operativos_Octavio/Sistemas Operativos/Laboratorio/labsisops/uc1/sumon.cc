#include <stdio.h>
#include <stdlib.h>

int main(int argn, char *argv[])
{
   int i, acum;
   acum=0;
   for(i=1; i<argn; i++)
   {
      acum += atoi( argv[i] );
   }
   printf("%d", acum);
   return 0;
}
