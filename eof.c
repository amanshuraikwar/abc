#include<stdio.h>
/* for printing the value of EOF which is -1*/
int main() {
	int c;
	/*
	while ((c = getchar()) != EOF) {
		putchar(c);
	}
	*/
	putchar(EOF);
	printf("\n%d\n", EOF);
}
