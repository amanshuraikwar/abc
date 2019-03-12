#include<stdio.h>

/*
PURPOSE: to print histogram of frequency of characters
*/

#define PRINT_LOWER_LIMIT 97
#define PRINT_UPPER_LIMIT 122

int main() {
	int c;
	int freq[128];
	int maxFreq = 0;

	for (int i = 0; i <= 127; i++) {
		freq[i] = 0;
	}
	
	while ((c = getchar()) != EOF) {
		freq[c] += 1;
		if (freq[c] > maxFreq) {
			maxFreq = freq[c];
		}
	}
	
	int maxPrintFreq = 0;
	for (int i = PRINT_LOWER_LIMIT; i <= PRINT_UPPER_LIMIT; i++) {
		if (freq[i] > maxPrintFreq) {
			maxPrintFreq = freq[i];
		}
	}

	printf("histogram:\n");
	for (int i = maxPrintFreq; i >= 1; i--) {
		printf("%4d | ", i);
		for (int j = PRINT_LOWER_LIMIT; j <= PRINT_UPPER_LIMIT; j++) {
			if (j == 0) {
				freq[j] = -1;
			} else if (freq[j] == i) {
				printf(" * ");
				--freq[j];
			} else {
				printf("   ");
			}
		}
		printf("\n");
	}

	printf("      -");
	for (int i = PRINT_LOWER_LIMIT; i <= PRINT_UPPER_LIMIT; i++) {
		if (freq[i] == 0) {
			printf(" - ");
		}
	}
	
	printf("\n       ");
	for (int i = PRINT_LOWER_LIMIT; i <= PRINT_UPPER_LIMIT; i++) {
                if (freq[i] == 0) {
                        printf(" %c ", i);
                }
        }
}
