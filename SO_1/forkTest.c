/////EX1

/*#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

void forkTest() {
        puts("TESTE FORK:\n");
    
    pid_t pid;
    
    pid = fork(); //cria processo
    
    if(pid > 0) {
        printf(" Processo Pai PID: %d ", pid);
    }
    else {
        printf(" Processo Filho PID: %d ", pid);
    }
    puts("FIM");
}

int main()
{
    forkTest();
}*/

/////EX2

/*#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

#define MAX_COUNT 10

void ChildProcess(void); //child process prototyp
void ParentProcess(void); //parent process prototype 

int main(void)
{
 pid_t pid;

 pid = fork();
 if (pid == 0)
 ChildProcess();
 else
 ParentProcess();
}

void ChildProcess(void)
{
 int i;

 for (i = 1; i <= MAX_COUNT; i++)
 printf(" This line is from child, value = %d\n", i);
 printf(" *** Child process is done ***\n");
}

void ParentProcess(void)
{
 int i;

 for (i = 1; i <= MAX_COUNT; i++)
 printf("This line is from parent, value = %d\n", i);
 printf("*** Parent is done ***\n");
}*/


//////EX3

#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(void)
{
   pid_t pid, pid2;
  
   pid = fork();
   if (pid > 0) {
     pid2 = fork();
     puts("Hello");
   }

  puts("Hello"); 
}