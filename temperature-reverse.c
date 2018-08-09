#include<stdio.h>

/* program to print celcius and farenhite table */

#define LOWER 0
#define UPPER 300
#define STEP 20

int main() {
	for (double fahr = UPPER; fahr >= LOWER; fahr -= STEP) {
		printf("%3.0f\t%3.1f\n", fahr, 9.0/5.0*(fahr-32));
	}
}
