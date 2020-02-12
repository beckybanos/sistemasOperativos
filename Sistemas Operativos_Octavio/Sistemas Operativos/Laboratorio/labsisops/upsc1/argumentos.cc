// argumentos.cc
#include <stdio.h>

int main(int argc, char *argv[])
{
   int i;

   /* Lista los argumentos tecleados en la linea de comando */
   printf("#arg=%d\n",argc);
   for (i=0; i<argc; i++)
      printf("argv[%d] = %s \n",i,argv[i]);
   printf("\n");

  return 0;
}
