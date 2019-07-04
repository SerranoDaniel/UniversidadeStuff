#include <stdio.h>

int mdc(int dividendo, int divisor)
{
	// dividendo = a; divisor = b
	for (i = 1; i <= dividendo && i <= divisor; ++i)
	{
		if (dividendo % i == 0 && divisor % i == 0)
		{
			mdc = i;
		}
	}
}

int main()
{
	printf("O mdc é: %d", mdc);

	return 0;
}
