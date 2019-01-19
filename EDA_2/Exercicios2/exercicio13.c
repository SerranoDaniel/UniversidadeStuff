#include <stdio.h>

void coco(int *a){
	*a = 1;
}

int main(void){
	//int x;
	//scanf("%d", &x);
	//printf("Numero lido: %d\n", x);

	int a=0;
	printf("%d\n", a);
	coco(&a);
	printf("%d", a);



	//double r;
	//scanf("%lf", &r);
	//printf("Numero real: %lf\n", r);

	//double c1, c2;
	//scanf(" (%lf , %lf)", &c1, &c2);
	//printf("Coords: %.3lf, %.3lf\n", c1, c2);


}