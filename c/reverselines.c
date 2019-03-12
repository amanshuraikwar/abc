#include<stdio.h>

/*
PURPOSE: to reverse lines of the given text
*/

void reverse(char[], int);
int readline(char[], int);

#define LINE_MAX_LEN 1000

int main() {
	char line[LINE_MAX_LEN+1];
	int len;
	while ((len = readline(line, LINE_MAX_LEN)) > 0) {
		reverse(line, len-1);
		printf("%s\n", line);
	}
	return 0;
}

int readline(char line[], int limit) {
	int c, i, count = 0;
	for (i = 0; i < limit-1 && (c = getchar()) != EOF; ++i) {
		if (c == '\n') {
			++count;
			break;
		}
		line[i] = c;
		++count;
	}
	line[i] = '\0';
	return count;
}

void reverse(char string[], int len) {
	int temp;
	for (int i = 0; i < len/2; i++) {
		temp = string[i];
		string[i] = string[len-i-1];
		string[len-i-1] = temp;
	}
}
