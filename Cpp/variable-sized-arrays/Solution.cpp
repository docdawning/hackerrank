//Refs: https://www.hackerrank.com/challenges/variable-sized-arrays

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


void storeArray(vector *intArrays[], int wrapperStoreIndex) {
	int elementCount, thisElement;
	cin >> elementCount;
	vector<int> thisVector(elementCount);
	for (int i=0;i<elementCount;i++) {
		cin >> thisElement;
		thisVector.push_back(thisElement);
	}
	
	intArrays[wrapperStoreIndex] = thisVector;
}

int main() {
    	int n, q;
	cin >> n >> q;

	//store n arrays;
	vector *intArrays[n];
	for (int i=0;i<n;i++) storeArray(intArrays, i);


	//handle q lines	

	return 0;
}
