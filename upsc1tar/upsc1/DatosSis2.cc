// DatosSis.cc

#include <stdio.h>
#include <stdlib.h>

/* Despliega el contenido una variable de
   medio ambiente. */

int main()
{
  // Similar a "printenv var".
  printf("SYSNAME= %s\n", getenv("OSTYPE") );
  printf("HOST= %s\n", getenv("HOST") );
  printf("MACHINE= %s\n", getenv("MACHTYPE") );
  printf("VENDOR= %s\n", getenv("VENDOR") );

  return 0;
}
