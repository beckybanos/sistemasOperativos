#include <stdio.h>
#include <stdlib.h>

int main()
{
   char linea[80];
   int monto;
   float iva;
   scanf("%s",linea);
   monto = atoi( linea );
   iva = monto * 0.16;
   printf("Monto = %d\n", monto);
   printf("IVA = %f\n", iva);
   printf("Total = %f\n", monto+iva);
   return 0;
}
