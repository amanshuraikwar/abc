#include<stdio.h>

/* 
PURPOSE: print histogram of length of words 
NOTE: uses '!' (without quotes) as program terminator
*/

#define IN 0
#define OUT 1

int main() {
	int c;
	int maxLength = 0;
	int state = OUT;
	int count = 0;

	int hist[30];
	for (int i = 0; i < 30; ++i) {
                hist[i] = 0;
        } 	

	while ((c = getchar()) != '!') {
		if (c == ' ' || c == '\n' || c == '\t') {
			if (state == IN) {
				if (count > maxLength) {
					maxLength = count;
				}
				hist[count] += 1;
				count = 0;
			}
			state = OUT;
		} else {
			state = IN;
			++count;
		}
	}

	printf("max lenght of a word in the given text is %d\n\nhorizontal histogram:\n", maxLength);
	int maxFreq = 0;

	for (int i = 0; i < 30; i++) {
		if (hist[i] != 0) {
			printf("%2d letters: ", i);
			if (hist[i] > maxFreq) {
				maxFreq = hist[i];
			}
			for (int j = 0; j < hist[i]; j++) {
				printf("*");
			}
			printf("\n");
		}
	}

	printf("\nvertical histogram:\n");
	
	for (int i = maxFreq; i >= 1; i--) {
		printf("%2d words | ", i); 
		for (int j = 1; j <= maxLength; j++) {
			if (hist[j] <= 0) {
				hist[j] = -1;
			} else if (hist[j] == i) {
				printf(" * ");
				--hist[j];
			} else {
				printf("   ");
			}
		}
		printf("\n");
	}

	printf("           ");
        for (int i = 1; i <= maxLength; i++) {
		if (hist[i] == 0) {
                	printf(" - ");
		}
        }	

	printf("\n           ");
	for (int i = 1; i <= maxLength; i++) {
		if (hist[i] == 0) {
			printf("%2d ", i);
		}
	}
}
