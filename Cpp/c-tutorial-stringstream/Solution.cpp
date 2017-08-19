#include <sstream>
#include <vector>
#include <iostream>
using namespace std;

vector<int> parseInts(string str) {
	vector<int> integers = vector<int>();

	int startIndex = 0;
	int endIndex = 1;
	while (endIndex < str.length()) {
		if ( str[endIndex] == ',' ) {
			int newInt = stoi(str.substr(startIndex, endIndex-startIndex));
			integers.push_back(newInt);
			startIndex = endIndex + 1;
			endIndex = startIndex + 1;
		} else {
			endIndex++;
		}
	}

	//whatever is left is the last integer, handle that too
	endIndex++;
	int newInt = stoi(str.substr(startIndex, endIndex-startIndex));
	integers.push_back(newInt);

	return integers;
}

int main() {
    string str;
    cin >> str;
    vector<int> integers = parseInts(str);
    for(int i = 0; i < integers.size(); i++) {
        cout << integers[i] << "\n";
    }
    
    return 0;
}
