#include <iostream>
#include <cstdio>
using namespace std;

void output(string myString) {
	cout << myString << endl;
}

int main() {
	int a, b = 0;
	cin >> a >> b;
	for (int i=a;i<=b;i++) {
		if (i == 1) output("one");
		if (i == 2) output("two");
		if (i == 3) output("three");
		if (i == 4) output("four");
		if (i == 5) output("five");
		if (i == 6) output("six");
		if (i == 7) output("seven");
		if (i == 8) output("eight");
		if (i == 9) output("nine");
		if (i > 9) {
			if ((i % 2) == 0) output("even");
			else output("odd");
		}
	}

	return 0;
}


