#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;

void report(string message) {
	cout << message << "\n";
}

int main(){
	int n;
	cin >> n;
	if (n == 1) report("one");
	if (n == 2) report("two");
	if (n == 3) report("three");
	if (n == 4) report("four");
	if (n == 5) report("five");
	if (n == 6) report("six");
	if (n == 7) report("seven");
	if (n == 8) report("eight");
	if (n == 9) report("nine"); 
	if (9 < n) report("Greater than 9"); 

	return 0;
}

