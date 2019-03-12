#include<stdio.h>
/* print farhetnite and celcius table from 0 celcius to 300 celcius */

int  fahrenite(int x) {
        return 9*x/5 + 32;
}


int main() {
	int x = 0;
	for (; x <= 300; x = x + 20) {
		printf("%3d\t%6d\n", x, fahrenite(x));
	}
}

