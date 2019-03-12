#include<stdio.h>
/* print one word per line */

#define IN 1
#define OUT 0

int main() {
	int state = OUT;
	int c;
	while (( c = getchar()) != '!') {
		if (c == '\n' || c == '\t' || c == ' ') {
			if (state == IN) {
				putchar('\n');
			}
			state = OUT;
		} else {
			putchar(c);
			state = IN;
		} 
	}
}
