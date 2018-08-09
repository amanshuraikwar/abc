#include<stdio.h>
int main() {
	
	float farhenite;
	int low = 0, high = 300, step = 20;
	farhenite = low;
	printf("Farhenite | Celcius\n");
	while (farhenite <= high) {
		float celcius = 5.0/9.0*(farhenite-32);
		printf("%9.0f | %6.1f\n", farhenite, celcius);
		farhenite += step;
	} 
}
