#include<stdio.h>
/* to count blanks, tabs and newlines */
int main() {
	int blanksCount=0, tabsCount=0, newlinesCount=0;
	int c;
	
	while ((c = getchar()) != '!') {
		if (c == ' ') {
			++blanksCount;
		}
		
		if (c == '\t') {
			++tabsCount;
		}

		if (c == '\n') {
			++newlinesCount;
		}
	}

	printf("blanks: %d tabs: %d newlines: %d", blanksCount, tabsCount, newlinesCount);
}
