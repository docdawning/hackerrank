//Refs: https://www.hackerrank.com/challenges/variable-sized-arrays

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void storeArray(vector<vector<int> > *intArrays, int wrapperStoreIndex) {
	int elementCount, thisElement;
	cin >> elementCount;
	vector<int> thisVector(0);
	for (int i=0;i<elementCount;i++) {
		cin >> thisElement;
		thisVector.push_back(thisElement);
	}
	intArrays->push_back(thisVector);
}

void printArrays(vector<vector<int> > *arrays) {
	for (int i=0;i<arrays->size();i++) {
		cout << "Array #" << i << ": [";
		int arrayLength = arrays->at(i).size();
		for (int j=0;j<arrayLength;j++) {
			cout << arrays->at(i)[j] << " ";
		}
		cout << "]" << endl;
	}
}

void handleQLine(vector<vector<int> > *vectors) {
	int i, j;
	cin >> i >> j;
	cout << vectors->at(i)[j] << endl;
}

int main() {
    	int n, q;
	cin >> n >> q;

	//store n arrays;
	vector<vector<int> > vectors(0, vector<int>(0));
	for (int i=0;i<n;i++) storeArray(&vectors, i);
	
	//printArrays(&vectors);

	//handle q lines
	for (int i=0;i<q;i++) handleQLine(&vectors);

	return 0;
}
