// DatosUsu.cc

#include <stdio.h>
#include <stdlib.h>

/* Despliega el contenido una variable de
   medio ambiente. */

int main()
{
  // Similar a "printenv USER".
  printf("NOMBRE DE USUARIO= %s\n", getenv("USER") );
  // Similar a "printenv HOME".
  printf("HOME DIRECTORY= %s\n", getenv("HOME") );
  // Similar a "printenv PWD".
  printf("DIRECTORIO DE TRABAJO= %s\n", getenv("PWD") );

  return 0;
}
