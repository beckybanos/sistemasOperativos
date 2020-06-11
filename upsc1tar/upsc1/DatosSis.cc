// DatosSis.cc

#include <stdio.h>
#include <stdlib.h>

/* Despliega el contenido una variable de
   medio ambiente. */

int main(int argc, char *argv[])
{
  // Similar a "printenv var".
  printf("Proceso: %s\n", argv[0]);
  if(argc>=1)
	for (int i=1; i<argc; i++)
		printf("%s= % \n",argv[i],getenv(argv[i]));

  return 0;
}
