#include <stdio.h>
#include <stdbool.h>

bool isPrime(int n){
    for(int i=2; i<n; i++)
        if (n%i == 0)
            return false;

    return true;
}


int main(void){
	for(int i=555; i <= 777; i++)
		if(isPrime(i))
			printf("%d ", i);
}
