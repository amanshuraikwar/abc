#include<stdio.h>
#include <stdbool.h>
/*
PURPOSE: To fold lines greater than N into two or more lines.
*/

#define N 10

int main() {
	int ch;
	int lastCh = ' ';
	int count = 0;
	bool lineBreak = false;
	while ((ch = getchar()) != EOF) {
		++count;
		if (count == N) {
			count = 0;
			if (ch == '\n') {
				putchar(ch);
			} else {
				lineBreak = 1;
				if (ch == ' ' || ch == '\t') {
					putchar(ch);
					putchar('\n');		
				} else {
					if (lastCh != ' ' && lastCh != '\t') {
						putchar('-');
					}
					putchar('\n');
					putchar(ch);
					count = 1;
				}
			}
		} else {

			if (ch == ' ' || ch == '\t') {
				if (!lineBreak) {
					putchar(ch);
					++count;
				}
			} else if (ch == '\n') {
				putchar(ch);
				count = 0;
				lineBreak = 0;
			} else {
				lineBreak = 0;
				putchar(ch);
			}
		}
		lastCh = ch;
	}
}
