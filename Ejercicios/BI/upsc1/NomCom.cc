/* NomCom.cp, Jose-Ramon Rios-Sanchez
   Equivalente al comando "hostname".
   Obtiene el nombre local o primario de esta computadora. */

#include <stdio.h>
#include <unistd.h>

int main()
{
   char NomCom[256];
   int i;

   i= gethostname(NomCom, sizeof(NomCom) );
   if(i<0)
      printf("Error: %d gethostname.\n", i);
   else
      printf("\n  Nombre de esta computadora: %s\n\n", NomCom);
   return 0;
}


/* 
   Uso: NomCom

   SO: Unix. SunOS 5.4 al 5.7 (Solaris 2.4 al 2.7)
*/
