// argumentos.cc
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[])
{
   int i, n;
   char buffer[50];
   for (i=0; i<argc; i++){
      sprintf(buffer,"echo %s >> resultados.txt",argv[i]);
      system(buffer);
   }
   system("echo 'Amanda y Octavio' >> resultados.txt");

  return 0;
}
