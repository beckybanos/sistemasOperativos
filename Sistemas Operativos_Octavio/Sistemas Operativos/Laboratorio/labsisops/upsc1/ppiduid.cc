// ppiduid.cc

#include <stdio.h>
#include <unistd.h>

int main()
{

  printf("\nProcess ID (PID)= %d\n", getpid() );
  printf("Parent Process ID (PPID)= %d\n", getppid() );

  // Parcialmente parecido al comando "id"
  printf("\nReal User ID (uid)= %d\n", getuid() );
  printf("Real Group ID (gid)= %d\n\n", getgid() );

  return 0;
}
