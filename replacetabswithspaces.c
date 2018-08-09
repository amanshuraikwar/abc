#include<stdio.h>

/*
PURPOSE: To replace tabs in text with appropriate spaces assuming some convertion parameter.
ASSUMTIONS: Tabstops are every N column
*/

#define TAB_SPACE_NO 2

// tabstops are every N column
#define N 4

int getSpacesCountRequired(int charNo, int n) {
	int m;
	return (m = charNo%n) ? (n - m + 1) : 1;
}

int main() {
	
	int c;
	int count = 0;

	while ((c = getchar()) != EOF) {
		
		++count;
		
		if (c == '\t') {
			
			int i = getSpacesCountRequired(count, N);
			// i-1 to avoid the already counted '\t' again
			count += i-1;
			
			for (; i > 0; --i) {
				putchar(' ');
			}	
		} else {
			putchar(c);
			if (c == '\n') {
				count = 0;
			}
		}
	}
	return 0;
}
