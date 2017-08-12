//Refs: https://www.hackerrank.com/challenges/c-tutorial-strings

#include <iostream>
#include <string>
using namespace std;

int main() {
	string first, second;
	cin >> first >> second;

	cout << first.length() << " " << second.length() << endl;

	cout << first << second << endl;

	char temp = first.at(0);
	first.at(0) = second.at(0);
	second.at(0) = temp;

	cout << first << " " << second << endl;
 
	return 0;
}

