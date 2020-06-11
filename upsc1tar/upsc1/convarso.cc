// convarso.cc
// Solo variables del medio ambiente.

#include <stdio.h>

int main(int argc, char *argv[], char *envp[])
{
  int i;

  /* Lista de argumentos del medio ambientes */
  for (i=0; envp[i] != (char *) 0; i++) 
      printf("envp[%d]: %s\n",i,envp[i]);
  
  return 0;
}
