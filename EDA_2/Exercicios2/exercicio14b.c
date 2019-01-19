#include <stdio.h>

#define NELEMENTOS 50000
int v[NELEMENTOS];

void fillArray(){
	for(int i=2; i <= 2*NELEMENTOS; i+=2)
		v[i/2 - 1] = i;
}

int procura(int n, int s, int v[s]){
	if(n < s / 2){
		for (int i = 0; i < s / 2; ++i){
			if(v[i] == n){
				return i;
			}
		}
		return -1;
	}
	for (int i = s/2; i < s / 2; ++i){
		if(v[i] == n){
			return i;
		}
	}
	return -1;

}

int main(void){
	fillArray();

	for (int i = 1; i <= NELEMENTOS + 1; ++i)
  {
    int p = procura(2 * i, NELEMENTOS, v);

    if (p == -1)
      printf("Não encontrou %d\n", i);
    else if(v[p] != 2 * i)
      printf("Encontrou %d na posição errada: %d\n", i, p);
  }
}