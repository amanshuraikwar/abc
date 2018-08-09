#include<stdio.h>

/*
PURPOSE: remove trailing blanks and spaces from a line and also delete entirely blank lines
*/

#define MAX_LINE_LEN 1000
#define OUT 0
#define IN 1

int main() {
	
	char blanks[MAX_LINE_LEN+1];
	blanks[MAX_LINE_LEN] = '\0';
	blanks[0] = '\0';
	int c;
	int i = 0;
	int state = OUT;
	int wordCount = 0;
	while((c = getchar()) != EOF) {
		if (c == ' ' || c == '\t') {
			if (state == IN) {
				i = 0;
			}
			blanks[i] = c;
			blanks[i+1] = '\0';
			++i;
			state = OUT;
		} else if (c == '\n') {
			i = 0;
			state = OUT;
			blanks[0] = '\0';
			if (wordCount > 0) {
				putchar(c);
				wordCount = 0;
			}
		} else {
			++wordCount;
			if (i > 0) {
				printf("%s", blanks);
			}
			blanks[0] = '\0';
			i = 0;
			putchar(c);
		}
	}
	return 0;
}
