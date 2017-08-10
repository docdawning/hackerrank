#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void printArray(int n, int* array, bool printForward) {
	if (printForward) {
		for (int i=0;i<n;i++) cout << array[i] << " ";
	} else {
		for (int i=n-1;i>=0;i--) cout << array[i] << " ";
	}
	cout << "\n";
}

void printArray(int n, int* array) {
	printArray(n, array, true);
}

int main() {
	int n;
	cin >> n;
	int array[n];
	for (int i=0;i<n;i++) {
		cin >> array[i];
	}

	//prints it forward
	//printArray(n, array);

	printArray(n, array, false);
return 0;
}

