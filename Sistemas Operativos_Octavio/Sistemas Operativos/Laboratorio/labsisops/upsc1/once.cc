// once.cc

#include <stdio.h>
#include <time.h>
#include <unistd.h>

clock_t a,b;

int main()
{
    a = clock();
    printf( "a= %ld ticks.\n",a);

    printf( "------------------------------\n");
    for(int i = 0; i <= 100000000; i++){
        //vacio
    }
    printf( "------------------------------\n");

    b = clock();
    printf( "b= %ld ticks.\n", b);

    printf("La diferencia es de %ld ticks (%f segundos). \n",b-a,((float)(b-a))/CLOCKS_PER_SEC);

    return 0;
}