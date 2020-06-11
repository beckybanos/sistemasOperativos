// Fecha.cc

#include <stdio.h>
#include <time.h>

int main()
{
    time_t a;
    char *st1;

    time( &a );
    printf("a= %ld seg.\n",a);

    // Similar al comando "date"
    st1 = ctime( &a );
    printf("st1= %s\n",st1);

    return 0;
}
