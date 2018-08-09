#include<stdio.h>

/*
PURPOSE: To replace spaces with minimum number of tabs and blanks
ASSUMPTION: Tabstops are every N columns
*/

#define N 4

int main() {
	int ch;
	int count = 0;
	int spaceCount = 0;
	while ((ch = getchar()) != EOF) {
		++count;
		if (ch == ' ') {
			spaceCount += 1;
			if (count%N == 0) {
				// if there is an option between
				// one space and one tab
				// tab is given priority
				putchar('\t');
				spaceCount = 0;
			}
		} else {
			if (spaceCount != 0) {
				for(; spaceCount > 0; --spaceCount) {
					putchar(' ');
				}
			}
			putchar(ch);
			if (ch == '\n') {
				count = 0;
			}
		}
	}
}
