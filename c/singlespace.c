#include<stdio.h>
/* convert multiple spaces to single space */
int main() {
	int c;
	int wasLastSpace = 0;
	while ((c = getchar()) != '!') {
		if (c == ' ') {
			wasLastSpace = 1;
		} else {
			if (wasLastSpace) {
				putchar(' ');
				wasLastSpace = 0;
			}
			putchar(c);
		}
	}
}
