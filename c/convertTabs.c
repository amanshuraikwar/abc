#include<stdio.h>
/* convert tabs to \t */
int main() {
	int c;
	while ((c = getchar()) != '!') {
		if (c == '\t') {
			printf("\\t");
		} else {
			putchar(c);
		}
	}
}
