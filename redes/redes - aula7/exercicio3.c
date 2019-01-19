#include <stdio.h>
#include <math.h>

int main(void)
{
    int pre1, pre2, n1;

    int n, c, k;
 
  printf("Enter an integer in decimal number system\n");
  scanf("%d", &n);
 
  printf("%d in binary number system is:\n", n);
 
  for (c = 31; c >= 0; c--)
  {
    k = n >> c;
 
    if (k & 1)
      printf("1");
    else
      printf("0");
  }


    

    printf("manda vir: \n");
    scanf("%d/%d", &pre1, &n1);

    printf("manda vir: \n");
    scanf("%d", &pre2);

    int aux = pre1 - pre2 - 1;
    int aux2 = pow(2, aux);

    printf("Result: %d\n", aux2);

    return 0;
}