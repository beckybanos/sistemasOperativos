#include <time.h>
#include <stdio.h>

int main(int argc, char **argv)
{
  clock_t start = clock();
  printf("Ciclos de reloj antes del ciclo: %ld\n", start);
  
  for(int i=0;i<100000000;i++){ printf(""); }

  clock_t end = clock();
  printf("Ciclos de reloj despues del ciclo: %ld\n", end);

  printf("Tiempo transcurrido: %f\n",(double)(end-start)/CLOCKS_PER_SEC);
  
  return 0;
}