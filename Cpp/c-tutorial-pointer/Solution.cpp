//Refs: https://www.hackerrank.com/challenges/c-tutorial-pointer

#include <stdio.h>
#include <stdlib.h>

void update(int *a, int *b) {
	int aValue = *a;
	int bValue = *b;

	*a = aValue + bValue;
	*b = abs(aValue - bValue);
}

//Feeling rusty with pointers, this was to help me remember.
void swapValues(int *a,int *b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;
    
    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}
