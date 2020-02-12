#include <signal.h>
#include <stdio.h>
#include <stdlib.h>

void Fin(int nse)
{
   printf("\nADIOS, No. de la segnal recibida: %d\n\n", nse);
   exit(0) ;
}

int main()
{
   signal(SIGTERM, Fin);
   signal(SIGINT, Fin);
   
   while(1==1)
      printf("Aqui sigo\n");
   
   return 0;
}
