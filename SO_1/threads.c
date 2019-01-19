#include <pthread.h>
#include <stdio.h>

/* Prints x’s to stderr. The parameter is unused. Does not return. */
void* print_xs (void* unused)
{
  int i= 0;
  while (i < 10) {
    puts ("x");
    i++;
  }
  return NULL;
}

void* print_os (void* unused)
{
  int i= 0;
  while (i < 10) {
    puts ("o");
    i++;
  }
  return NULL;
}

/* The main program. */
int main ()
{
  pthread_t thread_id, thread_id2;
  /* Create a new thread. The new thread will run the print_xs() function. */
  pthread_create (&thread_id, NULL, &print_xs, NULL);
  pthread_create (&thread_id1, NULL, &print_os, NULL);

  pthread_join(thread_id, NULL);
  pthread_join(thread_id2, NULL);



  /* Print o’s continuously to stderr. 
  int i= 0;
  while (i < 10) {
    puts ("o");
    i++;
  }
  */

  return 0;
}