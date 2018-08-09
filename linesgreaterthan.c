#include<stdio.h>

/*
PURPOSE: to display lines with length greater than n
*/

#define LIMIT 10

int main() {
	char buffer[LIMIT+1];
	buffer[LIMIT] = '\0';
	int c;
	int i = 0;
	while ((c = getchar()) != EOF) {
		if (c == '\n') {
			if (i > LIMIT) {
				putchar(c);
			}
			i = 0;
		} else if (i == LIMIT) {
			printf("%s%c", buffer, c);
			++i;
		} else if (i > LIMIT) {
			putchar(c);
			++i;
		} else {
			buffer[i] = c;
			++i;
		}
	}
	return 0;
}
