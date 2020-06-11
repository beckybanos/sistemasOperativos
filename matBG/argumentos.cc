// argumentos.cc
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[])
{
   int i;

   /* Lista los argumentos tecleados en la linea de comando */
   printf( "#arg= %d \n", argc );
   for (i=0; i<argc; i++)
      printf( "argv[%d]= %s\n", i, argv[i] );
   printf("\n");
   if (system(NULL)) puts ("ok");
	else printf("argv[%d]= %d\n");

  return 0;
}


