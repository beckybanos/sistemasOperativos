#include <stdio.h>

int main () {
      char buffer [50];
      int n, a=5, b=3;
      n = sprintf (buffer,  "%d mas %d es %d",  a,  b,  a+b);    // buffer con string formateado
      printf ("[%s] es un string con %d caracteres\n",  buffer,  n);
      return 0;
}
