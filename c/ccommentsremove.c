#include<stdio.h>
#include <stdbool.h>
/*
PURPOSE: To remove c comments from a source code file.
NOTE: Handling the string constants and char literals properly.
*/

int main() {

	int ch;
	bool inString = 0;
	bool inChar = 0;
	bool inSmlCmt = 0;
	bool inLrCmt = 0;
	int lastCh = ' ';
	bool lastChPrinted = 1;

	while ((ch = getchar()) != EOF) {
		if (inString || inChar) {
			putchar(ch);
			if (inString) {
				if (ch == '"') {
					inString = 0;
				}
			}
			if (inChar) {
				if (ch == '\'') {
					inChar = 0;
				}
			}
		} else {
			if (!inSmlCmt && !inLrCmt) {
				if (ch == '/') {
					if (lastCh == '/') {
						inSmlCmt = 1;
						lastChPrinted = 1;
					} else {
						lastChPrinted = 0;
					}
				} else if (ch == '*' && lastCh == '/') {
					inLrCmt = 1;
					lastChPrinted = 1;
				} else {
					inString = (ch == '"');
					inChar = (ch == '\'');
					if (!lastChPrinted) {
						putchar(lastCh);
						lastChPrinted = 1;	
					}
					putchar(ch);
				}
			} else {
				if (inSmlCmt) {
					if (ch == '\n') {
						inSmlCmt = 0;
					}
				} else if (inLrCmt) {
					if (ch == '/' && lastCh == '*') {
						inLrCmt = 0;
					}
				}
			}
		}
		lastCh = ch;
	}
	return 0;
}
